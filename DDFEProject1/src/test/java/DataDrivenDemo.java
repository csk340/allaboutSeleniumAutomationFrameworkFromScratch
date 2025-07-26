import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenDemo {
	
	public ArrayList<String> getData(String TestcaseName) throws IOException
	{
		ArrayList<String> CreateArray = new ArrayList<String>();
		//Step1: Create obj for FIS and give location of excel sheet  
				FileInputStream fis = new FileInputStream("E:\\ExcelDataForTesting\\DataDrivenStep1.xlsx");
				
		//Step2: Create object for XSSF Workbook class:-
				XSSFWorkbook workbook  = new XSSFWorkbook(fis); //So here we cannot simply pass file location as it can't accessible cause Fis object can access that file
            
		//Step3: Pass that location to our XSSFWorkbook object
				
		//Step4: Now we have access to our excel all file but we first need to count total sub-sheets in that file
				int sheet = workbook.getNumberOfSheets();
				
				
				System.out.println(workbook.getNumberOfSheets());
			
				
		// Upto here we have done our Pre-Requisite step. This will common for any problem
				for (int i=0;i<sheet;i++)
				{
				   if (workbook.getSheetName(i).equalsIgnoreCase("ExcelWithDataForDrivenFromSel."))
				 {
					  XSSFSheet RqdSheet = workbook.getSheetAt(i);           // Got Required Sheet which have our required data
					  Iterator<Row> obj = RqdSheet.iterator();               //To iterate through each row of sheet
					  Row FirstRow = obj.next();                             //Here our required row is first one only but we can add that time next() to go to required row
					 Iterator<Cell> iterateRow = FirstRow.cellIterator();    // Here we need to iterate each cell of first row
					int k=0;
					int column = 0;
					 
					 while( iterateRow.hasNext())
					{
						Cell RequiredCellOfFirstRow  = iterateRow.next(); //Moving to each cell of required row one by one 
						                                                  //Again our first cell is only required cell but we can user that time next() to go to required cell
						if (RequiredCellOfFirstRow.getStringCellValue().equalsIgnoreCase("Testcase Name"))
						{
							column=k;
						}
						k++;
					}
					 
					     System.out.println("Your Required Column No. Is: "+column); //Here we got Testcase Name column
					     
					     while(obj.hasNext())
					     {
					    	 Row checkRow= obj.next();
					    	if (checkRow.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) //Important step getStringCellValue
					    	{
					    		Iterator<Cell> AllCellsOfPurchaseRow= checkRow.cellIterator();
					    		while(AllCellsOfPurchaseRow.hasNext())
					    		{
					    			Cell b = AllCellsOfPurchaseRow.next();
					    			if (b.getCellType()==CellType.STRING)
					    			{
					    				CreateArray.add(AllCellsOfPurchaseRow.next().getStringCellValue());
					    			}
					    			else
					    			{
					    				CreateArray.add(NumberToTextConverter.toText(b.getNumericCellValue()));
					    		    // System.out.println(AllCellsOfPurchaseRow.next().getStringCellValue());//We have all the values of purchase row here
					    		     //Now send this values to one array
					    			
					    	    }
					   		
					        }
					                  
				        }
				}
			  }
				
	}
				return CreateArray;


	}
}
