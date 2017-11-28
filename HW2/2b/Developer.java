package mvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Developer {

	private String name;
	private String surname;
	private List<String> phones = new ArrayList<String>();
	private List<String> sites = new ArrayList<String>();
	private Address address;

	// CONSTRUCTORS
	public Developer() {
		super();
	}

	public Developer(String name, String surname, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
	}

	// GET & SET

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	// Phone
	public String getPhone(int index) {
		return phones.get(index);
	}

	public void addPhone(String phone) {
		this.phones.add(phone);
	}

	public void delPhone(int index) {
		if (index > this.phones.size())
			return;
		if (index < 1)
			return;
		this.phones.remove(index);
	}

    public String getPhones() {
        return Arrays.deepToString(this.phones.toArray());
    }
	
    // Site
    public String getSite(int index) {
		return sites.get(index);
	}
    
	public void addSite(String site) {
		this.sites.add(site);
	}

	public void delSite(int index) {
		if (index > this.sites.size())
			return;
		if (index < 1)
			return;
		this.sites.remove(index);
	}

    public String getSites() {
        return Arrays.deepToString(this.sites.toArray());
    }
	
    // Address
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", surname=" + surname + ", phones=" + phones + ", sites=" + sites
				+ ", address=" + address + "]";
	}

}
