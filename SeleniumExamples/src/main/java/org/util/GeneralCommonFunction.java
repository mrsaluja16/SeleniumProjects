package org.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralCommonFunction {
	
	public static void main(String args[]) {
		
	}
	
	public static void copyDataProvidedInArgument(String value) {
		StringSelection s = new StringSelection(value);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(s, s);
	}
	
	public static String getDataFromClipboard() throws Exception {
		return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
	}
	
	public static void copyDataAndPasteUsingActions(WebDriver dr, String data) throws Exception{
		copyDataProvidedInArgument(data);
		System.out.println("Copied value is: "+getDataFromClipboard());
		Thread.sleep(3000);
		Actions act = new Actions(dr);
//		Keys cmdOrCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
//		act.contextClick().sendKeys("paste").build().perform();
//		act.keyDown(cmdOrCtrl).sendKeys("v").keyUp(cmdOrCtrl).build().perform();
		act.keyDown(Keys.COMMAND).build().perform();
		act.sendKeys("V").build().perform();
		act.keyUp(Keys.COMMAND).build().perform();
	}
	
	public static int getTodaysDate() {
		return LocalDateTime.now().getDayOfMonth();
	}
	
	public static int getLastDayOfCurrentMonth() {
		return LocalDateTime.now().getMonth().maxLength();
	}
	
	public static void waitForElementToBeDisplayedAndClickable(WebDriver dr, WebElement ele, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
