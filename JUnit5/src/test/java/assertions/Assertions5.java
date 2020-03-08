package assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Assertions5
{
	@DisplayName("standart assertions")
	@Test
	void test()
	{
		assertEquals(2, 1 + 1, "sum 1+1 must be 2");
		assertTrue(67 > 24);
		assertFalse(1 > 12);
	}
}
