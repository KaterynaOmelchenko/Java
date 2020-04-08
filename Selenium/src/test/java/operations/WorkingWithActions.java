package operations;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

class WorkingWithActions
{
private WebDriver driver;
private Actions builder;
	
	@BeforeAll
	static void setUpBeforeClass()
	{
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void setUp()
	{
		driver = new ChromeDriver();
		builder = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	void moveMouseWithAlert()
	{
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
		WebElement mouseOver = driver.findElement(By.id("hoverOver"));
		builder.moveToElement(mouseOver).perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	void moveMouseByOffset()
	{
		driver.get("http://webminal.org");
		WebElement button = driver.findElement(By.linkText("Register"));
		builder.moveByOffset(button.getLocation().getX() + 6 , button.getLocation().getY() + 6)
			.click().perform();
		assertEquals("Join", driver.findElement(By.xpath("//h2")).getText());
	}
	
	@Test
	void dragAndDrop()
	{
		driver.get("https://demoqa.com/droppable/");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		builder.dragAndDrop(source, target).perform();;
		assertEquals("Dropped!", target.getText());
	}
	
	@Test
	void dragByOffset()
	{
		driver.get("https://demoqa.com/droppable/");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		int xSource = source.getLocation().getX();
		int ySource = source.getLocation().getY();
		
		int xTarget = target.getLocation().getX();
		int yTarget = target.getLocation().getY();
		
		int xMove = xTarget - xSource + 10;
		int yMove = yTarget - ySource + 10;
		
		builder.dragAndDropBy(source, xMove, yMove).perform();
		
	}
	
	@AfterEach
	void tearDown()
	{
		//driver.quit();
	}
}
