package mvs;

public class Address {
	
	private String country;
	private String city;
	private String street;
	
	// CONSTRUCTORS	
	public Address() {
		super();
		this.country = "";
		this.city = "";
		this.street = "";		
	}

	public Address(String country, String city, String street) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}
	
	// GET & SET
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Adress [country=" + country + ", city=" + city + ", street=" + street + "]";
	}	

}