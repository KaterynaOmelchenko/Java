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

class Pagination
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
		driver.get("http://www.amazon.com/gp/goldbox");
	}
	@Test
	void test()
	{
		driver.findElement(By.xpath("//span[11]/div[1]/label[1]")).click();;
		String results = driver.findElement(By.cssSelector("#FilterItemView_all_summary span:nth-child(2)"))
				.getText();
		String[] resultWords = results.split(" ");
		int totalResults = Integer.parseInt(resultWords[3]);
		System.out.println("Total results found " + totalResults);
		
		int resultsDisplayed = Integer.parseInt(resultWords[1].split("-")[1]);
		System.out.println("Displayed results on 1 page " + resultsDisplayed);
		
		int numberOfPages = (int)Math.ceil((double)totalResults/resultsDisplayed);
		System.out.println(numberOfPages);
		
		int actualResults = 0;
		
		for (int i = 1; i <= numberOfPages; i++)
		{
			List<WebElement> visibleResults = driver.findElements(By.className("gridColumn5"));
			actualResults += visibleResults.size();
			System.out.println("Page " + i + " visible results  " + visibleResults.size());
			if (i == numberOfPages)
				break;
			driver.findElement(By.linkText("Next→")).click();
		}
		assertEquals(totalResults, actualResults);
	}
	
	@AfterEach
	void tearDown()
	{
		driver.quit();
	}
}
