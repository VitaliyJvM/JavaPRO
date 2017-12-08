package ua.kiev.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.concurrent.Callable;

public class UserDAOImpl implements UserDAO {
    private final EntityManager em;

    public UserDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void add(String name, int age) {
        em.getTransaction().begin();
        try {
            User user = new User(name, age);
            em.persist(user);

            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void del(Long userID) {

        final long id = userID;
         performTransaction(new Callable<Void>() {
                public Void call() throws Exception {
                    User other = em.getReference(User.class, id);
                    em.remove(other);
                    return null;
                }
            });

    }

    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    protected <T> T performTransaction(Callable<T> action) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            T result = action.call();
            transaction.commit();

            return result;
        } catch (Exception ex) {
            if (transaction.isActive())
                transaction.rollback();

            throw new RuntimeException(ex);
        }
    }

}
