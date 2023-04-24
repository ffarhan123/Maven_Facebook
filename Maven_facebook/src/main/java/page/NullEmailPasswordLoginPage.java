package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NullEmailPasswordLoginPage 
{
	@FindBy (xpath ="(//div[@id='loginform']//div)[3]")
	private WebElement nullEmailPasswordText;
	
	@FindBy (xpath = "//div[@id='header_block']//div")
	private WebElement TitleOfNullEmailPasswordLoginPage;
	
	public NullEmailPasswordLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getNullEmailPasswordTextt()
	{
		String str =nullEmailPasswordText.getText();
		return str;
	}
	public String getTitleOfNullEmailPasswordLoginPage()
	{
		String str =TitleOfNullEmailPasswordLoginPage.getText();
		return str;
	}
}
