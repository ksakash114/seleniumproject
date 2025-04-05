package selenium.pracproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import BaseClasses.BrowserInitialize;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class example1 extends BaseTest {

	
	@DataProvider(name="Logindata")
	public Object[][] getlogindata() throws IOException
	{
		Log.info("entered dataprovider");
		System.out.println("entered dataprovider");
		String path=System.getProperty("user.dir")+"/Testdata/logindata.xlsx";
		ExcelUtils.readsheet(path, "credentials");
		int rowcount=ExcelUtils.getrowcount();
		Object[][] obj = new Object[rowcount-1][2];
		
		for(int i=1;i<rowcount;i++)
		{
			obj[i-1][0]= ExcelUtils.getcelldata(i,0);
			obj[i-1][1]= ExcelUtils.getcelldata(i,1);
		}
		ExcelUtils.closewoorbook();
		return obj;
	}
	
	@Test(dataProvider="Logindata")
	public void testcases(String usernames,String passwords) throws Exception
	{
		Log.info("test class entred");
		test=ExtentReportManager.createtest("browser initialize");
		test.info("browser initialized");
		Log.info("Logging with " + usernames + ":" + passwords);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		BrowserInitialize.getDriver().get("https://practicetestautomation.com/practice-test-login/");
		//Thread.sleep(5000);
		Assert.assertEquals(getDriver().getTitle(), "Test Login | Practice Test Automation");
		WebElement username=getDriver().findElement(By.id("username"));
		WebElement password=getDriver().findElement(By.id("password"));
		WebElement submit=getDriver().findElement(By.id("submit"));
		Thread.sleep(1000);
		username.sendKeys(usernames);
		Thread.sleep(1000);
		password.sendKeys(passwords);
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(5000);
		Log.info(getDriver().getTitle());
		Assert.assertEquals(getDriver().getTitle(), "Logged In Successfully | Practice Test Automation");	
	}
	
}
