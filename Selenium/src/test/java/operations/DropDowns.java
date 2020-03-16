package operations;

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

class DropDowns
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
		driver.get("http://www.compendiumdev.co.uk/selenium/basic_html_form.html");
	}
	
	@Test
	void test() throws InterruptedException
	{
		WebElement dropDown = driver.findElement(By.name("dropdown"));
		Select s = new Select(dropDown);
		s.selectByVisibleText("Drop Down Item 6");
		s.selectByIndex(1);
		String optionSelected = s.getFirstSelectedOption().getText();
		System.out.println("Currently selected option " + optionSelected);
		
		Thread.sleep(3000);
		
//1
		List<WebElement> list1 = driver.findElements(By.name("dropdown"));
		for (WebElement el: list1)
		{
			System.out.println(el.getText());
		}
//2
		List<WebElement> list2 = s.getOptions();
		for (WebElement el: list2)
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
