package pomdemo_package;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PomCalling {
	@Test
	

	public void pomcalling_method() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		LoginPage lp = new LoginPage(driver);
		Logout_ByClass loc=new Logout_ByClass(driver);
		lp.url();
		lp.email_id("admin@yourstore.com");
		lp.password("admin");
		lp.clickbtn();
		loc.logout();

	}

}
