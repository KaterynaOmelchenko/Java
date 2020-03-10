package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultiBrowsers
{
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		Properties prop = new Properties() ;
		prop.load( new FileInputStream("browser.config"));
	}

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test()
	{
		fail("Not yet implemented");
	}
}
