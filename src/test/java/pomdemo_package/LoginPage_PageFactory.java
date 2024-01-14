package pomdemo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_PageFactory {

	WebDriver driver;

	public LoginPage_PageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="Email") WebElement email;
	@FindBy(id="Password")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement loginbtn;

	public void url()
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	public void emailid(String em)

	{
		email.clear();
		email.sendKeys(em);
	}
	public void password(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);

	}
	public void submit()
	{
		Assert.assertTrue(loginbtn.isDisplayed());
		loginbtn.click();
	}
}
