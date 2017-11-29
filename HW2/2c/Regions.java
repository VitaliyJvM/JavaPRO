package mvs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "regions")
@XmlAccessorType(XmlAccessType.NONE)
public class Regions {

	@XmlElement(name = "region")
	private List<Region> list = new ArrayList<Region>();

	public int size() {
		return list.size();
	}
	
}
