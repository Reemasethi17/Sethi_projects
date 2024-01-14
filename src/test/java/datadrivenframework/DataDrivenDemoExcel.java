package datadrivenframework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DataDrivenDemoExcel {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(5000);

		String filename="/Users/reemasethi/Documents/Book1.xlsx";
		FileInputStream fis=new FileInputStream(filename);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Data");

		int rows= sheet.getLastRowNum();
		System.out.println(rows);

		for(int i=1;i<=rows;i++)
		{
			XSSFRow row = sheet.getRow(i);
			XSSFCell username=row.getCell(0);
			XSSFCell password=row.getCell(1);
			XSSFCell result=row.createCell(2);
			System.out.println("username"+"    "+  username +"    " +"password"+ "    "+   password);



		try
		{
			driver.findElement(By.name("username")).sendKeys(username.toString());
			driver.findElement(By.name("password")).sendKeys(password.toString());
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']//descendant::a[4]")).click();
			Thread.sleep(2000);
			result.setCellValue("valid");
		}
		catch(Exception e)
		{
			result.setCellValue("invalid");
		//String errmsg=	driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
			//result.setCellValue(errmsg);
		}
		}
		fis.close();

		FileOutputStream fos= new FileOutputStream(filename);
		workbook.write(fos);

	}


	}
