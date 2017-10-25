package ua.nure.mihaylichenko.Practice4.Part1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
	private static final String FILE_NAME = "part1.txt";
	private static final String ENCODING = "Cp1251";
	
	public String getInput(String fileName, String encoding) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), encoding);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
           System.err.println(ex.getMessage());
        }
        return sb.toString().trim();
    }
	public String toUpperCase() {
		StringBuilder sb = new StringBuilder("");
		String input = getInput(FILE_NAME, ENCODING);
		final String regexp = "(\\w+)(\\W*)";
		Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
		Matcher m = pattern.matcher(input);
		ArrayList<String> arrList = new ArrayList<String>();
		while (m.find()) {
			StringBuilder res = new StringBuilder("");
			if (m.group(1).length() > 3) {
				res.append(m.group(1).toUpperCase()).append(m.group(2));
				arrList.add(res.toString());
			}
			else {
				res.append(m.group(1)).append(m.group(2));
				arrList.add(res.toString());
			}
		}
		for (int i = 0; i < arrList.size(); i++) {
			sb.append(arrList.get(i));
		}
		return sb.toString().trim();
	}
	public static void main(String[] args) {
		Part1 part1 = new Part1();
		System.out.println(part1.toUpperCase());
	}
}
