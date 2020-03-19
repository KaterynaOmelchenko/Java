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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class Homework5
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
		driver.get("https://www.trademe.co.nz/");
	}
	@Test
	void test() throws InterruptedException
	{
		driver.findElement(By.linkText("Services")).click();
		
		WebElement dropdown1 = driver.findElement(By.id("134"));
		Select s1 = new Select(dropdown1);
		s1.selectByVisibleText("Auckland");
		
		driver.findElement(By.partialLinkText("No thanks")).click();
		
		WebElement dropdown2 = driver.findElement(By.id("193"));
		Select s2 = new Select(dropdown2);
		s2.selectByVisibleText("Events & entertainment");
		
		WebElement dropdown3 = driver.findElement(By.id("209"));
		Select s3 = new Select(dropdown3);
		s3.selectByVisibleText("Photography & video");
		
		driver.findElement(By.name("153")).sendKeys("wedding");
		driver.findElement(By.cssSelector(".standardSearchButton")).click();
		
		List<WebElement> links = driver.findElements(By.partialLinkText("Wedding"));
		
		for (WebElement element: links )
		{
			System.out.println( element.getText() + " : " + element.getAttribute("href") );
		}
		
		System.out.println("The number of links that contains 'Wedding': " + links.size());
		assertTrue(links.size() > 0);
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
