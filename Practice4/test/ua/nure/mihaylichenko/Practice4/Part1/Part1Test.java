package ua.nure.mihaylichenko.Practice4.Part1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Part1Test {

	Part1 part1;
	@Before
	public void setUp() {
		part1 = new Part1();
	}
	@After
	public void tearDown() {
		part1 = null;
	}
	@Test
	public void testGetInput() {
		final String actual = "������� �����, ������� ������� ���������� ���������� ����� � �������, ������� � ������ ����� ������� ���� �������� ��� �������� ������� (������ �������) ���������� (������� �������)." +
	    System.lineSeparator() + "���� ���������� ��������� ���������� �� �����, �� ���������� ������� ���������, � ������� ��� (����������) ��������.";
		final String expected = part1.getInput("part1.txt", "cp1251");
		assertEquals(actual, expected);
	}
	@Test
	public void testGetInput1() {
		final String actual = "";
		final String expected = part1.getInput("asdd.txt", "cp1251");
		assertEquals(actual, expected);
	}
	@Test
	public void toUpperCase() {
		final String actual = "������� �����, ������� ������� ���������� ���������� ����� � �������, ������� � ������ ����� ������� ���� �������� ��� �������� ������� (������ �������) ���������� (������� �������)."
				+ System.lineSeparator() + "���� ���������� ��������� ���������� �� �����, �� ���������� ������� ���������, � ������� ��� (����������) ��������.";
		final String expected = part1.toUpperCase();
		assertEquals(actual, expected);
	}
	@Test
	public void testMain() {
		Part1.main(new String[0]);
	}
	
}
