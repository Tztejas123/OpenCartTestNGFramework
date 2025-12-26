package com.absoloop.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //for logger
import org.apache.logging.log4j.Logger; //for logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// No more static WebDriver. Use ThreadLocal for parallel
	// execution safety.
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public ResourceBundle rb; // to read config.properties
	public Logger logger; // for Logging

	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	@Parameters("browser")
	public void setup(String br) {
		rb = ResourceBundle.getBundle("config"); // Load config.properties
		logger = LogManager.getLogger(this.getClass()); // for Logger

		WebDriver driver = null; // Local variable first

		// Launch right browser based on parameter
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// RUTHLESS FIX 2: Assign the driver to the ThreadLocal container
		threadLocalDriver.set(driver);

		// From now on, use getDriver() instead of 'driver'
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();

		getDriver().get(rb.getString("appURL2")); // get url from config.properties file
	}

	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void tearDown() {
		// RUTHLESS FIX 3: Quit the specific driver for this thread and clean up memory
		if (getDriver() != null) {
			getDriver().quit();
			threadLocalDriver.remove(); // Essential for memory management
		}
	}

	// RUTHLESS FIX 4: The global access point for the driver.
	// Call BaseClass.getDriver() anywhere in your framework.
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		// RUTHLESS FIX 5: Use getDriver() here so screenshots work in parallel
		// execution
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();

		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
}