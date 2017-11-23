package mvs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import javax.swing.JOptionPane;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Save {
}

public class Person {

	@Save
	private boolean sex; // false-female, true-male
	@Save
	private String firstName;
	@Save
	private String lastName;
	@Save
	private String birthDate;
	private long tin;

	// CONSTRUCTORS
	public Person(String firstName, String lastName, boolean sex, String sBirthDate, long tin) {

		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.tin = tin;
		this.birthDate = sBirthDate;

	}

	public Person() {
		super();
		this.firstName = "";
		this.lastName = "";
	}

	// GET & SET
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getBirthDateToString() {
		if (birthDate == null)
			return "";
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public long getTin() {
		return tin;
	}

	public void setTin(long tin) {
		this.tin = tin;
	}

	@Override
	public String toString() {
		return "Person: [" + getFirstName() + " " + getLastName() + ", sex = " + ((isSex()) ? "male" : "female")
				+ ", TIN = " + getTin() + ", date of birth: " + getBirthDate() + "]";
	}

	public static Person initializePerson() {

		Person personOne;
		for (;;) {
			try {
				int a = Integer.valueOf(JOptionPane.showInputDialog("Input person#:"));

				switch (a) {
				case 0:
					personOne = new Person();
					break;
				case 1:
					personOne = new Person("Mike", "Davidson", true, "", 0L);
					break;
				case 2:
					personOne = new Person("John", "Douwn", true, "17/07/1989", 0L);
					break;
				case 3:
					personOne = new Person("Karla", "Volkova", false, "24/02/1973", 0L);
					break;
				case 4:
					personOne = new Person("Alex", "Konovalov", true, "15/03/1991", 0L);
					break;
				default:
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			}
		}
		return personOne;

	}

	public static void save(Person p) {

		String path = "d:\\file.txt";

		try (PrintWriter pw = new PrintWriter(path)) {

			try {
				Field[] fields = p.getClass().getDeclaredFields();
				for (Field f : fields) {
					if (f.isAnnotationPresent(Save.class)) {
						pw.println(f.getName() + "=" + f.get(p));
					}
				}
				System.out.println("Fields was saved!");

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Person read() {

		String path = "d:\\file.txt";
		Person p = new Person();

		try (BufferedReader f = new BufferedReader(new FileReader(path))) {
			String strFile = "";

			for (; (strFile = f.readLine()) != null;) {
				String[] fieldvalue = strFile.split("=");

				if (fieldvalue.length != 2)
					continue;

				switch (fieldvalue[0]) {
				case "sex":
					p.setSex(fieldvalue[1].equals("false") ? false : true);
					continue;
				case "firstName":
					p.setFirstName(fieldvalue[1]);
					continue;
				case "lastName":
					p.setLastName(fieldvalue[1]);
					continue;
				case "birthDate":
					p.setBirthDate(fieldvalue[1]);
					continue;
				default:
					continue;
				}

			}

		} catch (IOException e) {
			// System.out.println("ERROR");
			e.printStackTrace();
		}
		System.out.println("Fields was read!");
		return p;

	}

}
