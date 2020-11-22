package com.qa.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.qa.base.BasePage;

public class BrowserInteraction extends Wait {
	BasePage basepage = new BasePage();

	/**
	 * Clicks on the Web element by taking input as Locator
	 * 
	 * @param by
	 */
	public static void clickElementBy(By by) {
		try {
			tryFindElement(by).click();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * Clicks on the Web element using javascript executor taking input as Locator
	 * 
	 * @param by
	 */
	public static void clickusingjavaScriptExecutor(By by) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) getDriver();
			WebElement element = tryFindElement(by);
			executor.executeScript("arguments[0].click()", element);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * Navigates to the required webpage
	 * 
	 * @param by
	 */
	public static void Navigate(String URL) {
		try {
			getDriver().navigate().to(URL);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * verifies the text box
	 * 
	 * @param by
	 */

	public static void Verifytextbox(By by) {
		try {
			tryFindElement(by).isDisplayed();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * verifies the button
	 * 
	 * @param by
	 */

	public static void VerifyButton(By by) {
		try {
			tryFindElement(by).isEnabled();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Clear and Enter the text in the text box
	 * 
	 * @param by
	 * @param text
	 */

	public static void clearAndfillInFieldWith(By by, String text) {
		try {
			tryFindElement(by).clear();
			tryFindElement(by).sendKeys(text);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static WebElement tryFindElement(By by) {
		WebElement element = (WebElement) getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
		return element;
	}

	/**
	 * Gets the Text from the selected locator
	 * 
	 * @param by
	 * @return
	 * 
	 */

	public static String GetText(By by) {
		String Text = null;
		try {
			Text = tryFindElement(by).getText();
		} catch (Exception e) {
			e.getMessage();
		}
		return Text;
	}

	/**
	 * Select Drop down by index
	 * 
	 * @param element
	 * @param index
	 * @param type
	 */
	public static void selectDropdownByIndex(String element, int index, LocatorTypes type) {
		try {
			pageDropDown(element, type).selectByIndex(index);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Select drop down by value
	 * 
	 * @param element
	 * @param value
	 * @param type
	 */
	public static void selectDropdownByValue(String element, String value, LocatorTypes type) {
		pageDropDown(element, type).selectByVisibleText(value);
	}

	public static Select pageDropDown(String elementName, LocatorTypes type) {
		WebElement element = findElement(elementName, type);
		return new Select(element);
	}

	/**
	 * Find webElement depending up on the Locator
	 * 
	 * @param locatorName
	 * @param type
	 * @return
	 */

	public static WebElement findElement(String locatorName, LocatorTypes type) {
		WebElement element = null;
		switch (type) {
		case CSS:
			element = getDriver().findElement(By.cssSelector((locatorName)));
			break;
		case XPATH:
			element = getDriver().findElement(By.xpath((locatorName)));
			break;
		case ID:
			element = getDriver().findElement(By.id((locatorName)));
			break;
		case CLASSNAME:
			element = getDriver().findElement(By.className((locatorName)));
			break;
		case LINKTEXT:
			element = getDriver().findElement(By.linkText((locatorName)));
			break;
		case NAME:
			element = getDriver().findElement(By.name((locatorName)));
			break;
		case PARTIALLINKTEXT:
			element = getDriver().findElement(By.partialLinkText((locatorName)));
			break;
		case TAGNAME:
			element = getDriver().findElement(By.tagName((locatorName)));
			break;
		default:
			break;
		}

		return element;
	}

	/**
	 * Verify the input value is present in the web element
	 * 
	 * @param locatorName
	 * @param type
	 * @param value
	 * @return
	 */
	public static boolean VerifyTextData(String element, LocatorTypes type, String value) {
		boolean returnValue = false;

		WebElement textBoxEle = findElement(element, type);
		returnValue = textBoxEle.isEnabled();
		if (returnValue) {
			returnValue = textBoxEle.getAttribute("value").contains(value);
		}
		return returnValue;

	}

	/**
	 * Find list of webElements
	 * 
	 * @param locatorName
	 * @param type
	 * @return
	 */
	public static List<WebElement> findElements(String locatorName, LocatorTypes type) {
		List<WebElement> element = null;
		switch (type) {
		case CSS:
			element = getDriver().findElements(By.cssSelector((locatorName)));
			break;
		case XPATH:
			element = getDriver().findElements(By.xpath((locatorName)));
			break;
		case ID:
			element = getDriver().findElements(By.id((locatorName)));
			break;
		case CLASSNAME:
			element = getDriver().findElements(By.className((locatorName)));
			break;
		case LINKTEXT:
			element = getDriver().findElements(By.linkText((locatorName)));
			break;
		case NAME:
			element = getDriver().findElements(By.name((locatorName)));
			break;
		case PARTIALLINKTEXT:
			element = getDriver().findElements(By.partialLinkText((locatorName)));
			break;
		case TAGNAME:
			element = getDriver().findElements(By.tagName((locatorName)));
			break;
		default:
			element = getDriver().findElements(By.xpath((locatorName)));
			break;
		}

		return element;
	}

	/**
	 * Verify if the items are sorted in descending order
	 * 
	 * @param locatorName
	 * @param type
	 * @param Boolean
	 * @return
	 */
	public static boolean verifyItemSorted(String element, LocatorTypes type, boolean isDescendingOrder) {
		boolean returnValue = false;
		List<String> obtainedList = new ArrayList<String>();
		List<WebElement> elementList = findElements(element, type);
		for (WebElement elem : elementList) {

			obtainedList.add(elem.getText());
		}

		List<String> tempList = new ArrayList<String>();
		for (String s : obtainedList) {
			tempList.add(s);
		}
		Collections.sort(tempList);
		if (isDescendingOrder) {
			Collections.reverse(tempList);
		}

		if (tempList.equals(obtainedList)) {
			returnValue = true;
		} else {
			returnValue = false;
		}

		return returnValue;

	}
}
