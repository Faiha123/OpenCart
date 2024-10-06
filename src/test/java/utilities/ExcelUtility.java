package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	//constructor
	public ExcelUtility(String path) {
		
		this.path = path;
		
	}
	
	//Now how many active rows are in the sheet
	public int getRowCount(String sheetName) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		
		workbook.close();
		fi.close();
		return rowCount;
		
	}
	
	
	//Now count the cells
	public int getCellCount(String sheetName, int rownum) throws IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
	}
	
	
	//You will read from excel now
	public String getCellData(String sheetName, int rownum, int column) throws IOException{
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		
		DataFormatter dataformat = new DataFormatter();
		String data;
		try {
			//will return the formatted cell value as a string regardless of the cell value
		data = dataformat.formatCellValue(cell);
		}catch(Exception e) {
			data ="";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	//Now Writing on excel codes
	public void setCellData(String sheetName, int rownum, int column, String data) throws IOException {
		File xlfile = new File(path);
		if(xlfile.exists()) {
		workbook = new XSSFWorkbook();
		fo = new FileOutputStream(path);
		workbook.write(fo);
		}
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		
		if (workbook.getSheetIndex(sheetName)== -1) 
			workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);
		
			if(sheet.getRow(rownum)==null)
				sheet.createRow(rownum);
			row = sheet.getRow(rownum);
			
			cell = row.createCell(column);
			cell.setCellValue(data);
			
		fo = new FileOutputStream(path);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
		
	}
	
	
	
	
	

}
