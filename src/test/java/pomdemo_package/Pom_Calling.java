package pomdemo_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Pom_Calling {
WebDriver driver=null;

	@Parameters("Browser")
	@Test

	public void call_method(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();

		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalid browser");
		}

		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		lp.url();
		lp.email_id("admin@yourstore.com");
		lp.password("admin");
		lp.clickbtn();
	}
}
