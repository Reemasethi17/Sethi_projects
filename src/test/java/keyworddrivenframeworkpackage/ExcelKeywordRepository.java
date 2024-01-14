package keyworddrivenframeworkpackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelKeywordRepository {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		OrangeLoginPOM olip=new OrangeLoginPOM(driver);
		OrangleLogoutPOM olop=new OrangleLogoutPOM(driver);

		String filename="/Users/reemasethi/Documents/Book1.xlsx";
		FileInputStream fis=new FileInputStream(filename);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Keyword");

		int rows=sheet.getLastRowNum();
		System.out.println(rows);

		for(int i=1;i<=rows;i++)
		{
			XSSFRow row=sheet.getRow(i);
			XSSFCell key=row.getCell(1);

			System.out.println("keyword"+"     "+key);

			switch(key.toString())
			{
			case "url":
			{
				olip.url();
				break;
			}
			case "enterUserName":
			{
				olip.enterUserName("Admin");
				break;
			}
			case "enterPassword":
			{
				olip.enterPassword("admin123");
				break;
			}
			case "clickOnLogin":
			{
				olip.clickOnLogin();
				break;
			}
			case "clickOnProfile":
			{
				olop.clickOnProfile();
				break;
			}
			case "clickOnLogout":
			{
				olop.clickOnLogout();
				break;
			}
			default:
				System.out.println("invalid input");


			}
		}



	}
}
