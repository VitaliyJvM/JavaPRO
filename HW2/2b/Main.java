package mvs;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		Developer developer = new Developer("Michael", "Jackson", new Address("Ukraine", "Kiyv", "Khreschatik"));
		developer.addPhone("044-256-78-90");
		developer.addPhone("066-123-45-67");
		developer.addSite("http://site1.com");
		developer.addSite("http://site2.com");
		
		JSONBox.saveToJSONFile(developer, new File("a.gson"));
		
		Developer developerOne = JSONBox.loadFromJSON(new File("a.gson"));
		System.out.println(developerOne);

	}

}
