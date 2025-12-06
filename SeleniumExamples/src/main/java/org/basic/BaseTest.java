package org.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	public int timeoutValue = 0;
	
	public void openBrowser() throws Exception{
		String browser = FileProperties.getPropertyValue("browser");
		String url = FileProperties.getPropertyValue("url");
		timeoutValue = Integer.parseInt(FileProperties.getPropertyValue("timeout"));
		driver = getDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver(String browser) {
		switch(browser.toLowerCase()) {
			case "chrome" : 
				WebDriverManager.chromedriver().setup();
				return new ChromeDriver();
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				return new EdgeDriver();
				
			default:
				return null;
		} 
	}

}
