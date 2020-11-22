package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	public Properties prop;
	OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the driver on the basis on given browser
	 *
	 * @param "browser"
	 * @return driver
	 */

	public WebDriver initialize_driver() {

		String browser = prop.getProperty("browser");
		System.out.println("browser name is : " + browser);

		optionsManager = new OptionsManager(prop);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println(browser + " is not found, please pass the correct browserName");
		}
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to init/load the properties from config file
	 *
	 * @return prop
	 */

	public Properties initialize_Properties() {
		prop = new Properties();
		String path = null;
		String env = null;
		String userCurrDir = System.getProperty("user.dir");

		try {
			env = System.getProperty("env");
			if (env == null) {
				path = userCurrDir + "\\src\\main\\java\\com\\qa\\config\\config.properties";
			}
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * take screenshot utility
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}
}
