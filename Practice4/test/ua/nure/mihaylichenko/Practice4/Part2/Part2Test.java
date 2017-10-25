package ua.nure.mihaylichenko.Practice4.Part2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Part2Test {
	
	Part2 part2;
	@Before
	public void setUp() {
		part2 = new Part2();
	}
	@After
	public void tearDown() {
		part2 = null;
	}
	@Test
	public void testGetInput() {
		part2.getInput("test", "cp1251");
	}
	@Test
	public void testReadFileAndSort() {
		part2.readFileAndSort("testPart2read.txt", "testPart2read.txt");
		String actual = "1 5 10 12";
		String expected = part2.getInput("testPart2read.txt", "cp1251");
		assertEquals(actual, expected);
	}
	@Test
	public void testReadFileAndSort1() {
		part2.readFileAndSort("testPart2read.txt", "test");
	}
	@Test
	public void testSaveDigitToTheFile() {
		part2.saveDigitsToTheFile("testPart2write.txt");
	}
	@Test
	public void testSaveDigitToTheFile1() {
		part2.saveDigitsToTheFile("test");
	}
	@Test
	public void testMain() {
		Part2.main(new String[0]);
	}
	
	}