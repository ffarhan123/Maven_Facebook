package testNgpack;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSetup.Base;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.ResetPasswordPage;
import utils.Utility;

public class VerifyForgotPasswordPage extends Base
{
	 WebDriver driver;
	 LoginPage loginPage;
	 ForgotPasswordPage forgotPasswordPage;
	String TestID;

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
		forgotPasswordPage = new ForgotPasswordPage(driver);
	}
	
	@BeforeMethod
	public void goToForgotPasswordPage()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		//loginPage = new LoginPage(driver);
		loginPage.clickForgotPassword();                    //first we have written here now
		//forgotPasswordPage = new ForgotPasswordPage(driver);//we have shifted the pom obj to beforeClass
	}
	
	@Test 
	public void verifyTheTextPresentOnForgotPasswordPage() throws IOException
	{
	    TestID = "TC101";
		System.out.println("TC101");
		String actualMessage=forgotPasswordPage.getTextMessage();
		String expectedMessage = "Please enter your email address or mobile number to search for your account.";
		if(actualMessage.equals(expectedMessage))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
	}
	
	
	@Test
	public void verifyCancelButtonOfForgotPasswordPage() throws InterruptedException
	{
		TestID = "TC102";
		System.out.println("TC102");
		Thread.sleep(3000);

		forgotPasswordPage.clickCancelButton();
		String expectedURL="https://www.facebook.com/login.php";
		String expectedTitle = "Log in to Facebook";
		String actualURL = driver.getCurrentUrl();
		String actualTitle = driver.getTitle();
		if(expectedURL.equals(actualURL)  &&  expectedTitle.equals(actualTitle))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
	}
//	@Test
//	public void verifySearchButtonOnForgotPasswordPage() throws InterruptedException
//	{
//		System.out.println("Test3");
//		forgotPasswordPage.sendEmailOrPhoneNumber();
//		forgotPasswordPage.clickSearchButton();
//		ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
//		String actualMessage =resetPasswordPage.getTitleMessageOfResetPasssword();
//		Thread.sleep(2000);
//		String expectedMessage = "Reset Your Password";
//		if(expectedMessage.equals(actualMessage))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
//		
//	}
	@Test(timeOut = 6000)
	public void verifySearchButtonOnForgotPasswordPage() throws InterruptedException
	{
		TestID = "TC104";
		System.out.println("TC104");
		forgotPasswordPage.sendEmailOrPhoneNumber("f.farha112");
		forgotPasswordPage.clickSearchButton();
		Thread.sleep(3000);
		String expectedErrorMessageOfTitle = "No search results";
		String actualErrorMessageOfTitle = forgotPasswordPage.getErrorMessageOfTitle();
		String expectedErrorMessageSub = "Your search did not return any results. Please try again with other information.";
		String actualErrorMessageSub = forgotPasswordPage.getErrorMessageSub();
		if(expectedErrorMessageOfTitle.equals(actualErrorMessageOfTitle)  &&  expectedErrorMessageSub.equals(actualErrorMessageSub))
		{
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
		
	}
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException
	{
		System.out.println("After Method");
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TestID);
		}
		
	}
	
	@AfterClass()
	public void clearObjects()
	{
		System.out.println("After Class");
		loginPage = null;
		forgotPasswordPage = null;
		
	}
	@AfterTest()
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("After Test");
		//Thread.sleep(2000);
		driver.quit();
		driver = null;
		System.gc();   //garbage collection
	}
	

}
