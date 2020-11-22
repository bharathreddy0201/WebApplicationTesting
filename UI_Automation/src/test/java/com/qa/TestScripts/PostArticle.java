package com.qa.TestScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.baseTest.BaseTest;
import com.qa.PageObjectModel.Comments;
import com.qa.PageObjectModel.HomePage;
import com.qa.PageObjectModel.PublishArticle;
import com.qa.PageObjectModel.Settings;
import com.qa.utils.BrowserInteraction;
import com.qa.utils.TimeUtil;

import io.qameta.allure.*;

@Owner("Bharath Varikuti")
public class PostArticle extends BaseTest {
	final static Logger log = Logger.getLogger(PostArticle.class.getName());
	HomePage homepage = new HomePage();

	@BeforeMethod
	protected void setUpBrowser() throws InterruptedException {
		log.info("Sets up browser driver and open the Url in browser");
		super.setUpBrowser_login();
	}

	@AfterMethod
	protected void tearDown() {
		log.info("Closes the Browser after performing the test");
		super.tearDown();
	}

	@Test(priority = 1, description = "Verify that user is able to post an article using valid login credentials")
	@Severity(SeverityLevel.BLOCKER)
	public void postArtcle() {

		log.info("Clicks on the New post link");
		BrowserInteraction.clickElementBy(HomePage.NewPost());

		log.info("Enters the information to post article");
		BrowserInteraction.clearAndfillInFieldWith(PublishArticle.Articletitle(), prop.getProperty("ArticleTitle"));
		BrowserInteraction.clearAndfillInFieldWith(PublishArticle.ArticleAbout(), prop.getProperty("ArticleAbout"));
		BrowserInteraction.clearAndfillInFieldWith(PublishArticle.ArticleDes(), prop.getProperty("ArticleDes"));
		BrowserInteraction.clearAndfillInFieldWith(PublishArticle.Hashtag(), prop.getProperty("Hashtag"));
		BrowserInteraction.clickElementBy(PublishArticle.PublishArticleBtn());

		log.info("Validating if the article is posted or not");
		String Articletitle = BrowserInteraction.GetText(Comments.Header());
		Assert.assertEquals(Articletitle, prop.getProperty("ArticleTitle"));

		log.info("Navigates to default homepage");
		BrowserInteraction.clickElementBy(HomePage.HOME_PAGE());

		log.info("Logoff from the user profile and verify 'newPost'is not visible");
		BrowserInteraction.clickElementBy(HomePage.Settings());
		TimeUtil.shortWait();
		BrowserInteraction.clickusingjavaScriptExecutor(Settings.logoutlink());
		BrowserInteraction.ValidateElementnotVisible(HomePage.NewPost());
	}

}
