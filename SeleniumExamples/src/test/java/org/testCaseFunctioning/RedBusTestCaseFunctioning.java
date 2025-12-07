package org.testCaseFunctioning;

import org.openqa.selenium.WebDriver;
import org.pages.RedBusPages;
import org.util.UICommonFunction;

public class RedBusTestCaseFunctioning{
	
	RedBusPages redBusPages;
	
	WebDriver driver;
	
	public RedBusTestCaseFunctioning(WebDriver driver) {
		this.driver = driver;
		redBusPages = new RedBusPages(this.driver);
	}

	/**
	 * 
	 * @implNote This function will enter the values in From: Delhi & To: Jaipur and select the Kashmiri Gate and Sindhi Camp, Jaipur
	 * in the list respectively. Also select the 10th day from today for the Date of journey. Then provides you the travel iternary 
	 * with the cheapest fare.
	 *  
	 */
	public void redBusTestCase(int timeoutValue) throws Exception{
		selectFromAndTo("Delhi", "Jaipur");
		selectJourneyDate(3);
		redBusPages.hitSearchButton();
		Thread.sleep(500);
		redBusPages.priceSortButton(driver, "Ascending", timeoutValue);
		String priceOfResult = redBusPages.getPriceFromFirstResult(driver, timeoutValue);
		System.out.println("Lowest Price is: "+priceOfResult);
	}
	
	
	public void selectFromAndTo(String fromData, String toData) throws Exception {
		int dropDownList = 10;
		Thread.sleep(200);
		boolean fromDataFoundInList = false;
		for(int i=1; i<=dropDownList; i++) {
			redBusPages.sendDataInFromJourey(fromData);
			Thread.sleep(800);
			UICommonFunction.hitDownArrowKeyGivennumberOfTimes(driver, i);
			UICommonFunction.hitEnterButton(driver);
			Thread.sleep(500);
			String dropdownValue = redBusPages.getDataFromJourneyTextbox();
			if(dropdownValue.equalsIgnoreCase("isbt kashmiri gate, delhi")) {
				fromDataFoundInList = true;
				break;
			}
		}
		if(!fromDataFoundInList) {
			throw new Exception("Data you want to select in FROM Journey Textbox is not showing in the List.");
		}
		
		System.out.println("FROM Part is done now moving to TO part");
		
		boolean toDataFoundInList = false;
		for(int i=1; i<=dropDownList; i++) {
			redBusPages.sendDataInToJourey(toData);
			Thread.sleep(800);
			UICommonFunction.hitDownArrowKeyGivennumberOfTimes(driver, i);
			UICommonFunction.hitEnterButton(driver);
			Thread.sleep(500);
			String dropdownValue = redBusPages.getDataToJourneyTextbox();
			if(dropdownValue.equalsIgnoreCase("sindhi camp, jaipur (rajasthan)")) {
				toDataFoundInList = true;
				break;
			}
		}
		if(!toDataFoundInList) {
			throw new Exception("Data you want to select in TO Journey Textbox is not showing in the List.");
		}
	}

	public void selectJourneyDate(int howManyDaysAfterToday) throws Exception{
		redBusPages.selectDateOfJourneyInCalendar(howManyDaysAfterToday);
	}

}
