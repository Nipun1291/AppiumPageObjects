package base;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilities.CommonUtils;

public class TestBase {
	
	
	public AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "Android_flipboard.properties";
	public static Logger log = Logger.getLogger(TestBase.class);
	/*
	 * 
	 * public void takeScreenshot() { Date d = new Date(); String fileName =
	 * d.toString().replace(":", "_").replace(" ", "_")+".jpg"; File srcFile =
	 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * try { FileUtils.copyFile(srcFile, new
	 * File(System.getProperty("user.dir")+"/reports/"+fileName)); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
	
	@BeforeMethod
	public void setUp()
	{
		if(driver==null)
		{
			PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/properties/log4j.properties");
		    
			if(loadPropertyFile.startsWith("Android_"))
			{
				CommonUtils.loadAndroidConfProp(loadPropertyFile);
				log.info(loadPropertyFile+" properties file loaded !!!");
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
				
			}else if(loadPropertyFile.startsWith("IOS_")){
				
			}
		
		}
	}

   public void quit() 
   {
	   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   driver.quit(); 
	   log.info("Test case execution completed");
	  
   }

}
