package mvs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.NONE)
public class Organization {

	@XmlAttribute(name = "id")
	private String id;
	
	@XmlAttribute(name = "oldid")
	private String oldid;
	
	@XmlAttribute(name = "org_type")
	private String org_type;
	
	@XmlElement(name = "title")
	private Title title;
	
	@XmlElement(name = "branch")
	private Branch branch;
	
	@XmlElement(name = "region")
	private OrgRegion region;	
	
	@XmlElement(name = "city")
	private OrgCity city;
	
	@XmlElement(name = "phone")
	private Phone phone;
	
	@XmlElement(name = "address")
	private Address address;
	
	@XmlElement(name = "link")
	private Link link;	
	
	@XmlElement(name = "currencies")
	private Rates rates;	

	// GET & SET
	
	public Title getTitle() {
		return title;
	}
	
	public Rates getRates() {
		return rates;
	}

}
