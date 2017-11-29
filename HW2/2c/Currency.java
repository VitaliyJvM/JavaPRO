package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.NONE)
public class Currency {

	@XmlAttribute(name = "id")
	private String id;
	@XmlAttribute(name = "title")
	private String title;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}	
	
}
