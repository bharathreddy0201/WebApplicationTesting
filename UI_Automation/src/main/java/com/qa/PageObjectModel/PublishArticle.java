package com.qa.PageObjectModel;

import org.openqa.selenium.By;

public class PublishArticle {
	private static final By ArticleTitle = By.xpath("//input[contains(@class,'form-control form-control-lg')]");
	private static final By ArticleAbout = By.xpath("//input[contains(@placeholder,\"article about?\")]");
	private static final By ArticleDes = By.xpath("//textarea[@class='form-control']");
	private static final By Hashtag = By.xpath("//input[contains(@placeholder,'tags')]");
	private static final By PublishArticleBtn = By.xpath("//button[contains(text(),'Publish Article')]");

	public static By Articletitle() {
		return ArticleTitle;
	}

	public static By ArticleAbout() {
		return ArticleAbout;
	}

	public static By ArticleDes() {
		return ArticleDes;
	}

	public static By Hashtag() {
		return Hashtag;
	}

	public static By PublishArticleBtn() {
		return PublishArticleBtn;
	}
}
