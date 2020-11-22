package com.qa.TestScripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.baseTest.BaseTest;
import com.qa.constants.Constants;
import com.qa.PageObjectModel.Articels;
import com.qa.PageObjectModel.Comments;
import com.qa.PageObjectModel.HomePage;
import com.qa.PageObjectModel.PublishArticle;
import com.qa.PageObjectModel.Settings;
import com.qa.utils.BrowserInteraction;
import io.qameta.allure.*;

@Owner("Bharath Varikuti")
public class EditArticle extends BaseTest {
	final static Logger log = Logger.getLogger(EditArticle.class.getName());
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

	@Test(priority = 1, description = "Verify that user is able to edit an article from the available articles in his profile")
	@Severity(SeverityLevel.BLOCKER)
	public void editArtcle() {

		log.info("Navigate to user profile and validate the tab");
		BrowserInteraction.clickElementBy(HomePage.UserName());
		BrowserInteraction.waitUntilElementIsPresent(Articels.EditProfile());
		BrowserInteraction.clickElementBy(Articels.Article());

		log.info("Clicks on edit article and edits the information");
		BrowserInteraction.clearAndfillInFieldWith(PublishArticle.Hashtag(), prop.getProperty("UpdatedHashtag"));
		BrowserInteraction.clickElementBy(PublishArticle.PublishArticleBtn());

		log.info("Validating if the article is posted or not");
		String Articletitle = BrowserInteraction.GetText(Comments.Header());
		Assert.assertEquals(Articletitle, prop.getProperty("ArticleTitle"));

		log.info("Navigates to default homepage");
		BrowserInteraction.clickElementBy(HomePage.HOME_PAGE());

		log.info("Logoff from the user profile and verify 'newPost'is not visible");
		BrowserInteraction.clickElementBy(HomePage.Settings());
		Constants.SHORT_WAIT();
		BrowserInteraction.clickusingjavaScriptExecutor(Settings.logoutlink());
		BrowserInteraction.ValidateElementnotVisible(HomePage.NewPost());
	}

}
