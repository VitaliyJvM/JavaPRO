package mvs;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		startMenu();

	}

	public static void startMenu() {

		try {
			Source source = new Source();

			String[] options = { "Read data", "Show best rates", "Quit" };
			for (;;) {
				int x = JOptionPane.showOptionDialog(null, "Make your choice", "Main menu", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);

				switch (x) {
				case 0:
					String request = "http://resources.finance.ua/ua/public/currency-cash.xml";
					source = ParserBox.read(request);
					source.showCounters();
					continue;
				case 1:
					source.showBestRates();
					continue;
				case 2:
					break;
				default:
					continue;
				}
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Bye!");

	}

}
