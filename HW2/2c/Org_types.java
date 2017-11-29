package mvs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "org_types")
@XmlAccessorType(XmlAccessType.NONE)
public class Org_types {

	@XmlElement(name = "org_type")
	private List<Org_type> list = new ArrayList<Org_type>();

	public int size() {
		return list.size();
	}
	
}
