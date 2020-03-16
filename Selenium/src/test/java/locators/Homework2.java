package locators;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

class Homework2
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		driver.get("https://wwww.trademe.co.nz/");
	}
	
	@Test
	void test() throws WebDriverException, IOException
	{
		driver.findElement(By.id("searchString")).sendKeys("milk");
		driver.findElement(By.className("btn")).click();
		//driver.findElement(By.cssSelector(".btn.btn-trademe")).click();
		String actual = driver.findElement(By.name("search")).getText();
		assertEquals("milk", actual);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("milkSearch.png"));
		
		driver.navigate().back();
		
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
	
}
