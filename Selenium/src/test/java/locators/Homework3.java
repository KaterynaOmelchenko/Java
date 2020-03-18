package locators;

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

class Homework3
{
	private WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass()
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://duckduckgo.com/");
	}
	@Test
	void test()
	{
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("maven");
		driver.findElement(By.id("search_button_homepage")).click();
		WebElement textbox = driver.findElement(By.id("search_form_input"));
		assertEquals("maven", textbox.getAttribute("value"));
		
		List<WebElement> links = driver.findElements(By.linkText("Apache Maven"));
		int numberOfLinks = links.size();
		System.out.println("Number of links : " + numberOfLinks);
		
		for (WebElement el: links)
		{
			System.out.println(el.getText() + ": " + el.getAttribute("href"));
		}
		
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
