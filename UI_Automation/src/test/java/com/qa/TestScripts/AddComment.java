package com.qa.TestScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.baseTest.BaseTest;
import com.qa.PageObjectModel.Articels;
import com.qa.PageObjectModel.Comments;
import com.qa.PageObjectModel.HomePage;
import com.qa.PageObjectModel.Settings;
import com.qa.utils.BrowserInteraction;
import com.qa.utils.TimeUtil;

import io.qameta.allure.*;

@Owner("Bharath Varikuti")
public class AddComment extends BaseTest {
	final static Logger log = Logger.getLogger(AddComment.class.getName());
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

	@Test(priority = 1, description = "Verify that user is able to add  and post commets to an article from the available articles in his profile")
	@Severity(SeverityLevel.BLOCKER)
	public void addComment() {

		log.info("Navigate to user profile and validate the tab");
		BrowserInteraction.clickElementBy(HomePage.UserName());
		BrowserInteraction.waitUntilElementIsPresent(Articels.EditProfile());
		BrowserInteraction.clickElementBy(Articels.Article());

		log.info("Add the Comments to the article and click on post comment and validate");
		BrowserInteraction.clearAndfillInFieldWith(Comments.comment(), prop.getProperty("comment"));
		BrowserInteraction.clickusingjavaScriptExecutor(Comments.PostCmtBtn());
		BrowserInteraction.waitUntilElementIsPresent(Comments.CommentTest());

		log.info("Navigates to default homepage");
		TimeUtil.shortWait();
		BrowserInteraction.clickusingjavaScriptExecutor(HomePage.HOME_PAGE());

		log.info("Logoff from the user profile and verify 'newPost'is not visible");
		BrowserInteraction.clickusingjavaScriptExecutor(HomePage.Settings());
		TimeUtil.shortWait();
		BrowserInteraction.clickusingjavaScriptExecutor(Settings.logoutlink());
		BrowserInteraction.ValidateElementnotVisible(HomePage.NewPost());
	}

}
