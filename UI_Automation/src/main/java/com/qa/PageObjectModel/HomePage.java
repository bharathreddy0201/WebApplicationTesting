package com.qa.PageObjectModel;

import org.openqa.selenium.By;
import com.qa.utils.Wait;
import io.qameta.allure.Step;

public class HomePage extends Wait {

	private static final By HOME_PAGE = By.xpath("//a[contains(text(),'Home')]");
	private static final By Sign_in = By.xpath("//a[contains(text(),'Sign in')]");
	private static final By UserName = By.xpath("//a[contains(text(),'bharathreddy0201')]");
	private static final By NewPost = By.xpath("//a[contains(text(),'New Post')]");
	private static final By Settings = By.xpath("//a[@href='#settings']");

	public static By Sign_in() {
		return Sign_in;
	}
	public static By Settings() {
		return Settings;
	}

	public static By UserName() {
		return UserName;
	}

	public static By NewPost() {
		return NewPost;
	}

	public static By HOME_PAGE() {
		return HOME_PAGE;
	}

	@Step("getting login page title step....")
	public static String getLoginPageTitle() {
		waitUntilElementIsPresent(HOME_PAGE);
		return getDriver().getTitle();
	}

	@Step("verifying sign up link is displayed step....")
	public boolean verifySignUpLink() {
		return waitUntilElementIsPresent(HOME_PAGE);
	}

}
