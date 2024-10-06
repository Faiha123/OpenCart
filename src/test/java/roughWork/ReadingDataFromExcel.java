package roughWork;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException  {
		
		//Excel File-> WorkBook-> Sheets-> Rows -> cells
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		
		//XSSFSheet sheet = workbook.getSheet("Data");
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//first count the rows that contains data
		int totalRows = sheet.getLastRowNum();
		System.out.println("Total Rows: "+totalRows);
		
		//Now count the cells that contains data
		int totalCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cells: "+totalCells);
		
		for(int i=0; i<=totalRows; i++) {
			
			XSSFRow activeRow = sheet.getRow(i);
			
			for(int j=0; j<totalCells; j++) {
				
				XSSFCell currentCell = activeRow.getCell(j);
				System.out.print(currentCell.toString()+"  ");
			}
			System.out.println();
		}
		
		workbook.close();
		fs.close();
		
		
		
		

	}
	
	
	
	
	
	

}
