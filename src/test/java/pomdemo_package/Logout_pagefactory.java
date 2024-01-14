package pomdemo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_pagefactory {

	WebDriver driver;
	public Logout_pagefactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Logout") WebElement logoutbtn;

	public void logout()
	{
		logoutbtn.click();
	}

}
