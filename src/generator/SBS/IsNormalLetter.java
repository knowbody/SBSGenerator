package generator.SBS;
/* Created by Mateusz Zatorski
 * mateuszzatorski@gmail.com
 */

import java.util.HashMap;
import java.util.Map;

public class IsNormalLetter {

	static Map<Character, Character> polishLettersMap;
	static {
		polishLettersMap = new HashMap<Character, Character>();
		polishLettersMap.put('ą', 'a');
		polishLettersMap.put('ę', 'e');
		polishLettersMap.put('ó', 'o');
		polishLettersMap.put('ś', 's');
		polishLettersMap.put('ł', 'l');
		polishLettersMap.put('ż', 'z');
		polishLettersMap.put('ź', 'z');
		polishLettersMap.put('ć', 'c');
		polishLettersMap.put('ń', 'n');

	}

	public static boolean isNormalLetter(int chVal) {
		return (chVal >= 65 && chVal <= 90) || (chVal >= 97 && chVal <= 122);
	}

	public static String substitute(String org) {
		StringBuilder sb = new StringBuilder();
		for (char ch : org.toCharArray()) {
			if (Character.isLetter(ch)) {
				sb.append(isNormalLetter(ch) ? ch : polishLettersMap.get(ch));
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}