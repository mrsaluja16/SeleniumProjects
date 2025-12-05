package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.GeneralCommonFunction;

public class RedBusPages {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[text()='From']/ancestor::div[3]")
	private WebElement fromJourneyButton;
	
	@FindBy(xpath = "//div[text()='To']/ancestor::div[3]")
	private WebElement toJourneyButton;
	
	@FindBy(xpath = "//div[text()='From']/parent::div/div[2]")
	private WebElement fromJourneyTextbox;
	
	@FindBy(xpath = "//div[text()='To']/parent::div/div[2]")
	private WebElement toJourneyTextbox;
	
	@FindBy(xpath = "//div[text()='Date of Journey']")
	private WebElement dateOfJourney;
	
	@FindBy(id = "srcDest")
	private WebElement fromAnToJourneyInput;
	
	@FindBy(xpath = "//div[@role='button' and contains(@aria-label,'Select Date of Journey')]")
	private WebElement dateofJourneyButton;
	
	@FindBy(xpath = "//div[contains(@class,'monthArea')]/i[2]")
	private WebElement nextMonthArrowButton;
	
	String dateDivXpath = "//span[text()='replaceValue']/parent::div";
	
	@FindBy(xpath = "//button[@aria-label='Search buses']")
	private WebElement searchBusesButton;
	
	@FindBy(xpath = "")
	private WebElement a;
	

	public RedBusPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFromJoureyButton() {
		fromJourneyButton.click();
	}
	
	public void clickToJoureyButton() {
		toJourneyButton.click();
	}
	
	public void sendDataInFromJourey(String data) throws Exception{
		fromJourneyButton.click();
		Thread.sleep(200);
		fromAnToJourneyInput.sendKeys(data);
	}
	
	public void sendDataInToJourey(String data) throws Exception{
		toJourneyButton.click();
		Thread.sleep(200);
		fromAnToJourneyInput.sendKeys(data);
	}
	
	public WebElement getFromJoureyButton() {
		return fromJourneyButton;
	}
	
	public WebElement getToJoureyButton() {
		return toJourneyButton;
	}
	
	public String getDataFromJourneyTextbox() {
		return fromJourneyTextbox.getText();
	}
	
	public String getDataToJourneyTextbox() {
		return toJourneyTextbox.getText();
	}
	
	public WebElement getFromJourneyButton() {
		return fromJourneyButton;
	}
	
	public WebElement getToJourneyButton() {
		return toJourneyButton;
	}
	
	public WebElement getDateOfJourneyButton() {
		return dateofJourneyButton;
	}
	
	public void selectDateOfJourneyInCalendar(int howManyDaysFromToday) throws Exception{
		int todayDate = GeneralCommonFunction.getTodaysDate();
		dateofJourneyButton.click();
		int lastDayOfCurrentMonth = GeneralCommonFunction.getLastDayOfCurrentMonth();
		if((todayDate+howManyDaysFromToday)>lastDayOfCurrentMonth) {
			int dateOfNextMonth = (todayDate+howManyDaysFromToday)-lastDayOfCurrentMonth;
			nextMonthArrowButton.click();
			String xpathVal = dateDivXpath.replace("replaceValue", String.valueOf(dateOfNextMonth));
			Thread.sleep(800);
			driver.findElement(By.xpath(xpathVal)).click();
		}
		if((todayDate+howManyDaysFromToday)<lastDayOfCurrentMonth) {
			String xpathVal = dateDivXpath.replace("replaceValue", String.valueOf(todayDate+howManyDaysFromToday));
			Thread.sleep(800);
			driver.findElement(By.xpath(xpathVal)).click();
		}
	}
	
	public void hitSearchButton() {
		searchBusesButton.click();
	}
	
}
