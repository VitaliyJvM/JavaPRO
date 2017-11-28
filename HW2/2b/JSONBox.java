package mvs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class JSONBox {

	public static void saveToJSONFile(Developer developer, File file) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String gsonSt = gson.toJson(developer);
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(gsonSt);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static Developer loadFromJSON(File file) {
		Gson gson = new Gson();
		Developer developer = null;
		try {
			developer = gson.fromJson(new FileReader(file), Developer.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return developer;
	}

}
