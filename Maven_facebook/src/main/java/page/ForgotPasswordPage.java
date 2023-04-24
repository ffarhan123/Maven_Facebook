package page;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage 
{
		//Variable Declaration
		@FindBy(xpath = "//table//div")
		private WebElement TextMessage;
		
		@FindBy (xpath = "//input[@id='identify_email']")
		private WebElement EmailOrPhoneNumber;
		
		@FindBy (xpath = "//a[text()='Cancel']")
		private WebElement cancelButton;
		
		@FindBy (xpath = "//button[@id='did_submit']")
		private WebElement searchButton;
		
		@FindBy (xpath = "(//form[@id='identify_yourself_flow']//div)[9]")
		private WebElement ErrorMessageOfTitle;
		
		@FindBy (xpath = "(//form[@id='identify_yourself_flow']//div)[10]")
		private WebElement ErrorMessageSub;		
		
		private WebDriver driver;
		
		
		
		//Variable Initialization
		public ForgotPasswordPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		
		//Variable Use
		public String getTextMessage()
		{
			String str =TextMessage.getText();
			System.out.println(str);
			return str;
		}
		public void getTextOfEmailOrPhoneNumber()
		{
			String str = EmailOrPhoneNumber.getAttribute("placeholder");
			System.out.println(str);
		}
		public void sendEmailOrPhoneNumber(String email)
		{
			EmailOrPhoneNumber.sendKeys(email);
		}
		public void clickCancelButton()
		{
			cancelButton.click();
		}
		public void clickSearchButton()
		{
			Actions action = new Actions(driver);
			action.moveToElement(searchButton).click().build().perform();
			//searchButton.click();
		}
		public String getErrorMessageOfTitle()
		{
			String str = ErrorMessageOfTitle.getText();
			return str;
		}
		public String getErrorMessageSub()
		{
			String str = ErrorMessageSub.getText();
			return str;
		}
		
	
	
}	
	 	


