package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.NONE)
public class Rate {

	@XmlAttribute(name = "id")
	private String id;

	@XmlAttribute(name = "br")
	private String br;

	@XmlAttribute(name = "ar")
	private String ar;

	public String getId() {
		return id;
	}

	public String getBr() {
		return br;
	}

	public String getAr() {
		return ar;
	}

}
