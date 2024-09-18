package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	// Data Provider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 
	{
		String path = ".\\testData\\OrangeHRMLoginTestData.xlsx";  // taking xl file  from test data //
		
		ExcelUtilityFile xlutil = new ExcelUtilityFile(path); // creating object for XLUtilityFile //
		
		int totalrows = xlutil.GetRowCount("Sheet1");
		int totalcols = xlutil.GetCellCount("Sheet1", 1);
		
		// created 2 dimensional array which store all rows and columns //
		// both should be equalant 
		// no of rown and columns in excel and in 2 dimensional aray //
		String logindata[][] = new String[totalrows] [totalcols];
		
		for (int i=1; i<=totalrows; i++)   // rows, i=1 bcs ignoring header part
		{
			for (int j=0; j<totalcols; j++)  // colums, starts from 0
			{
				// from the excel getting the cell data by passing rownum and cellnum and store that in 2 dim array //
				// i-1 bcs arrray index starts from 0 // 	 
				logindata[i-1][j] = xlutil.GetCellData("Sheet1", i, j);
			}
		}
		
	return logindata;   // returning 2 dimensional array
		
	}
	
	// we can have many DP methods //
	// DataProvider 2
	
	
	
	
	// DataProvider 3
	
	
	
}
