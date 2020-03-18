package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
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

class SwitchingWindows
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
		driver.get("http://the-internet.herokuapp.com/windows");
	}
	@Test
	void test()
	{
		String tab1 = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		String tab2 = "";
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String el: allWindows)
		{
			if (!el.equals(tab1))
				tab2 = el;
		}
		
		driver.switchTo().window(tab2);
		assertEquals("New Window", driver.getTitle());
		
		driver.switchTo().window(tab1);
		driver.close();
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
