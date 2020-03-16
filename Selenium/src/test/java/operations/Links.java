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
	void test() throws InterruptedException
	{
			List<WebElement> links = driver.findElements(By.tagName("a"));
	// get the number of links
			int numberOfLinks = links.size();
			System.out.println("The number of links on the home page are " + numberOfLinks);
			
			for (WebElement el: links )
			{
				System.out.println( el.getText()+ " : " + el.getAttribute("href"));
			}
			
			//links.forEach(el -> System.out.println(el.getText() +": " el.getAttribute("href")));
			String link3 = links.get(2).getAttribute("href");
			System.out.println("link number 3 is " + link3);
			driver.get(link3);
			Thread.sleep(4000);
	}
	
	@Test
	void getPageHTML()
	{
		String body = driver.getPageSource();
		System.out.println("Page HTML code ");
		System.out.println(body);
		assertTrue(body.contains("Selenium"));
	}
	
	@AfterEach
	void tearDownt() throws Exception
	{
		driver.quit();
	}
}
