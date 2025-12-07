package org.testCaseFunctioning;

import org.openqa.selenium.WebDriver;
import org.pages.HerokuAppPages;

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
	
	public void createUserData() {
		
	}
	
	

}
