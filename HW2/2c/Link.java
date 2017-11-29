package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.NONE)
public class Link {

	@XmlAttribute(name = "type")
	private String type;

	@XmlAttribute(name = "href")
	private String href;

}
