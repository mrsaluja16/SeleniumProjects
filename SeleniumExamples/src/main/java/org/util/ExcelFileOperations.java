package org.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileOperations {
	
	public static List<ArrayList<String>> getExcelFileData(File file, int sheetNum) throws Exception{
		int totalRow = 0;
		int totalCell = 0;
		List<ArrayList<String>> excelData = new ArrayList<ArrayList<String>>(); 
		totalRow = getMaxRowNumber(file, sheetNum);
		totalCell = getMaxCellNumber(file, sheetNum, 0);
		for(int row=1; row<totalRow; row++) {
			for(int cell=0; cell<totalCell; cell++) {
				String value = getCellData(file, sheetNum, row, cell);
				System.out.println("Value at ["+row+"]["+cell+"] is: "+value);
				//Error is coming... Please have a look.
				excelData.get(row).add(value);
			}
		}
		return excelData;
	}
	
	public static String getCellData(File file, int sheetNum, int rowNum, int cellNum) throws Exception{
		String cellValue = "";
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetNum);
		XSSFRow row = sheet.getRow(rowNum); 
		XSSFCell cell = row.getCell(cellNum);
		DataFormatter dataFormatter = new DataFormatter();
		cellValue = dataFormatter.formatCellValue(cell);
		workbook.close();
		fis.close();
		return cellValue;
	}
	
	private static Integer getMaxRowNumber(File file, int sheetNum) throws Exception{
		int rowNumber = 0;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetNum);
		rowNumber = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowNumber;
		
	}
	
	private static Integer getMaxCellNumber(File file, int sheetNum, int rowNum) throws Exception{
		int cellNumber = 0;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(sheetNum);
		XSSFRow row = sheet.getRow(rowNum);
		cellNumber = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellNumber;
	}

}
