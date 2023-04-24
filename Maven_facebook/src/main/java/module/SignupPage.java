package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage 
{
	@FindBy(xpath = "//input[@name='firstname']")      //input[@name='firstname']
	private WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastName;

	@FindBy(xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement MobileNumberOrEmail;
	
	@FindBy(xpath = "//input[@id='password_step_input']")
	private WebElement NewPassword;
	
	@FindBy(xpath = "//select[@id='day']")
	private WebElement DayOfBirth;
	
	@FindBy(xpath = "//select[@id='month']")
	private WebElement MonthOfBirth;
	
	@FindBy(xpath = "//select[@id='year']")
	private WebElement YearOfBirth;
	
	@FindBy(xpath = "(//input[@type='radio'])[3]")
	private WebElement customOfGender;
	
	@FindBy(xpath = "//select[@aria-label='Select your pronoun']")
	private WebElement pronounOfCostom;
	
	@FindBy(xpath = "//input[@name='custom_gender']")
	private WebElement optionalOfGender;
	
	@FindBy (xpath = "(//button[@type='submit'])[2]")
	private WebElement SignUp;
	
	private Select select;
	private WebDriver driver;
	private Actions action;
	
	public SignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendFirstName(String first)
	{
		FirstName.sendKeys(first);
	}
	public void sendLastName(String last)
	{
		LastName.sendKeys(last);
	}
	public void sendMobileNumberOrEmail(String email)
	{
		 MobileNumberOrEmail.sendKeys(email);
	}
	public void sendNewPassword(String password)
	{
		NewPassword.sendKeys(password);
	}
	public void selectDayOfBirth()
	{
		select = new Select(DayOfBirth);
		select.selectByVisibleText("20");
	}
	public void selectMonthOfBirth()
	{
		select = new Select(MonthOfBirth);
		select.selectByIndex(10);
	}
	public void selectYearOfBirth()
	{
		select = new Select(YearOfBirth);
		select.selectByVisibleText("2007");		
	}
	public void clickCustomOfGender()
	{
	    action = new Actions(driver);
		action.moveToElement(customOfGender).click().build().perform();
		
	}
//	public void clickCustomOfGender()
//	{
//		customOfGender.click();
//	}
	public void selectPronounOfCostom()
	{
		select = new Select(pronounOfCostom);
		select.selectByVisibleText("He: \"Wish him a happy birthday!\"");
	}
	public void sendOptionalOfGender(String gender)
	{
		optionalOfGender.sendKeys(gender);
	}
	public void clickSignUp()
	{
		action = new Actions(driver);
		action.moveToElement(SignUp).click().build().perform();
		
	}

}
