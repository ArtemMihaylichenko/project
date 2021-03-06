package ua.nure.mihaylichenko.Practice4.Part4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser implements Iterable<String> {
	
	private String[] array;

	public Parser(String fileName, String encoding) {
		 StringBuilder sb = new StringBuilder();
		 List<String> list = new ArrayList<>();
	        try {
	            Scanner scanner = new Scanner(new File(fileName), encoding);
	            while (scanner.hasNextLine()) {
	                sb.append(scanner.nextLine());
	            }
	            final String regexp = "(\\p{javaUpperCase})([^.\\?!]+)(\\.|\\?!)";
        		Pattern pattern = Pattern.compile(regexp, Pattern.UNICODE_CHARACTER_CLASS);
        		Matcher m = pattern.matcher(sb.toString().trim().replaceAll("\\s+", " "));
        		array = new String[m.groupCount()];
        		while (m.find()) {
        			list.add(m.group(1) + m.group(2) + m.group(3));
        		}
        		scanner.close();
	        } catch (IOException ex) {
	            System.err.println(ex.getMessage());
	        }
	        array = list.toArray(array);
	}

	@Override
	public Iterator<String> iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<String> {
		protected int index = 0;
		protected int lastIndex = -1;
	    public boolean hasNext() { 
	        return index < array.length;
	    }
	 
	    public String next() {
	    	if (index >= array.length) {
	    		throw new NoSuchElementException();
	    	}
	    		lastIndex = index;
	    		index++;
	    	return array[lastIndex];
	    }

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
	}

}