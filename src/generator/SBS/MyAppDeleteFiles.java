package generator.SBS;

/* Created by Mateusz Zatorski
 * mateuszzatorski@gmail.com
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAppDeleteFiles {

	public MyAppDeleteFiles() throws IOException {

		String[] lines = AppGUI.getNote().getText().split("\\n");

		Writer w = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("czysc_konta.cmd"), "UTF-8"));

		for (int j = 0; j < lines.length; j++) {

			/*
			 * delete more than one space between words and from the full name
			 * create a short one first letter of name and surname after all
			 * lowercase like on example: John Smith = jsmith
			 */
			if (lines[j] == null || lines[j].equals("")) {

				// if there is a gap between the names do nothing

			} else {
				lines[j] = lines[j].trim().replaceAll(" +", " ");
				Pattern pattern = Pattern.compile("\\s([A-Za-ząćęłńóśźżĄĘŁŃÓŚŹŻ]+)");
				Matcher matcher = pattern.matcher(lines[j]);
				String shortName = "";
				if (matcher.find()) {
					shortName = (lines[j].charAt(0) + matcher.group(1))
							.toLowerCase();
					shortName = IsNormalLetter.substitute(shortName);
				}

				w.write("call czysc.cmd PLIKI " + shortName);
				((BufferedWriter) w).newLine();

			}
		}
		w.close();
	}

}
