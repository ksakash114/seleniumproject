package selenium.pracproject;

import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import BaseClasses.BrowserInitialize;

public class example1 extends BaseTest {

	
	@Test
	public void testcases() throws Exception
	{
		System.out.println("entered testcases");
		BrowserInitialize.getDriver().get("https://www.flipkart.com/");
		Thread.sleep(5000);
	}
}
