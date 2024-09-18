// Final excel Utility File to use in every automation //
// creating an utility file or Excel Utils //
// so that whenever we want we can use these methods //
// methods inlcude noofrows, noofcellls, reading data and writing data etc // 	

package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityFile 
{
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	// creating constructor on the above class//
	// passing path in constructor
	// for this we will pass the location path //
	// in every method we no need to pass xcel sheet path again and again //
	public ExcelUtilityFile(String path)
	{
		this.path = path;
	}
	
	// METHOD TO GET ROW COUNT //
	public int GetRowCount(String xlsheet) throws IOException
	{
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);	
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	// METHOD TO GET CELL COUNT IN EXCEL //
	public int GetCellCount(String xlsheet, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum); 
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	// METHOD TO GET CELL DATA IN EXCEL //
	public String GetCellData(String xlsheet, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		String data;
		try
		{
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e)
		{
			data = "";
		}
		
		wb.close();
		fi.close();
		return data; 
	}
	
	// METHOD TO SET CELL DATA IN EXCEL //
	public void SetCellData(String xlsheet, int rownum, int cellnum, String data) throws IOException
	{
		File xlfile = new File(path);
		if (!xlfile.exists())   // if file not exists create new file //
		{
			wb = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			wb.write(fo);
		}
		
		
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		
		// if sheet is not exists then create a new sheet //
		// if sheet index is -1 it means sheet is not exists //
		if (wb.getSheetIndex(xlsheet)==-1)
			wb.createSheet(xlsheet);
		sheet = wb.getSheet(xlsheet);
		
		// if row not exist then create new row //
		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);
		
		cell = row.getCell(cellnum);
		if (cell==null)
		{
			cell = row.createCell(cellnum);
		}
		
		cell.setCellValue(data);
		
		fo = new FileOutputStream(path);
		
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
		
		
	}
	
	// METHOD TO FILL GREEN COLOR //
	public void FillGreenColor(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		style = wb.createCellStyle(); 
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	// METHOD TO FILL RED COLOR //
	public void FillRedColor(String xlfile, String xlsheet, int rownum, int cellnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		style = wb.createCellStyle(); 
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
			
		// updating cell in workbook using fileoutputstream //
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
}
		
	

	