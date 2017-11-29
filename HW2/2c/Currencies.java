package mvs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currencies")
@XmlAccessorType(XmlAccessType.NONE)
public class Currencies {

	@XmlElement(name = "c")
	private List<Currency> list = new ArrayList<Currency>();

	public int size() {
		return list.size();
	}

	public List<Currency> getList() {
		return list;
	}
	
}
