package com.qa.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.qa.base.BasePage;

public class Wait extends BasePage {

	public static FluentWait<WebDriver> getFluentWait() {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		return fluentWait;
	}

	public static boolean waitUntilElementIsPresent(By by) {
		try {
			getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}

	public static boolean waitUntilElementClickable(By by) {
		try {
			getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}
	public static boolean ValidateElementnotVisible(By by) {
		try {
			getFluentWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}
	public static boolean ValidateTextinElement(By by,String text) {
		try {
			getFluentWait().until(ExpectedConditions.textToBePresentInElementLocated(by, text));
		} catch (TimeoutException e) {
			return false;
		}
		return true;
	}


}
