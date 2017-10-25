package ua.nure.mihaylichenko.Practice4.Part3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
	private static final String FILE_NAME = "part3.txt";
	private static final String ENCODING = "Cp1251";
	private String input = getInput(FILE_NAME, ENCODING);
	
	protected String getInput(String fileName, String encoding) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), encoding);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return sb.toString().trim();
    }
	public String getChar() {
		StringBuilder sb = new StringBuilder("");
		final String regexp = "(\\s|\\A|\\G)(\\w)(\\s|\\z)";
		Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = pattern.matcher(input);
		while (m.find()) {
			sb.append(m.group(2)).append(" ");
		}
		System.out.println();
		return sb.toString().trim();
	}
	public String getString() {
		StringBuilder sb = new StringBuilder("");
		final String regexp = "(\\p{L}{2,})";
		Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = pattern.matcher(input);
		while (m.find()) {
			sb.append(m.group(1)).append(" ");
		}
		return sb.toString().trim();
	}
	public String getInt() {
		StringBuilder sb = new StringBuilder("");
		final String regexp = "(\\s|\\A|\\G)(\\d+)(\\s|\\z)";
		Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = pattern.matcher(input);
		while (m.find()) {
			sb.append(m.group(2)).append(" ");
		}
		return sb.toString().trim();
}
	public String getDouble() {
		StringBuilder sb = new StringBuilder("");
		final String regexp = "((\\d+)(\\.)(\\d+)|(\\.)(\\d+)|(\\d+)(\\.))";
		Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = pattern.matcher(input);
		while (m.find()) {
			sb.append(m.group(1)).append(" ");
	}
		return sb.toString().trim();
	}
	public void getType() {
		Scanner in = new Scanner(System.in, "Cp1251");
		String line;
		while (in.hasNextLine() && !"stop".equals(line = in.nextLine())) {
			if (line.equalsIgnoreCase("char")) {
				System.out.println(getChar());
			}
			else if (line.equalsIgnoreCase("string")) {
				System.out.println(getString());
			}
			else if (line.equalsIgnoreCase("int")) {
				System.out.println(getInt());
			}
			else if (line.equalsIgnoreCase("double")) {
				System.out.println(getDouble());
			}
		}
		in.close();
	}
	public static void main(String[] args) {
		Part3 p3 = new Part3();
		p3.getType();
	}
}

