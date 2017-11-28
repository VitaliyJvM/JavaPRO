package mvs;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trains")
@XmlAccessorType(XmlAccessType.NONE)
public class Terminal {

	@XmlElement(name = "train")
	private List<Train> trains = new ArrayList<Train>();

	public static Terminal read() {

		Terminal terminal = new Terminal();

		try {
			File file = new File("d:\\Java\\trains.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Terminal.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			// читабельное форматирование
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// читаем из файла
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			terminal = (Terminal) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			System.out.println("Error occured in reading from file!");
			// e.printStackTrace();
		}

		return terminal;

	}

	public static void write(Terminal terminal) {

		try {
			File file = new File("d:\\Java\\trains.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Terminal.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			// читабельное форматирование
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// пишем в файл
			marshaller.marshal(terminal, file);
			// marshaller.marshal(catalog, System.out);

			// // читаем из файла
			// Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			// catalog = (Catalog) unmarshaller.unmarshal(file);
			// System.out.println(catalog);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void addMenu(Terminal terminal) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

		String id;
		for (;;) {
			id = String.valueOf(JOptionPane.showInputDialog("Input train's id"));
			break;
		}

		String from;
		for (;;) {
			from = String.valueOf(JOptionPane.showInputDialog("Input departure from"));
			break;
		}

		String to;
		for (;;) {
			to = String.valueOf(JOptionPane.showInputDialog("Input departure to"));
			break;
		}

		String departureDate;
		for (;;) {
			departureDate = String.valueOf(JOptionPane.showInputDialog("Input departure date (dd.mm.yyyy)"));
			try {
				dateFormat.parse(departureDate);
				break;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Wrong date format!");
				continue;
			}
		}

		String departureTime;
		for (;;) {
			departureTime = String.valueOf(JOptionPane.showInputDialog("Input departure time (HH:MM)"));
			try {
				timeFormat.parse(departureTime);
				break;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Wrong time format!");
				continue;
			}
		}

		terminal.add(new Train(id, from, to, departureDate, departureTime));

	}

	public static void searchTrain(Terminal terminal) {

		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

		String departureTimeFrom;
		Date timeFrom;
		for (;;) {
			departureTimeFrom = String.valueOf(JOptionPane.showInputDialog("Input departure time from (HH:MM)"));
			try {
				timeFrom = timeFormat.parse(departureTimeFrom);
				break;
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Wrong time format!");
				continue;
			}
		}

		String departureTimeTo;
		Date timeTo;
		for (;;) {
			departureTimeTo = String.valueOf(JOptionPane.showInputDialog("Input departure time to (HH:MM)"));
			try {
				timeTo = timeFormat.parse(departureTimeTo);
				if (timeFrom.compareTo(timeTo) == -1) {
					break;
				}
				JOptionPane.showMessageDialog(null, "'Time to' has to be greater than 'time from'!");
				continue;

			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Wrong time format!");
				continue;
			}
		}

		for (Train train : terminal.trains) {
			if (train.getDepartureTime().compareTo(timeFrom) == -1)
				continue;
			if (train.getDepartureTime().compareTo(timeTo) == 1)
				continue;
			System.out.println(train);
		}

	}

	public void add(Train train) {
		trains.add(train);
	}

	public Train get(int k) {

		if ((k > trains.size()) || (k < 0)) {
			return null;
		}

		return trains.get(k);

	}

	@Override
	public String toString() {
		return Arrays.deepToString(trains.toArray());
	}

	public void showList() {

		for (Train train : trains) {
			System.out.println(train);
		}

	}

}
