package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.ChooseTopicsScreen;
import screens.LoginScreen;

public class FlipboardLoginTest extends TestBase{
	
	LoginScreen login;
	ChooseTopicsScreen topicScreen;
	
	@BeforeTest
	public void init()
	{
		setUp();
		login = new LoginScreen(driver);
		topicScreen = new ChooseTopicsScreen(driver);
		
	}
	@Test(priority=1)
	public void validateGetStartedBtn()
	{
		login.clickGetStartedBtn();
		Assert.fail("Failing the test");
	}
	@Test(priority=2)
	public void chooseTopicsTest()
	{
		topicScreen.chooseTopics(4).clickContinue().clickPrimaryContinue().clickPrimaryContinueBtn().skipLogin();
		
	}
	
	@AfterTest
	public void quitDriver()
	{
		quit();
	}

}
