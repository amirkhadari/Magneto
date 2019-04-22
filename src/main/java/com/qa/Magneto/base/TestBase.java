package com.qa.Magneto.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Magneto.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			FileInputStream fis = new FileInputStream("/home/innoraft/Amir/eclipse-oxygen-workspace/"
					+ "MagnetoTest/src/main/java/com/qa/Magneto/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.Driver", "/home/innoraft/Amir/chromedriver");
			driver = new ChromeDriver();
		} if(prop.getProperty("browser").equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "/home/innoraft/Amir/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIME, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
