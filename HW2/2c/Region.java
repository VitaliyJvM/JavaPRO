package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "region")
@XmlAccessorType(XmlAccessType.NONE)
public class Region {

	@XmlAttribute(name = "id")
	private String id;
	@XmlAttribute(name = "title")
	private String title;

}
