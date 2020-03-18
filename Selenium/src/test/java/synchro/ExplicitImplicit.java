package synchro;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class ExplicitImplicit
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
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	}
	
	@Test
	void test()
	{
		driver.findElement(By.tagName("button")).click();
		
		WebElement helloWorld = new WebDriverWait(driver, 15).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("finish")));
		assertEquals("Hello World!", helloWorld);
		System.out.println(helloWorld);
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
