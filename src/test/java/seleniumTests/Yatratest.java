package seleniumTests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClasses.BaseTest;
import BaseClasses.BrowserInitialize;
import utils.ExtentReportManager;
import utils.Log;

public class Yatratest extends BaseTest {

	
	@Test
	public void selectdates() throws Throwable
	{
		
		Log.info("selectdates initiated");
		test=ExtentReportManager.createtest("browser initialize");
		test.info("browser initialized");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		BrowserInitialize.getDriver().get("https://www.yatra.com/");
		Log.info("opened yatra");
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(3));
		//Thread.sleep(3000);
		//getDriver().switchTo().alert().accept();
		Log.info("alert handeled");
		//waiting for the departure date to be clickable.
		try {
		WebElement popup=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='style_popup__a7PrI MuiBox-root css-0']")));
			if(popup.isDisplayed())
			{
				getDriver().findElement(By.xpath("//img[@alt='cross']")).click();
				Log.info("popup appeared and closed");
			}
		}catch(Exception e)
		{
			Log.info("popup not appeared");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Departure Date inputbox']//div[@class='position-relative MuiBox-root css-0']")));
		Log.info("waited for departure");
		WebElement dateelement = getDriver().findElement(By.xpath("//div[@aria-label='Departure Date inputbox']//div[@class='position-relative MuiBox-root css-0']"));
		//Thread.sleep(3000);
		try
		{
		dateelement.click();
		Log.info("clicked date element");
		}catch(ElementClickInterceptedException e)
		{
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", dateelement);
	        Log.info("Clicked using JavaScript.");
		}
		Log.info("click done");
		List<WebElement> lowestprice=getDriver().findElements(By.xpath("//div[contains(@aria-label,'June')]//span[contains(@class,'custom-day-content')]"));
		Log.info("got list of webelements");
		List<Integer> price = new ArrayList<>();
		for(WebElement findprice:lowestprice)
		{
			//Log.info("entered for loop");
			String newprice=findprice.getText().trim();
			//Log.error("price"+newprice);
			if(!newprice.isEmpty())
			{
				try
				{
					String cleanPrice = newprice.replace("₹", "").replace(",", "").trim();
					price.add(Integer.parseInt(cleanPrice)); 
				}catch(NumberFormatException e)
				{
					Log.error("Number formate exception in price");
				}
			}
			
		}
		Collections.sort(price);
		//System.out.println(price);
		for(WebElement findprice:lowestprice)
		{
			//Log.info("entered for loop");
			String newprice=findprice.getText().trim();
			//Log.error("price"+newprice);
			if(!newprice.isEmpty())
			{
				try
				{
					String cleanPrice = newprice.replace("₹", "").replace(",", "").trim();
					int price1 = Integer.parseInt(cleanPrice);
					if(price1 == price.get(0))
					{
						findprice.click();
						Log.info("click performed on the date");
						//Thread.sleep(3000);
						break;
					}
				}catch(NumberFormatException e)
				{
					Log.error("click not performed");
				}
			}
			
		}
		
		// reurn date
		
		WebElement returndatelement = getDriver().findElement(By.xpath("//div[@aria-label='Return Date inputbox']//div[@class='position-relative MuiBox-root css-0']"));
		//Thread.sleep(3000);
		try
		{
			returndatelement.click();
		Log.info("clicked return date element");
		}catch(ElementClickInterceptedException e)
		{
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", returndatelement);
	        Log.info("Clicked return using JavaScript.");
		}
		Log.info("return click done");
		List<WebElement> returnlowestprice=getDriver().findElements(By.xpath("//div[contains(@aria-label,'July')]//span[contains(@class,'custom-day-content')]"));
		Log.info("got list of webelements for return");
		List<Integer> returnprice = new ArrayList<>();
		for(WebElement findprice:returnlowestprice)
		{
			Log.info("entered returned for loop");
			String newprice=findprice.getText().trim();
			Log.error("price"+newprice);
			if(!newprice.isEmpty())
			{
				try
				{
					String cleanPrice = newprice.replace("₹", "").replace(",", "").trim();
					returnprice.add(Integer.parseInt(cleanPrice)); 
				}catch(NumberFormatException e)
				{
					Log.error("Number formate exception in price");
				}
			}
			
		}
		Collections.sort(returnprice);
		//System.out.println(price);
		for(WebElement findprice:returnlowestprice)
		{
			//Log.info("entered for loop");
			String newprice=findprice.getText().trim();
			//Log.error("price"+newprice);
			if(!newprice.isEmpty())
			{
				try
				{
					String cleanPrice = newprice.replace("₹", "").replace(",", "").trim();
					int price1 = Integer.parseInt(cleanPrice);
					if(price1 == returnprice.get(0))
					{
						findprice.click();
						Log.info("click performed on the date");
						//Thread.sleep(3000);
						break;
					}
				}catch(NumberFormatException e)
				{
					Log.error("click not performed");
				}
				System.out.println("new changes");
			}
			
		}
		
		
		
		
	}
}
