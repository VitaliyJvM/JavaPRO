package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "title")
@XmlAccessorType(XmlAccessType.NONE)
public class Title {

	@XmlAttribute(name = "value")
	private String value;

	// GET & SET

	public String getValue() {
		return value;
	}

}
