package ddt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
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
	
}
