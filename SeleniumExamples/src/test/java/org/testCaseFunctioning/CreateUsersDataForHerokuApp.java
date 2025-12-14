package org.testCaseFunctioning;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.pages.HerokuAppPages;
import org.util.ExcelFileOperations;

public class CreateUsersDataForHerokuApp {
	
	WebDriver driver;
	HerokuAppPages herokuAppPages;
	
	public CreateUsersDataForHerokuApp(WebDriver driver) {
		this.driver = driver;
		herokuAppPages = new HerokuAppPages(driver);
	}
	
	public void login(String username, String password, int timeout) {
		herokuAppPages.login(username, password, timeout);
	}
	
	public void createUserData(File file, int sheetNum, int timeout) throws Exception{
		int totalRowNumber=ExcelFileOperations.getMaxRowNumber(file, sheetNum);
		System.out.println("row max value is: "+totalRowNumber);
//		int total = 2;
		int totalMaxValInRow = 0;
		List<ArrayList<String>> excelData = ExcelFileOperations.getExcelFileData(file, sheetNum);
		for(int i=5; i<totalRowNumber; i++) {
				totalMaxValInRow = excelData.get(i).size();
				String[] value = new String[totalMaxValInRow];
			for(int j=0; j<totalMaxValInRow; j++) {
				value[j] = excelData.get(i).get(j).toString();
			}
			herokuAppPages.createUsers(driver, value, timeout);
		}
	}
	
	

}
