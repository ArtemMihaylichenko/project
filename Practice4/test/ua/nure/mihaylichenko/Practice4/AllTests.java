package ua.nure.mihaylichenko.Practice4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.nure.mihaylichenko.Practice4.Part1.Part1Test;
import ua.nure.mihaylichenko.Practice4.Part2.Part2Test;
import ua.nure.mihaylichenko.Practice4.Part3.Part3Test;
import ua.nure.mihaylichenko.Practice4.Part4.ParserTest;
import ua.nure.mihaylichenko.Practice4.Part4.Part4Test;
import ua.nure.mihaylichenko.Practice4.Part5.Part5Test;

@RunWith(Suite.class)
@SuiteClasses({ Part1Test.class, Part2Test.class, Part3Test.class, Part4Test.class, ParserTest.class, Part5Test.class })
public class AllTests {

}
