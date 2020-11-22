package com.qa.baseTest;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.qa.PageObjectModel.HomePage;
import com.qa.PageObjectModel.SignInPage;
import com.qa.base.BasePage;
import com.qa.utils.BrowserInteraction;
import com.qa.utils.TimeUtil;

public class BaseTest extends BrowserInteraction {
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;

	protected void setUpBrowser_login() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver();
		driver.get(prop.getProperty("url"));
		// Calling the login function
		login();
	}

	protected void login() {
		TimeUtil.shortWait();
		String hometitle = HomePage.getLoginPageTitle();
		Assert.assertEquals(hometitle, prop.getProperty("hometitle"));
		BrowserInteraction.clickElementBy(HomePage.Sign_in());
		TimeUtil.shortWait();
		String Email = prop.getProperty("Email");
		String paswrd = prop.getProperty("Password");
		BrowserInteraction.clearAndfillInFieldWith(SignInPage.Email(), Email);
		BrowserInteraction.clearAndfillInFieldWith(SignInPage.Passwrd(), paswrd);
		BrowserInteraction.clickElementBy(SignInPage.signinBtn());
		TimeUtil.shortWait();
		String UserName = BrowserInteraction.GetText(HomePage.UserName());
		Assert.assertEquals(UserName, prop.getProperty("username"));
	}

	protected void tearDown() {
		driver.quit();
	}

}
