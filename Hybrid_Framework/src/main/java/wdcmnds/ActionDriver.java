package wdcmnds;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;

import com.mongodb.MapReduceCommand.OutputType;

import config.StartBrowser;

public class ActionDriver extends StartBrowser 
{
	/**
	 * Navigates to the Application
	 * @param url -- Application URL ex: https://www.google.com 
	 * @throws Exception 
	 */
	public void navigateToApplication(String url) throws Exception
	{
		try
		{
			driver.get(url);
			StartBrowser.childTest.pass("Navigated to Application Successfully");
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("Unable to navigate to Application");
			throw e;
		}
		
	}
	/**
	 * Used to perform click action on buttons,links,radio buttons,check boxes
	 * @param locator -- Get it from Object Repository
	 * @throws Exception 
	 */
	
	public void click(By locator, String eleName) throws Exception
	{
		try
		{
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("performed click action Successfully on  "+eleName);
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("Unable to perform click action on "+eleName);
			throw e;
		}
				
	}
	
	/**
	 * Used to set the values in the edit box
	 * @param locator  -- Get it from Object Repository
	 * @param testdata  -- Get it from Object Repository
	 * @throws Exception 
	 */
	public void setText(By locator, String testdata, String eleName) throws Exception
	{
		try
		{
			driver.findElement(locator).sendKeys(testdata);
			StartBrowser.childTest.pass("performed type in "+eleName+" with data "+testdata);
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("Unable to perform type in "+eleName+" with data "+testdata);
			throw e;
		}
		
	}
	
	public String getText(By locator) throws Exception
	{
		try
		{
			String x = driver.findElement(locator).getText();
			StartBrowser.childTest.pass("Text is : "+x);
			return x;
		}
		catch(Exception e)
		{
			StartBrowser.childTest.fail("Unable to retrive text :");
			return null;
		}
		
	}
	
	
	
}
