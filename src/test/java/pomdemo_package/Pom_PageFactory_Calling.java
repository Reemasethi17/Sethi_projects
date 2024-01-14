package pomdemo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pom_PageFactory_Calling {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		LoginPage_PageFactory lpf=new LoginPage_PageFactory(driver);
		lpf.url();
		lpf.emailid("admin@yourstore.com");
		lpf.password("admin");
		lpf.submit();

		Logout_pagefactory lof=new Logout_pagefactory(driver);
		lof.logout();


	}

}
