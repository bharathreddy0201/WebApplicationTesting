package com.qa.PageObjectModel;

import org.openqa.selenium.By;

public class Comments {
	private static final By comment = By.xpath("//textarea[contains(@class,'form-control')]");
	private static final By PostCmtBtn = By.xpath("//button[contains(text(),'Post Comment')]");
	private static final By EditArticle = By.xpath("//a[.=' Edit Article']");
	private static final By DeleteArticlebtn = By.xpath("//button[contains(.,'Delete Article')]");
	private static final By Header = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]");

	public static By Header() {
		return Header;
	}

	public static By comment() {
		return comment;
	}

	public static By PostCmtBtn() {
		return PostCmtBtn;
	}

	public static By EditArticle() {
		return EditArticle;
	}

	public static By DeleteArticlebtn() {
		return DeleteArticlebtn;
	}
}
