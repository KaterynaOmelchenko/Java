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

class TestJenkins1

{ private WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass()
	{
		WebDriverManager.chromedriver().setup();
		
	}
	
	@BeforeEach
	void setUp()
	{
		driver = new ChromeDriver();
		
	}
	@Test
	void test()
	{
		System.out.println("Hi School!");
		driver.get("https://pasv.us/en");
		String welcome = driver.findElement(By.cssSelector(".t480__title.t-title.t-title_xs.t-margin_auto"))
				.getText();
		assertEquals("We teach programming\nand QA", welcome );  
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
