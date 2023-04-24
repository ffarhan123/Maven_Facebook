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

import browserSetup.Base;
import module.SignupPage;
import page.ConfirmationPageAfterSignUp;
import page.ForgotPasswordPage;
import page.LoginPage;


public class VerifySignUpPage extends Base
{
	WebDriver driver;
	SignupPage signUpPage;
	LoginPage loginPage;
	ConfirmationPageAfterSignUp confirmationPageAfterSignUp;
	
	@Parameters("browser")
	@BeforeTest()
	public void openBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver =openChromeBrowser();
		}
		
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeClass
	public void createPomObject()
	{
		System.out.println("Before Class");
		loginPage = new LoginPage(driver);
		signUpPage = new SignupPage(driver);
		confirmationPageAfterSignUp = new ConfirmationPageAfterSignUp(driver);
	}
		
	@BeforeMethod
	public void goToSignUpPage()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		//loginPage = new LoginPage(driver);
		loginPage.clickCreateAccount();
		//signUpPage = new SignupPage(driver);
		
	}
	@Test
	public void verifySignUpButtonOnSignUpPage() throws InterruptedException
	{
		System.out.println("Test1_signUp");
		signUpPage.sendFirstName("pedri");
		signUpPage.sendLastName("gonzalez");
		signUpPage.sendMobileNumberOrEmail("9874562301");
		signUpPage.sendNewPassword("Fhbgjk123@");
		signUpPage.selectDayOfBirth();
		signUpPage.selectMonthOfBirth();
		signUpPage.selectYearOfBirth();
		signUpPage.clickCustomOfGender();
		signUpPage.selectPronounOfCostom();
		signUpPage.clickSignUp();
		Thread.sleep(6000);
		//ConfirmationPageAfterSignUp confirmationPageAfterSignUp = new ConfirmationPageAfterSignUp(driver);
		String actualMessageTitle = confirmationPageAfterSignUp.getTitleMessageText();
		String actualErrorMessage = confirmationPageAfterSignUp.getErrorMessageOfConfirmationPageAfterSignUp();
		String expectedMessageTitle = "We need more information";
		String expectedErrorMessage = "We'll take you through a few steps to confirm your account on Facebook.";
		Assert.assertEquals(actualMessageTitle, expectedMessageTitle);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		
	}
//	@Test
//	public void verifyNullEmailPasswordLoginPage() throws InterruptedException
//	{
//		System.out.println("test2");
//	}
		
		
				
	
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("After Method");
	}
	@AfterClass
	public void clearObjects()
	{
		System.out.println("After Class");
		signUpPage = null;
		loginPage = null;
		confirmationPageAfterSignUp = null;
		
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("After Test");
		Thread.sleep(2000);
		driver.quit();
		driver = null;
		System.gc();   //garbage collection
	}
	

}
