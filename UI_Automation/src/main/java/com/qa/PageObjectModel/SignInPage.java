package com.qa.PageObjectModel;

import org.openqa.selenium.By;

public class SignInPage {
	private static final By Email = By.cssSelector("input[type='email']");
	private static final By Passwrd = By.cssSelector("input[type='password']");
	private static final By signinBtn = By.cssSelector("button[type='submit']");

	public static By Email() {
		return Email;
	}

	public static By Passwrd() {
		return Passwrd;
	}

	public static By signinBtn() {
		return signinBtn;
	}
}
