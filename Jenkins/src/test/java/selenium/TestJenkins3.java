package selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestJenkins3

{ private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass()
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp()
	{
		String os = System.getProperty("os.name");
		System.out.println("OS name :" + os);
		driver = new ChromeDriver();
		
		
	}
	@Test
	void test()
	{
		System.out.println("Hi Selenium!");
		driver.get("https:\\selenium.dev");
		System.out.println("The title of the page: " + driver.getTitle());
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
