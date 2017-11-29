package mvs;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ParserBox {

	public static Source read(String request) throws MalformedURLException {

		Source source = new Source();

		try {
			JAXBContext jc = JAXBContext.newInstance(Source.class);
			Unmarshaller u = jc.createUnmarshaller();
			
			URL url = new URL(request);
			source = (Source) u.unmarshal(url);
			
		} catch (JAXBException e) {
			System.out.println("Error occured in reading from file!");
			e.printStackTrace();
		}

		return source;

	}

}
