package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.GeneralCommonFunction;

public class HerokuAppPages {
	
	WebDriver driver;
	
	@FindBy(id = "email")
	private WebElement usernameTextbox;
	
	@FindBy(id = "password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "submit")
	private WebElement submitButton;
	
	@FindBy(id = "add-contact")
	private WebElement addNewContactButton;
	
	@FindBy(id = "firstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "lastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "birthdate")
	private WebElement birthdateTextBox;
	
	@FindBy(id = "email")
	private WebElement emailTextBox;
	
	@FindBy(id = "phone")
	private WebElement phoneTextBox;
	
	@FindBy(id = "street1")
	private WebElement street1Textbox;
	
	@FindBy(id = "street2")
	private WebElement street2Textbox;
	
	@FindBy(id = "city")
	private WebElement cityTextbox;
	
	@FindBy(id = "stateProvince")
	private WebElement stateProvinceTextbox;
	
	@FindBy(id = "postalCode")
	private WebElement postalCodeTextbox;
	
	@FindBy(id = "country")
	private WebElement countryTextbox;
	
	@FindBy(id = "submit")
	private WebElement submitAddContactButton;
	
	@FindBy(xpath = "")
	private WebElement a;
	
	public HerokuAppPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password, int timeToWait) {
		GeneralCommonFunction.waitForElementToBeDisplayedAndClickable(driver, usernameTextbox, timeToWait);
		usernameTextbox.clear();
		passwordTextbox.clear();
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		submitButton.click();
	}
	
	public void createUsers(WebDriver dr, String[] userData, int timeout) throws Exception {
		Thread.sleep(500);
		GeneralCommonFunction.waitForElementToBeDisplayedAndClickable(dr, addNewContactButton, timeout);
		addNewContactButton.click();
		GeneralCommonFunction.waitForElementToBeDisplayedAndClickable(dr, firstNameTextbox, timeout);
		firstNameTextbox.sendKeys(userData[0]);
		lastNameTextbox.sendKeys(userData[1]);
		birthdateTextBox.sendKeys(userData[2]);
		emailTextBox.sendKeys(userData[3]);
		phoneTextBox.sendKeys(userData[4]);
		street1Textbox.sendKeys(userData[5]);
		street2Textbox.sendKeys(userData[6]);
		cityTextbox.sendKeys(userData[7]);
		stateProvinceTextbox.sendKeys(userData[8]);
		postalCodeTextbox.sendKeys(userData[9]);
		countryTextbox.sendKeys(userData[10]);
		submitAddContactButton.click();
		GeneralCommonFunction.waitForElementToBeDisplayedAndClickable(dr, addNewContactButton, timeout);
		Thread.sleep(500);
	}
}
