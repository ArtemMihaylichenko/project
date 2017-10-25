package ua.nure.mihaylichenko.Practice4.Part3;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Part3Test {
	Part3 part3;
	@Before
	public void setUp() {
		part3 = new Part3();
	}
	@After
	public void tearDown() {
		part3 = null;
	}
	@Test
	public void testGetChar() {
		String actual = "ÿ f ט כ";
		String expected = part3.getChar();
		assertEquals(actual, expected);
	}
	@Test
	public void testGetString() {
		String actual = "bcd פגûא";
		String expected = part3.getString();
		assertEquals(actual, expected);
	}
	@Test
	public void testGetInt() {
		String actual = "432 89";
		String expected = part3.getInt();
		assertEquals(actual, expected);
	}
	@Test
	public void testGetDouble() {
		String actual = "43.43 .98";
		String expected = part3.getDouble();
		assertEquals(actual, expected);
	}
	@Test
	public void testGetInput() {
		part3.getInput("text.txt", "cp1251");
	}
	@Test
	public void testMain() {
		try {
			System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble".getBytes("cp1251")));
			Part3.main(new String[0]);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
