package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.SignupPage;
import page.ForgotPasswordPage;
import page.LoginPage;

public class Test1 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Documents\\Automation selenium\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://www.facebook.com/");
	    driver.manage().window().maximize();
     	
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.getGetText();
	    loginPage.sendEmail("");
	    loginPage.sendPassword("");
	   // loginPage.clickLoginButton();
	    loginPage.clickForgotPassword();
	    
	    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
	    forgotPasswordPage.getTextMessage();
	    forgotPasswordPage.getTextOfEmailOrPhoneNumber();
	    forgotPasswordPage.clickCancelButton();
	    
	    //loginPage = new LoginPage(driver);
	    loginPage.clickSignUpForFacebook();
	    
	    SignupPage signUpPage = new SignupPage(driver);
	    signUpPage.sendFirstName("pedri");
	    signUpPage.sendLastName("gonzalez");
	    signUpPage.sendMobileNumberOrEmail("f.farh112");
	    signUpPage.selectDayOfBirth();
	    signUpPage.selectMonthOfBirth();
	    signUpPage.selectYearOfBirth();
	    signUpPage.clickCustomOfGender();
	    signUpPage.selectPronounOfCostom();
	    signUpPage.sendOptionalOfGender("male");
	    
	    
	    
	    
	    
	    
	    
	    
		
	}

}
