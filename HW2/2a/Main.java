package mvs;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		startMenu();

	}

	public static void startMenu() {

		Terminal terminal = Terminal.read();
		
		String[] options = { "Base of trains", "Search", "Quit" };
		for (;;) {
			int x = JOptionPane.showOptionDialog(null, "Make your choice", "Main menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);

			switch (x) {
			case 0:
				baseMenu(terminal);
				continue;
			case 1:
				Terminal.searchTrain(terminal);
				continue;
			case 2:
				break;
			default:
				continue;
			}
			break;
		}

		Terminal.write(terminal);
		System.out.println("Bye!");

	}

	public static void baseMenu(Terminal terminal) {
		
		String[] options = { "Add", "Show", "Return"};
		for (;;) {
			int x = JOptionPane.showOptionDialog(null, "Make your choice", "Base of trains", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);

			switch (x) {
			case 0:
				Terminal.addMenu(terminal);
				continue;
			case 1:
				terminal.showList();
				continue;
			case 2:
				break;
			default:
				continue;
			}
			break;
		}

	}

}
