package BaseClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends BrowserInitialize {

	@BeforeMethod
	@Parameters("browser")
	public static void setup(String browser1)
	{
		System.out.println("entered before");
		BrowserInitialize.initbrowser(browser1);
	}
	
	@AfterMethod
	public static void terminatebrowser() {
		BrowserInitialize.terminate();
	}
}
