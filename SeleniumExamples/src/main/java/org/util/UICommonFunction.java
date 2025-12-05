package org.util;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UICommonFunction {
	
	
	public static void hitDownArrowKeyGivennumberOfTimes(WebDriver dr, int howManyTimes) {
		Actions action = new Actions(dr);
		for(int i=1; i<=howManyTimes; i++) {
			action.sendKeys(Keys.ARROW_DOWN);
			action.build().perform();
		}
	}
	
	public static void hitEnterButton(WebDriver dr) {
		Actions act = new Actions(dr);
		act.sendKeys(Keys.ENTER).build().perform();
	}

}
