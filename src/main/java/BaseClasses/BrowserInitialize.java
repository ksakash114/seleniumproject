package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Log;

public class BrowserInitialize {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//public static WebDriver driver;
	
	
	public static void initbrowser(String browser)
	{
		Log.info("Started "+ browser);
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
			//driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
			//driver=new EdgeDriver();
		}else
		{
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
		
		getDriver().manage().window().maximize();
	}
	
	public static WebDriver getDriver() {
        return driver.get();
    }
	

	public static void terminate()
	{
		if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
	}
}
