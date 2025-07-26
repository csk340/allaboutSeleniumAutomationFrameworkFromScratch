package DownloadAndUpload;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DwnldAndUpload {
	
	//Get Column Number of Price
	//Get row number of "Apple"
	//Will update the value
	
	
	//**********************************************//
	public int  GetColumnOfPrice(String FileName, String ColumnName, String SheetName ) throws IOException
	{
		FileInputStream fis = new FileInputStream (FileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("Total no. of sheets present in this excel file are: "+workbook.getNumberOfSheets());
		int totalSubSheets = workbook.getNumberOfSheets();
		for (int i=0;i<totalSubSheets;i++)
		{
			String sheetName = workbook.getSheetAt(i).getSheetName();
			if (sheetName.equalsIgnoreCase(SheetName))
			{
				XSSFSheet reqdSheetNumber = workbook.getSheetAt(i);
				Iterator<Row> rowIterate = reqdSheetNumber.iterator();
				Row firstCell= rowIterate.next();
				Iterator<Cell> eachCellIterateofFirstRow =  firstCell.cellIterator();
				int k=1;
				int column=0;
				while (eachCellIterateofFirstRow.hasNext())
				{
					Cell ReqCellOfColumn= eachCellIterateofFirstRow.next();
					if (ReqCellOfColumn.getStringCellValue().equalsIgnoreCase(ColumnName))
					{
						column=k;
						
					}
					k++;	
					
				}
				System.out.println("Your Required Column Number For Price Column is: "+column);
				return column;
			}
		}
		return totalSubSheets;
	}
	
	
	//**********************************************//
	public int getRowsOfApple(String FileName, String Fruit, String SheetName ) throws IOException
	{
		FileInputStream fis = new FileInputStream (FileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("Total no. of sheets present in this excel file are: "+workbook.getNumberOfSheets());
		int totalSubSheets = workbook.getNumberOfSheets();
		for (int i=0;i<totalSubSheets;i++)
		{
			String sheetName = workbook.getSheetAt(i).getSheetName();
			
				XSSFSheet reqdSheetNumber = workbook.getSheet(SheetName);
				
				Iterator <Row> rows = reqdSheetNumber.iterator(); //Sheet is collection of rows
				int k=1;
				int rowIndex=-1;
				while (rows.hasNext())
				{
				Row row = rows.next();
				Iterator <Cell> cells =row.cellIterator();
				while (cells.hasNext())
				{
					Cell cell = cells.next();
					if (cell.getStringCellValue().equalsIgnoreCase(Fruit))
					{
						rowIndex=k;
					}
					k++;
				}
				 System.out.println("Your required row number of Apple is: "+rowIndex);
				
				}
				return rowIndex;
			}
		
		}
	
	
	
	//**********************************************//
	public void updateCells(String FileName, String SheetName, int rowIndex, int column, String updatedValue) throws IOException
	{
		FileInputStream fis = new FileInputStream (FileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("Total no. of sheets present in this excel file are: "+workbook.getNumberOfSheets());
		int totalSubSheets = workbook.getNumberOfSheets();
		for (int i=0;i<totalSubSheets;i++)
		{
			String sheetName = workbook.getSheetAt(i).getSheetName();
			if (sheetName.equalsIgnoreCase(SheetName))
			{
				XSSFSheet reqdSheetNumber = workbook.getSheetAt(i);
				Row rowField = reqdSheetNumber.getRow(rowIndex-1);
				Cell cellField = rowField.getCell(column-1);
				cellField.setCellValue(updatedValue);                //Imp to updated cell value
				
				FileOutputStream fos = new FileOutputStream(FileName);  //To write/update and save our file
				workbook.write(fos);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String FileName = "C:\\Users\\AKASH KULKARNI\\Downloads\\download.xlsx";
	    String SheetName = "Fruits";
		String ColumnName = "Price";
		String Fruit = "Apple";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/upload-download-test/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Download File
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
		//Upload File
		driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("C:\\Users\\AKASH KULKARNI\\Downloads\\download.xlsx");
		
		//Wait for success message show up and wait until it will dismiss
		WebDriverWait waitobj = new WebDriverWait(driver, Duration.ofSeconds(7));
		WebElement text = waitobj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"alert\"] //div[text()=\"Updated Excel Data Successfully.\"]")));
		String toastText = text.getText();
		System.out.println(toastText);
		Assert.assertEquals(toastText, "Updated Excel Data Successfully.");
		waitobj.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role=\"alert\"] //div[text()=\"Updated Excel Data Successfully.\"]")));
		
		//This is most imp as we do all the traversing in one locator using C-P,P-P,P-C all in one Xspath 
	    //To make this below Xpath more generic lets define fruit name and price column globally
		String PriceColumn = driver.findElement(By.xpath("//div[text()=\"Price\"]")).getDomAttribute("data-column-id");
		String actualValue = driver.findElement(By.xpath("//div[text()='"+Fruit+"']/parent::div/parent::div/div[@id='cell-"+PriceColumn+"-undefined']")).getText();
		System.out.println(actualValue);
		//Assert.assertEquals(actualValue, 345);
		
		DwnldAndUpload obj = new DwnldAndUpload();
		obj.GetColumnOfPrice(FileName,ColumnName, SheetName);
		obj.getRowsOfApple(FileName, Fruit, SheetName);
		obj.updateCells(FileName, SheetName, rowIndex, column, "599");
	}

}
