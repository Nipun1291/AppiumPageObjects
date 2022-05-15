package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import screens.ChooseTopicsScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import utilities.ScrollUtil;

public class TitleSectionTest extends TestBase {
	
	LoginScreen login;
	HomeScreen home;
	
	@BeforeTest
	public void init()
	{
		setUp();
		login = new LoginScreen(driver);
		home = new HomeScreen(driver);
		
	}
	@Test
	public void validateTitle() {
		
		login.clickGetStartedBtn().chooseTopics(4).clickContinue().clickPrimaryContinue().clickPrimaryContinueBtn().skipLogin();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		home.gotoTitleSection();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ScrollUtil.scrollUp(2, (AndroidDriver) driver);
	}
	@AfterTest
	public void quitDriver()
	{
		quit();
	}

}
