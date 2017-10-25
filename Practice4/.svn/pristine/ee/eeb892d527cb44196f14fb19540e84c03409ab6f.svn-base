package ua.nure.mihaylichenko.Practice4.Part5;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

	private static final String BASE_NAME = "resources";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in, "cp1251");
		String line;
		while (in.hasNextLine() && !"stop".equals(line = in.nextLine())) {
			final String regexp = "(\\w+)(\\s+)(\\w+)";
			Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
			Matcher m = pattern.matcher(line);
			String loc = "";
			String key = "";
			while (m.find()) {
			loc = m.group(3);
			key = m.group(1);
			}
			ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, new Locale(loc));
			System.out.println(bundle.getString(key));
		}
		in.close();
		}
	}