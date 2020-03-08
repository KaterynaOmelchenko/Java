package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Generic Template")
class Template
{
	@BeforeAll
	static void setUpBeforeClass()
	{
		System.out.println("one time setUp");
	}
	
	@BeforeEach
	void setUp()
	{
		System.out.println("setUp");
	}
	
	@DisplayName("My first test")
	@Test
	void test1()
	{
		System.out.println("test1");
	}
	
	@Test
	void test2()
	{
		System.out.println("test2");
	}
	
	@Disabled("Not ready")
	@Test
	void test3()
	{
		fail();
	}
	
	@AfterEach
	void tearDown()
	{
		System.out.println("tearDown");
	}
	
	@AfterAll
	static void tearDownAfterClass()
	{
		System.out.println("one time tearDown");
	}
}
