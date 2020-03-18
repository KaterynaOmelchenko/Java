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

class Homework4
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
		driver.get("http://demo.automationtesting.in/WebTable.html");
	}
	@Test
	void test()
	{
		
		List<WebElement> headerRow = driver.findElements(By.xpath("//div[@role='columnheader']"));
		
		for (WebElement element: headerRow)
		{
			System.out.println(element.getText());
		}
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@role='row']/div[4]/div"));
		for (WebElement el: list)
		{
			System.out.println(el.getText());
		}
	
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
