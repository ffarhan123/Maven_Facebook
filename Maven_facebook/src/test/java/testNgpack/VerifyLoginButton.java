package testNgpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetup.Base;
import page.IncorrectPasswordPage;
import page.LoginPage;
import page.NullEmailPasswordLoginPage;
 class VerifyLoginButton extends Base
{
	WebDriver driver;
	LoginPage loginPage;
	IncorrectPasswordPage incorrectPasswordPage;
	NullEmailPasswordLoginPage nullEmailPasswordPassPage;
	
	@Parameters("browser")
	@BeforeTest
	public void  openBrowser(String browserName)
	{
		System.out.println("BeforeTest");
		
		if(browserName.equals("Chrome"))
		{
			driver =openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeClass
	public void createPomObject()
	{
		System.out.println("Before Class");
		loginPage = new LoginPage(driver);
		incorrectPasswordPage = new IncorrectPasswordPage(driver);
		nullEmailPasswordPassPage= new  NullEmailPasswordLoginPage(driver);
	}
	@BeforeMethod
	public void goToLoginPage() throws InterruptedException
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
	  //  loginPage = new LoginPage(driver);
	    
		
	}
	@Test
	public void clickOnLoginButton()
	{
		System.out.println("Test1_logIn");
		loginPage.sendEmail("f.farhan1109@gmail.com");
		loginPage.sendPassword("5469874123");
		loginPage.clickLoginButton();
		//IncorrectPasswordPage incorrectPasswordPage = new IncorrectPasswordPage(driver);
		String expectedResult  ="The password that you've entered is incorrect. Forgotten password?";
		String actualResult =incorrectPasswordPage.getIncorrectPasswordText();
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verifyNullEmailPasswordLoginPage() throws InterruptedException
	{
		System.out.println("Test_logIn");
		loginPage.clickLoginButton();
	 //   NullEmailPasswordLoginPage nullEmailPasswordPassPage= new  NullEmailPasswordLoginPage(driver);
	    Thread.sleep(2000);
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Log in to Facebook";
		String expectedMessage ="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualMessage =nullEmailPasswordPassPage.getNullEmailPasswordTextt();
		Assert.assertEquals(actualMessage, expectedMessage);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle);
		soft.assertAll();
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		
				
	}
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("After Method");
	}
	@AfterClass
	public void clearObjects()
	{
		System.out.println("After Class");
		loginPage = null;
		incorrectPasswordPage = null;
		nullEmailPasswordPassPage= null;
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("After Test");
		//Thread.sleep(2000);
		driver.quit();
		driver = null;
		System.gc();   //garbage collection
	}
	
	
	

}
