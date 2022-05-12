package com.selenium.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	private String filePath;
	
	
	public ExcelDataReader(String filePath){
		this.filePath = filePath;
	}
	
	private XSSFWorkbook getWorkBook() throws IOException {

		File file = new File(filePath);

		// STream the data from file for that we use FileInputStream CLass

		FileInputStream stream = new FileInputStream(file);

		// Instantiate XSSFWorkbook CLass
		XSSFWorkbook wb = new XSSFWorkbook(stream);
		
		return wb;
	}
	
	public String getTestData(String sheetName, int row, int column) throws IOException {
		try {
			XSSFWorkbook wb = getWorkBook();
			XSSFSheet sheet = wb.getSheet(sheetName);
			String data = sheet.getRow(row).getCell(column).getStringCellValue().toString();
			return data;
		}catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int getRowCount(String sheetName) throws IOException {
		XSSFWorkbook wb = getWorkBook();
		XSSFSheet sheet = wb.getSheet(sheetName);
		int row =  sheet.getLastRowNum();
		return row;
		
	}
}
