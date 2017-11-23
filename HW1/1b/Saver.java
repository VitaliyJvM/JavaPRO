package mvs;

import java.io.IOException;
import java.io.PrintWriter;

public class Saver {
	
	public static void save(String path, String text) {

		try (PrintWriter pw = new PrintWriter(path)) {
			pw.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
