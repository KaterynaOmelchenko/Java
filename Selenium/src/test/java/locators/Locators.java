package locators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

class Locators
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
		//ChromeOptions options = new ChromeOptions();
		//options.setPageLoadStrategy(PageLoadStrategy.NONE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.kmart.com/");
	}

	@AfterEach
	void tearDown() throws Exception
	{
		driver.quit();
	}

	@Test
	void test() throws InterruptedException
	{
// class name		
		driver.findElement(By.className("ribbon-kmart-logo")).click();
		
// CSS selectors
		driver.findElement(By.cssSelector("#yourAccount")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
// id
		driver.findElement(By.id("keyword")).sendKeys("milk");
		
// link text
		driver.findElement(By.linkText("Kmart home")).click();
		
// name
		driver.findElement(By.name("keyword")).sendKeys("coke");
		driver.findElement(By.id("goBtn")).click();
		
// tag
		String body = driver.findElement(By.tagName("body")).getText();
		System.out.println(body);
		
// Xpath
		driver.findElement(By.xpath("//a[@class='gnf_tree_junction'][contains(text(),'Shoes')]")).click();;
	}
}
