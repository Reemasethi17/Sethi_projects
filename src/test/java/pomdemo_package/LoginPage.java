package pomdemo_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;

	}
	By username=By.id("Email");
	By password=By.id("Password");
	By loginbtn=By.xpath("//button[@type='submit']");

	public void url() throws InterruptedException
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		Thread.sleep(3000);
	}

	public void email_id(String em)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(em);
	}

	public void password(String pw)
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pw);
	}

	public void clickbtn()
	{
		driver.findElement(loginbtn).click();

	}
}
