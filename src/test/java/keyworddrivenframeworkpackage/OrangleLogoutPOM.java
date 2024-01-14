package keyworddrivenframeworkpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangleLogoutPOM {
	WebDriver driver;

	public OrangleLogoutPOM(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") WebElement profile;
	@FindBy(xpath= "//ul[@class='oxd-dropdown-menu']//descendant::a[4]") WebElement logout;

	public void clickOnProfile() throws InterruptedException
	{
		Thread.sleep(2000);
		profile.click();
		Thread.sleep(2000);
	}
	public void clickOnLogout()
	{
		logout.click();
	}

}
