package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class MultiBrowsers
{
	private static String browser;
	private WebDriver driver;
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		Properties prop = new Properties() ;
		prop.load( new FileInputStream("browser.config"));
		browser = prop.getProperty("browser");
		System.out.println("Browser is " + browser);
	}
	@BeforeEach
	void setUp() throws Exception
	{
		switch(browser)
		{
		case "chrome" ->
					{ System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");
					driver = new ChromeDriver(); }
		case "firefox" ->
					{ System.setProperty("webdriver.geckodriver.driver", "c:/drivers/geckodriver.exe");
					driver = new FirefoxDriver(); }
		case "edge" ->
					{ System.setProperty("webdriver.msedge.driver", "c:/drivers/msedgedriver.exe");
					driver = new EdgeDriver(); }
		}
	}

	@AfterEach
	void tearDown() throws Exception
	{
		driver.quit();
	}

	@Test
	void test()
	{
		driver.get("https://www.selenium.dev/");
		System.out.println("The tittle is " + driver.getTitle() );
	}
}
