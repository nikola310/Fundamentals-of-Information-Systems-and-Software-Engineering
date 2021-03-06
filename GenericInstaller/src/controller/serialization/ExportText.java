package controller.serialization;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ExportText {
	public ExportText(ArrayList<String> parameters, ArrayList<String> panels) {

		File file = new File(System.getProperty("user.dir")
				+ File.separatorChar + "Files" + File.separatorChar + "data"
				+ File.separatorChar + "parameters.txt");
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.newLine();
			out.write("Spisak putanja i odabranih selekcija:");
			out.newLine();
			for (int i = 0; i < parameters.size(); i++) {
				out.write(parameters.get(i));

				if (i != parameters.size() - 1)
					out.newLine();
			}

			out.newLine();
			out.write("Spisak unetih tekstualnih polja, svi moguci pokusaji:");
			out.newLine();
			for (int i = 0; i < panels.size() - 1; i++) {
				if (panels.get(i).length() > panels.get(i + 1).length()) {
					out.write(panels.get(i));

					if (i != panels.size() - 1)
						out.newLine();
				}
			}

			out.write(panels.get(panels.size() - 1));
			out.newLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	}
}
