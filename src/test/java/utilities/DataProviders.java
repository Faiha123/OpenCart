package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String path = "./testdata/LoginData.xlsx";//path to the excel file
		ExcelUtility xlutility = new ExcelUtility(path);//you're getting it from the constructor of ExcelUtily class
		int totalrows = xlutility.getRowCount("Sheet1");
		int totalcolumns = xlutility.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcolumns];
		
		for(int i=1; i<=totalrows; i++) {
			for(int j=0; j<totalcolumns; j++) {
				logindata[i-1][j]= xlutility.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
				
	}
	
	//Dataprovider2
	
	//Dataprovider3
	
	//Dataprovider4.......

}
