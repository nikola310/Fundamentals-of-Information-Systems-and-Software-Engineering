package controller.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LanguageChosen {

	private String language;


	public void save(String language) {
		try {
			this.language = language;
			FileOutputStream fileOut = new FileOutputStream(
					"Files\\language.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(language);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String load() {

		try {
			FileInputStream fileIn = new FileInputStream("Files\\language.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			language = (String) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;

		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return null;

		}
		return language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
