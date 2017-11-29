package mvs;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "source")
@XmlAccessorType(XmlAccessType.NONE)
public class Source {

	@XmlAttribute(name = "id")
	private String id;
	
	@XmlAttribute(name = "date")
	private Date date;

	@XmlElement(name = "organizations")
	private Organizations organizations;	

	@XmlElement(name = "org_types")
	private Org_types org_types;	
	
	@XmlElement(name = "currencies")
	private Currencies currencies;
	
	@XmlElement(name = "regions")
	private Regions regions;
	
	@XmlElement(name = "cities")
	private Cities cities;

	@Override
	public String toString() {
		return "Source [id=" + id + ", date=" + date + "]";
	}

	public void showCounters() {
		System.out.println("source id = " + id + " date " + date.toString());
		System.out.println("1 organizations = " + organizations.size());
		System.out.println("2 org_types = " + org_types.size());
		System.out.println("3 currencies = " + currencies.size());
		System.out.println("4 regions = " + regions.size());
		System.out.println("5 cities = " + cities.size());
	}

	public void showBestRates() {

		String curr;
		boolean isQuit = false;
		for (;;) {
			curr = String.valueOf(JOptionPane.showInputDialog("Input currency"));
			if (curr.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You did not input currency!");
				continue;
			}

			if (curr.toLowerCase().equals("exit")) {
				isQuit = true;
				break;
			}

			curr = curr.toUpperCase();
			boolean isCurrency = false;
			for (Currency currency : currencies.getList()) {
				if (curr.equals(currency.getId())) {
					isCurrency = true;
					break;
				}
			}
			if (!isCurrency) {
				JOptionPane.showMessageDialog(null, "There is not such currency in list!");
				continue;
			}
			break;
		}

		if (isQuit)
			return;

		String orgBid = "";
		String orgAsk = "";
		float rateBid = 0;
		float rateAsk = 999999;

		for (Organization organization : organizations.getList()) {

			for (Rate rate : organization.getRates().getList()) {
				if (!curr.equals(rate.getId()))
					continue;

				try {
					float br = Float.valueOf(rate.getBr());
					float ar = Float.valueOf(rate.getAr());
					if (rateBid < br) {
						rateBid = br;
						orgBid = organization.getTitle().getValue();
					}
					if (rateAsk > ar) {
						rateAsk = ar;
						orgAsk = organization.getTitle().getValue();
					}
				} catch (NumberFormatException e) {
					continue;
					// JOptionPane.showMessageDialog(null, "Error number
					// format");
				}
			}
		}

		System.out.println("Best rates for " + curr + " on " + date.toString());
		System.out.println("Bid rates = " + rateBid + " in " + orgBid);
		System.out.println("Ask rates = " + rateAsk + " in " + orgAsk);
	}

}
