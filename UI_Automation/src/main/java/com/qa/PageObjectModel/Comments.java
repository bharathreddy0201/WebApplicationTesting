package com.qa.PageObjectModel;

import org.openqa.selenium.By;

public class Comments {
	private static final By comment = By.xpath("//textarea[@class='form-control']");
	private static final By PostCmtBtn = By.xpath("//button[contains(text(),'Post Comment')]");
	private static final By EditArticle = By.xpath("//a[.=' Edit Article']");
	private static final By DeleteArticlebtn = By.xpath("//button[contains(.,'Delete Article')]");
	private static final By Header = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]");
	private static final By CommentTest = By
			.xpath("div[class='col-xs-12 col-md-8 offset-md-2'] div:nth-child(1) div:nth-child(1) p:nth-child(1)");

	public static By CommentTest() {
		return CommentTest;
	}

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
