package org.testcases;

import java.io.File;

import org.basic.BaseTest;
import org.basic.FileProperties;
import org.openqa.selenium.WebDriver;
import org.testCaseFunctioning.CreateUsersDataForHerokuApp;
import org.testCaseFunctioning.RedBusTestCaseFunctioning;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.util.ExcelFileOperations;

public class RunTheTestCases extends BaseTest{
	
	public static void main(String args[]) {
		try {
			ExcelFileOperations.getExcelFileData(new File(".//src//main//config//excelDataFiles//HerokuappData.xlsx"), 0);
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		try {
		openBrowser();
		this.driver = super.driver;
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			Assert.fail("Failure occured at during loading browser");
		}
	}
	
	
	
	@Test(enabled = false)
	public void redBusTestCase() {
		try {
			driver.get(FileProperties.getPropertyValue("herokuappurl"));
			new RedBusTestCaseFunctioning(driver).redBusTestCase(timeoutValue);
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			Assert.fail("Failure at Test case 1");
		}
	}
	
	@Test
	public void createDataForHerokuappTestCase() {
		try {
			new RedBusTestCaseFunctioning(driver).redBusTestCase(timeoutValue);
			new CreateUsersDataForHerokuApp(driver).login(FileProperties.getPropertyValue("herokuappusername"), 
					FileProperties.getPropertyValue("herokuappPassword"), timeoutValue);
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
			Assert.fail("Failure at Test case 1");
		}
	}
	
	@AfterSuite
	public void tearDown() {
		try {
		Thread.sleep(3000);
		driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}
