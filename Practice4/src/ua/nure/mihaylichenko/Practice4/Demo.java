package ua.nure.mihaylichenko.Practice4;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import ua.nure.mihaylichenko.Practice4.Part1.Part1;
import ua.nure.mihaylichenko.Practice4.Part2.Part2;
import ua.nure.mihaylichenko.Practice4.Part3.Part3;
import ua.nure.mihaylichenko.Practice4.Part4.Part4;
import ua.nure.mihaylichenko.Practice4.Part5.Part5;


public class Demo {

	private static final InputStream STD_IN = System.in;

	private static final String ENCODING = "Cp1251";

	public static void main(String[] args) throws IOException {
		System.out.println("=============== PART1 ============");
		Part1.main(args);
		System.out.println("=============== PART2 ============");
		Part2.main(args);
		System.out.print("=============== PART3 ============");
		System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble".getBytes(ENCODING)));
		Part3.main(args);
		System.setIn(STD_IN);
		System.out.println("=============== PART4 ============");
		Part4.main(args);
		System.out.println("=============== PART5 ============");
		System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru".getBytes(ENCODING)));
		Part5.main(args);
	}

}