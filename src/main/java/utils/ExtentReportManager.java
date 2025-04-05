package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.draw.geom.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getReportsIntance() {
		if (extent == null) {
			//String timestamp = new SimpleDateFormat("yyyy-mm-dd HH-MM-SS").format(new Date());
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH-MM-SS"));
			String path = "reports/Extentreports_" + timestamp + ".html";
			ExtentSparkReporter extentsparkreport = new ExtentSparkReporter(path);
			// path*/
			extentsparkreport.config().setDocumentTitle("Automation script");
			extentsparkreport.config().setReportName("Test Exceution Report");
			extent = new ExtentReports();
			extent.attachReporter(extentsparkreport);
		}
		return extent;
	}

	public static ExtentTest createtest(String testname) {
		test = getReportsIntance().createTest(testname);
		return test;
	}
	
	public static String createScreenShot(WebDriver driver,String testname)
	{
		try
		{
		File Srcpath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"./screenshots/image"+testname+".png";
		FileUtils.copyFile(Srcpath, new File(path));
		return path;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
