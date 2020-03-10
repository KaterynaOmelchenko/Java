package ddt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParamiterizedTests
{
//1
	@ParameterizedTest(name = "print palindromes")
	@ValueSource( strings = {"racecar", "radar", "Madam Im Adam"} )
	void valueSourseAsString(String pal)
	{
		System.out.println(pal);
	}
	
//2
	@ParameterizedTest
	@ValueSource( ints = {24, 67, 100} )
	void valueSourseAsInt(int ages)
	{
		assertTrue(ages > 0 && ages <= 100);
	}
	
//3
	@DisplayName("pair of strings")
	@ParameterizedTest
	@CsvSource({ "abc, def", "no password, ", " , no username" })
	void csvWithComa(String username, String password)
	{
		System.out.println("Username: " + username + " Password: " + password);
	}
	
//4
	@ParameterizedTest
	@CsvFileSource(resources = "ddt.csv", numLinesToSkip = 1)
	void ddtTest( int test, String name, String expected)
	{
		System.out.println(test + " " + name + " " + expected);
	}
}
