package mvs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cities")
@XmlAccessorType(XmlAccessType.NONE)
public class Cities {

	@XmlElement(name = "city")
	private List<City> list = new ArrayList<City>();

	public int size() {
		return list.size();
	}

}
