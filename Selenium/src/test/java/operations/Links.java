package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class Links
{
private WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp() throws Exception
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.get("http://kmart.com/");
		driver.get("http://book.theautomatedtester.co.uk/");
		driver.manage().window().maximize();
	}
	
	@Test
	void test()
	{
		List<WebElement> list = driver.findElements(By.tagName("a"));
	// get the number of links
			int numberOfLinks = list.size();
			System.out.println("The number of links on the home page are " + numberOfLinks);
	}
	
	@AfterEach
	void tearDownt() throws Exception
	{
		driver.quit();
	}
}
