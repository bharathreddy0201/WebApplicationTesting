package com.qa.TestScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.baseTest.BaseTest;
import com.qa.PageObjectModel.Articels;
import com.qa.PageObjectModel.HomePage;
import com.qa.PageObjectModel.Settings;
import com.qa.utils.BrowserInteraction;
import com.qa.utils.TimeUtil;

import io.qameta.allure.*;

@Owner("Bharath Varikuti")
public class markFavorite extends BaseTest {
	final static Logger log = Logger.getLogger(markFavorite.class.getName());
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

	@Test(priority = 1, description = "Verify that user is able to mark the article as favourite")
	@Severity(SeverityLevel.BLOCKER)
	public void markfavorite() {

		log.info("Navigate to user profile and validate the tab");
		BrowserInteraction.clickElementBy(HomePage.UserName());
		BrowserInteraction.waitUntilElementIsPresent(Articels.EditProfile());
		
		log.info("Click on favorite icon and navigate to favorite tab to validate");
		BrowserInteraction.clickElementBy(Articels.ionHeart());
		BrowserInteraction.clickElementBy(Articels.FavouriteTab());
		BrowserInteraction.ValidateTextinElement(Articels.Article(), prop.getProperty("ArticleTitle"));
		
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
