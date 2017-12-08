package ua.kiev.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] sUsersID = new String[0];
        try {
            sUsersID = req.getParameterValues("usersID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sUsersID == null) {
            resp.sendRedirect("list");
            return;
        }

        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        UserDAO dao = new UserDAOImpl(em);
        try {
            for (int i=0;i<sUsersID.length;i++) {
                long userId = 0;
                try {
                    userId = Long.parseLong(sUsersID[i]);
                } catch (Exception ex) {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                dao.del(userId);
            }

        } finally {
            em.close();
        }

        resp.sendRedirect("list");
    }
}
