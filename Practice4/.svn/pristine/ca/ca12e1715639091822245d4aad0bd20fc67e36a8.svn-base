package ua.nure.mihaylichenko.Practice4.Part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	Parser parser;
	Iterator<String> iter;
	@Before
	public void setUp() {
		parser = new Parser("part4.txt", "Cp1251");
		iter = parser.iterator();
	}
	@After
	public void tearDown() {
		parser = null;
	}
	@Test (expected = NullPointerException.class)
	public void testParser() {
		parser = new Parser("text.txt", "Cp1251");
	}
	@Test (expected = NoSuchElementException.class)
	public void testNext() {
		iter = parser.iterator();
		for (int i = 0; i < 10; i++) {
			iter.next();
		}
	}
	@Test (expected = UnsupportedOperationException.class)
	public void testRemove() {
		iter.remove();
	}
	

}
