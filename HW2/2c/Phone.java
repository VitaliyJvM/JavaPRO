package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.NONE)
public class Phone {

	@XmlAttribute(name = "value")
	private String value;

}
