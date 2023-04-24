package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPageAfterSignUp
{
	@FindBy (xpath ="//span[text()='We need more information']")
	private WebElement TitleMessage;
	
	@FindBy (xpath = "(//span//div)[4]")
	private WebElement ErrorMessageOfConfirmationPageAfterSignUp;
	
	public ConfirmationPageAfterSignUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleMessageText()
	{
		String str =TitleMessage.getText();
		return str;
	}
	public String getErrorMessageOfConfirmationPageAfterSignUp()
	{
		String str = ErrorMessageOfConfirmationPageAfterSignUp.getText();
		return str;
	}

}
