package ua.nure.mihaylichenko.Practice4.Part5;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Part5Test {

	Part5 part5;
	@Before
	public void setUp() {
		part5 = new Part5();
	}
	@After
	public void tearDown() {
		part5 = null;
	}
	@Test
	public void testMain() {
		try {
			System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru".getBytes("Cp1251")));
		} catch (UnsupportedEncodingException e) {
			System.err.println(e.getMessage());
		}
		Part5.main(new String[0]);
	}

}
