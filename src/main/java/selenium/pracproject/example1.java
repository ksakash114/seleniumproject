package selenium.pracproject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import BaseClasses.BrowserInitialize;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class example1 extends BaseTest {

	
	/*
	 * @DataProvider(name="Logindata") public Object[][] getlogindata() throws
	 * IOException { Log.info("entered dataprovider");
	 * System.out.println("entered dataprovider"); String
	 * path=System.getProperty("user.dir")+"/Testdata/logindata.xlsx";
	 * ExcelUtils.readsheet(path, "credentials"); int
	 * rowcount=ExcelUtils.getrowcount(); Object[][] obj = new
	 * Object[rowcount-1][2];
	 * 
	 * for(int i=1;i<rowcount;i++) { obj[i-1][0]= ExcelUtils.getcelldata(i,0);
	 * obj[i-1][1]= ExcelUtils.getcelldata(i,1); } ExcelUtils.closewoorbook();
	 * return obj; }
	 */
	
	@Test
	public void testcases() throws Exception
	{
		Log.info("test class entred");
		test=ExtentReportManager.createtest("browser initialize");
		test.info("browser initialized");
		//Log.info("Logging with " + usernames + ":" + passwords);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//BrowserInitialize.getDriver().get("https://practicetestautomation.com/practice-test-login/");
		//Thread.sleep(5000);
		/*
		 * Assert.assertEquals(getDriver().getTitle(),
		 * "Test Login | Practice Test Automation"); WebElement
		 * username=getDriver().findElement(By.id("username")); WebElement
		 * password=getDriver().findElement(By.id("password")); WebElement
		 * submit=getDriver().findElement(By.id("submit")); Thread.sleep(1000);
		 * username.sendKeys(usernames); Thread.sleep(1000);
		 * password.sendKeys(passwords); Thread.sleep(1000); submit.click();
		 * Thread.sleep(5000); Log.info(getDriver().getTitle());
		 * Assert.assertEquals(getDriver().getTitle(),
		 * "Logged In Successfully | Practice Test Automation");
		 * getDriver().switchTo().newWindow(WindowType.TAB); Thread.sleep(2000);
		 * 
		 * WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		 * //wait.until(ExpectedConditions.)
		 * System.out.println("-------------------cookies--------------------");
		 * System.out.println(getDriver().manage().getCookies());
		 * getDriver().manage().deleteAllCookies();
		 * System.out.println(getDriver().manage().getCookies());
		 * getDriver().manage().addCookie(new Cookie("akash", "123"));
		 * System.out.println(getDriver().manage().getCookies());
		 * getDriver().manage().deleteCookieNamed("akash");
		 * getDriver().manage().deleteCookieNamed("abc");
		 * System.out.println(getDriver().manage().getCookies());
		 * System.out.println("-------------------endcookies--------------------");
		 */
		BrowserInitialize.getDriver().get("https://charanbs2004.github.io/Software-Testing/");
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("window.scrollBy(0,500)");
		WebElement dob = getDriver().findElement(By.xpath("//input[@id='dob']"));
	    Thread.sleep(2000);
		dob.sendKeys("03022025");
		Thread.sleep(5000);
		Actions actions = new Actions(getDriver());
		actions.moveToElement(getDriver().findElement(By.xpath("//input[@id='male']"))).click().perform();
		Thread.sleep(5000);
		WebElement dropdown = getDriver().findElement(By.xpath("//select[@id='country']"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("India");
		Thread.sleep(5000);
		TakesScreenshot shot = (TakesScreenshot)getDriver();
		File sourcefile = shot.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshots/newscreen/form.png");
		/*
		 * String datetime = LocalDateTime.now().toString().replace(":", "-"); String
		 * destfile = "./screenshots/newscreen/form"+datetime+".png";
		 */
		FileUtils.copyFile(sourcefile, destfile);
		Thread.sleep(5000);
	}
	
}
