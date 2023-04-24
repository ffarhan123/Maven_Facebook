package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	
	//Variable Declaration
	@FindBy(xpath = "//h2[@class='_8eso']")
	private WebElement GetText;
	
	@FindBy (xpath = "//input[@type='text']")
	private WebElement Email;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = " //button[@name='login']")
	private WebElement LoginButton;
	
	@FindBy (xpath = " //a[text()='Forgotten password?']")
	private WebElement ForgotPassword;
	
	@FindBy (xpath = " //a[text()='Create new account']")
	private WebElement CreateAccount;
	
	@FindBy (xpath = "//a[text()='Sign up for Facebook']")
	private WebElement SignUpForFacebook;
	
	//Variable Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Variable Use
	public void getGetText()
	{
		String str =GetText.getText();
		System.out.println(str);
	}
	public void sendEmail(String email)
	{
		Email.sendKeys(email);
	}
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickLoginButton()
	{
		LoginButton.click();
	}
	public void clickForgotPassword()
	{
		ForgotPassword.click();
	}
	public void clickCreateAccount()
	{
		CreateAccount.click();
	}
	public void clickSignUpForFacebook()
	{
		SignUpForFacebook.click();
	}
	
	//WE CAN ALSO WRITE LIKE THIS
//	public void LoginToApplication()
//	{
//		String str =GetText.getText();
//		Email.sendKeys("f.farhan1109@gmail.com");
//		password.sendKeys("987654321");
//		LoginButton.click();
//		ForgotPassword.click();
//		CreateAccount.click();
//		
//	}
//	

}








