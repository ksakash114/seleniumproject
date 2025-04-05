package selenium.pracproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import BaseClasses.BrowserInitialize;
import utils.ExtentReportManager;

public class example1 extends BaseTest {

	
	@Test
	public void testcases() throws Exception
	{
		test=ExtentReportManager.createtest("browser initialize");
		test.info("browser init");
		BrowserInitialize.getDriver().get("https://www.flipkart.com/");
		Thread.sleep(5000);
		Assert.assertEquals(getDriver().getTitle(), "Filpkart");
	}
	
	@Test
	public void test()
	{
		System.out.println("test2");
	}
}
