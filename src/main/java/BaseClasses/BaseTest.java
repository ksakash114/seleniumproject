package BaseClasses;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;

public class BaseTest extends BrowserInitialize {
	
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeMethod
	@Parameters("browser")
	public static void setup(String browser1)
	{
		//System.out.println("entered before");
		BrowserInitialize.initbrowser(browser1);
		extent=ExtentReportManager.getReportsIntance();
	}
	
	@AfterMethod
	public void teardownreport(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = ExtentReportManager.createScreenShot(getDriver(), result.getName());
			test.fail("take Screen shot on failure",MediaEntityBuilder.createScreenCaptureFromPath(path).build()); 	
		}
		extent.flush();
		BrowserInitialize.terminate();
	}
	
	
	/*
	 * @AfterMethod public static void terminatebrowser() {
	 * BrowserInitialize.terminate(); }
	 * 
	 * 
	 * @BeforeMethod public void setupreport() {
	 * extent=ExtentReportManager.getReportsIntance(); }
	 */
	
	
			
}
