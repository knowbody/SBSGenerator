package generator.SBS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MyApp {

	public static void main(String[] args) throws IOException {

		AppGUI ag = new AppGUI();
		
		String group = JOptionPane.showInputDialog("Enter class:");

		FileInputStream in = new FileInputStream("names.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String[] register = new String[4];

		for (int j = 0; j < register.length; j++) {
			register[j] = br.readLine();
		}
		in.close();

		// String studentName = JOptionPane
		// .showInputDialog("Enter your full name:");
		BufferedWriter w = new BufferedWriter(new FileWriter(
				"create_account.cmd"));
		w.flush();
		w.write("mode con codepage select=1250");
		w.newLine();

		for (int j = 0; j < register.length; j++) {

			/*
			 * delete more than one space between words and from the full name
			 * create a short one first letter of name and surname after all
			 * lowercase like on example: John Smith = jsmith
			 */
			if (register[j] == null || register[j].equals("")) {
				
				// if there is a gap between the names do nothing
				
			} else {
				register[j] = register[j].replaceAll(" +", " ");
				Pattern pattern = Pattern.compile("\\s([A-Za-z]+)");
				Matcher matcher = pattern.matcher(register[j]);
				String shortName = "";
				if (matcher.find()) {
					shortName = (register[j].charAt(0) + matcher.group(1))
							.toLowerCase();
				}

				w.write("call account.cmd " + shortName + " \"" + register[j]
						+ "\" 123 " + "\"" + group + "\"");
				w.newLine();
			}
		}
		w.close();

	}
}
