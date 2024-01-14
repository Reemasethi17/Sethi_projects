package hybridDrivenpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainCallingHybridPOM {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		LoginHybridPOM lihp=new LoginHybridPOM(driver);
		LogoutHybridPOM lohp=new LogoutHybridPOM(driver);

		String filename="/Users/reemasethi/Documents/Book1.xlsx";
		FileInputStream fis=new FileInputStream(filename);


		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet datasheet=workbook.getSheet("Data");
		XSSFSheet keywordsheet =workbook.getSheet("Keyword");

		int drows=datasheet.getLastRowNum();
		System.out.println(drows);

		int krows=keywordsheet.getLastRowNum();
		System.out.println(krows);

		for(int r=1;r<=drows;r++)
		{
			XSSFRow drow=datasheet.getRow(r);
			XSSFCell userName=drow.getCell(0);
			XSSFCell Password=drow.getCell(1);
			XSSFCell Result=drow.createCell(2);
			System.out.println("username"+"   "+userName+"   "+"password"+"    "+Password);
			try
			{

			for(int k=1;k<=krows;k++)
			{
				XSSFRow krow=keywordsheet.getRow(k);
				XSSFCell key=krow.getCell(1);
				System.out.println("keyword"+"    "+key);

				switch(key.toString())
				{
				case "url":

					lihp.url();
					break;

				case "enterUserName":

					lihp.enterUserName(userName.toString());
					break;

				case "enterPassword":

					lihp.enterPassword(Password.toString());
					break;

				case "clickOnLogin":

					lihp.clickOnLogin();
					break;

				case "clickOnProfile":

					lohp.clickOnProfile();
					break;

				case "clockOnLogout":

					lohp.clickOnLogout();
					break;

				default:

					System.out.println("invalid choice");


				}

			}
			Result.setCellValue("valid");


			}
			catch(Exception e)
			{
			Result.setCellValue("invalid");
			}
			}

			fis.close();
			FileOutputStream fos=new FileOutputStream(filename);
			workbook.write(fos);
		}

	}

