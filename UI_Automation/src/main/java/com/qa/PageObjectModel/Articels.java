package com.qa.PageObjectModel;

import org.openqa.selenium.By;

public class Articels {
	private static final By EditProfile = By.xpath("//a[contains(text(),'Edit Profile Settings')]");
	private static final By FavouriteTab = By.xpath("//a[contains(text(),'Favorited Articles')]");
	private static final By Article = By.xpath("//h1[contains(text(),'Reasons')]");

	public static By EditProfile() {
		return EditProfile;
	}

	public static By Article() {
		return Article;
	}

	public static By FavouriteTab() {
		return FavouriteTab;
	}

}
