package org.testcases;

import org.basic.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RunTheTestCase1 extends BaseTest{
	
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
	
	@Test
	public void testCase1() {
		try {
			
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
