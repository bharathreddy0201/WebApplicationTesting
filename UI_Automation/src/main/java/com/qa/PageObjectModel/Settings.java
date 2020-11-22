package com.qa.PageObjectModel;

import org.openqa.selenium.By;

public class Settings {
	private static final By UpdateBtn = By.xpath("//button[contains(text(),'Update Settings')]");
	private static final By logoutlink = By.xpath("//button[contains(text(),'logout')]");

	public static By UpdateBtn() {
		return UpdateBtn;
	}

	public static By logoutlink() {
		return logoutlink;
	}


}
