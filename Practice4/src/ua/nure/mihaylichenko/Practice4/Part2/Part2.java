package ua.nure.mihaylichenko.Practice4.Part2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {
	private static final String FILE_NAME_READ = "part2.txt";
	private static final String FILE_NAME_WRITE = "part2result.txt";
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
	public void saveDigitsToTheFile(String fileName) {
		BufferedWriter fw;
		try {
			fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "cp1251"));
		for (int i = 0; i < 10; i++) {
			int x = (int) Math.round(Math.random() * 50);
			fw.write(x + " "); 
		}
		fw.close();
		}
		catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
	public void readFileAndSort(String fileName, String fileNameWrite){
		String input = getInput(fileName, ENCODING);
		final String regexp = "([0-9]+)(\\s*)";
		Pattern pattern = Pattern.compile(regexp);
		Matcher m = pattern.matcher(input);
		List<Integer> arrList = new ArrayList<Integer>();
		while (m.find()) {
			arrList.add(Integer.valueOf(m.group(1)));
		}
		int[] result = new int[arrList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = arrList.get(i);
		}
		 for (int i = 0; i < result.length; i++) {
	            
	            for (int j = result.length - 1; j > i; j--) {
	                if (result[j] < result[j - 1]) {
	                    int temp = result[j];
	                    result[j] = result[j - 1];
	                    result[j - 1] = temp;
	                }
	            }
	        }
		 try {
			saveToFile(result, fileNameWrite);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	private void saveToFile(int[] arr, String fileNameWrite) throws IOException {
		BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameWrite), "cp1251"));
		for (int i = 0; i < arr.length; i++) {
			fw.write(arr[i] + " ");
		}
		fw.close();
	}
	public void printFiles(String fileNameRead, String fileNameWrite) {
		String input = getInput(fileNameRead, ENCODING);
		System.out.print("input:" );
		System.out.println(input);
		String output = getInput(fileNameWrite, ENCODING);
		System.out.print("output:" );
		System.out.println(output);
	}
	public static void main(String[] args) {
		Part2 part2 = new Part2();
		part2.saveDigitsToTheFile(FILE_NAME_READ);
		part2.readFileAndSort(FILE_NAME_READ, FILE_NAME_WRITE);
		part2.printFiles(FILE_NAME_READ, FILE_NAME_WRITE);
	}
}
