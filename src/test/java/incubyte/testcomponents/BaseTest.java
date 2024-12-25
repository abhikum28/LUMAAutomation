package incubyte.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import incubyte.pageobjects.HomePage;

public class BaseTest {

	public WebDriver driver;
	private Properties properties;
	private HomePage homePage;
	
	public WebDriver initializeDriver() throws IOException
	{
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\incubyte\\resources\\GlobalData.properties");
		properties.load(fis);
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: properties.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public HomePage launchApplication() throws IOException {
		driver = initializeDriver();
		homePage = new HomePage(driver);
		homePage.goTo(properties.getProperty("baseurl"));
		return homePage;
	}
}
