package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncorrectPasswordPage
{
	@FindBy (xpath ="(//div[@id='loginform']//div)[8]")
	private WebElement incorrectPasswordText;
	
	public IncorrectPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getIncorrectPasswordText()
	{
		String str =incorrectPasswordText.getText();
		return str;
	}

}
