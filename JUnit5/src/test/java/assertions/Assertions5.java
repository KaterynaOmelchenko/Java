package assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Assertions5
{
	@DisplayName("standart assertions")
	@Test
	void test1()
	{
		assertEquals(2, 1 + 1, "sum 1+1 must be 2");
	}
	
	void test2()
	{
		assertTimeout(Duration.ofMillis(10),
				() -> {  Thread.sleep(100); });
	}
}
