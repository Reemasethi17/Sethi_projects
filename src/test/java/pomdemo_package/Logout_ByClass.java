package pomdemo_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout_ByClass {

	WebDriver driver;

	public Logout_ByClass(WebDriver driver) {

		this.driver=driver;

	}
	By logoutbtn=By.linkText("Logout");

	public void logout()
	{
		driver.findElement(logoutbtn).click();

	}
}
