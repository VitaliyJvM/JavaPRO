package mvs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currencies")
@XmlAccessorType(XmlAccessType.NONE)
public class Rates {

	@XmlElement(name = "c")
	private List<Rate> list = new ArrayList<Rate>();

	public int size() {
		return list.size();
	}

	public List<Rate> getList() {
		return list;
	}
	
}
