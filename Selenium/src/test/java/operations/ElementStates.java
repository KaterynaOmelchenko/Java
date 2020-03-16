package operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

class ElementStates
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
		driver.get("http://book.theautomatedtester.co.uk/");
	}
	
	@Test
	void gettingStates()
	{
		driver.findElement(By.linkText("Chapter1")).click();
		WebElement checkbox = driver.findElement(By.name("selected(1234)"));
		assertTrue(checkbox.isDisplayed());
		assertFalse(checkbox.isSelected());
		checkbox.click();
		assertTrue(checkbox.isSelected());
		
	}
	
	@Test
	void readingInputField()
	{
		WebElement textbox = driver.findElement(By.id("q"));
		textbox.sendKeys("QA5 PASV");
		String text = textbox.getAttribute("value");
		assertEquals("QA5 PASV", text);
		
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
