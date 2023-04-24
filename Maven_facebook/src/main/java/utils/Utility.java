package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	public static void captureScreenshot(WebDriver driver,String TestID) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		Date currentDate = new Date();
		//System.out.println(currentDate);
		String str =currentDate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(str);
		
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\hp\\Pictures\\eclipse ss\\New folder\\Test "+TestID+" "+str+".jpeg");
		FileHandler.copy(src, dest);
		
	}
	public static String getExcelData(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		String path = "C:\\Users\\hp\\Documents\\velocity imp\\Book1.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data;
		try
		{
			data=cell.getStringCellValue();
		}
		catch(IllegalStateException e)
		{
			double value  =cell.getNumericCellValue();
			System.out.println(value);
			 data =String.valueOf(value);
			 data =Double.toString(value);
		}
		return data;
	}

}
