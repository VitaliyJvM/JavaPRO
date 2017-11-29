package mvs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organizations")
@XmlAccessorType(XmlAccessType.NONE)
public class Organizations {

	@XmlElement(name = "organization")
	private List<Organization> list = new ArrayList<Organization>();

	public int size() {
		return list.size();
	}

	public List<Organization> getList() {
		return list;
	}
		
}
