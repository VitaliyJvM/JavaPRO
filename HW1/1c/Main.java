package mvs;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		doJob();

	}
		
	public static void doJob() {
		
		Person personOne = new Person();
		
		String[] options = {"Initialize", "Save", "Read", "Show", "Quit" };
		for (;;) {
			int x = JOptionPane.showOptionDialog(null, "Make your choice", "Main menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[3]);

			switch (x) {
			case 0:
				personOne = Person.initializePerson();
				continue;
			case 1:
				Person.save(personOne);
				continue;
			case 2:
				personOne = Person.read();
				continue;
			case 3:
				System.out.println(personOne);
				continue;				
			case 4:
				break;
			default:
				continue;
			}
			break;
		}

		System.out.println("Bye!");

	}	

}
