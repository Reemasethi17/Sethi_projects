package keyworddrivenframeworkpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPOM {

	WebDriver driver;

	public OrangeLoginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name="username") WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath= "//button[@type='submit']") WebElement submit;

	public void url() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(2000);
	}

	public void enterUserName(String em)
	{
		username.sendKeys(em);
	}

	public void enterPassword(String pw) throws InterruptedException
	{
		password.sendKeys(pw);
		Thread.sleep(1000);
	}
	public void clickOnLogin()

	{

		submit.click();
	}

}
