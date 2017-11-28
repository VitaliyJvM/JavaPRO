package mvs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "train")
@XmlAccessorType(XmlAccessType.NONE)
public class Train {

	private String id;
	private String from;
	private String to;
	private Date departureDate;
	private Date departureTime;

	private String departure;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	// CONSTRUCTORS
	public Train() {
		super();
	}

	public Train(String id, String from, String to, Date date, Date departureTime) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.departureDate = date;
		this.departureTime = departureTime;

		this.departure = timeFormat.format(departureTime);
	}

	public Train(String id, String from, String to, String date, String departureTime) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;

		try {
			this.departureDate = dateFormat.parse(date);
			this.departureTime = timeFormat.parse(departureTime);
			this.departure = departureTime;
		} catch (ParseException e) {
			// e.printStackTrace();
		}
	}

	// GET & SET

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "from")
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@XmlElement(name = "to")
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@XmlElement(name = "date")
	public Date getDepartureDate() {
		return departureDate;
	}

	public String getDepartureDateToString() {
		if (departureDate == null)
			return "";
		return dateFormat.format(departureDate);
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	@XmlElement(name = "departure")
	private String getDeparture() {
		return departure;
	}

	private void setDeparture(String departure) {
		this.departure = departure;
		try {
			this.departureTime = timeFormat.parse(departure);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public String getDepartureTimeToString() {
		return departure;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
		if (departureTime == null) {
			this.departure = "";
		} else {
			this.departure = timeFormat.format(departureTime);
		}
	}

	public void setDepartureTimeString(String departureTime) {
		try {
			this.departureTime = timeFormat.parse(departureTime);
			this.departure = departureTime;
		} catch (ParseException e) {
			// e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", from=" + from + ", to=" + to + ", departure Date=" + getDepartureDateToString()
				+ ", Time=" + getDepartureTimeToString() + "]";
	}

}
