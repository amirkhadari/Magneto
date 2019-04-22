package com.qa.Magneto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.Magneto.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//a[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement mobile;
	
	@FindBy(xpath = "//a[text()='TV']")
	WebElement TV;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyTitle() {
		return driver.getTitle();
	}
	
	public MobilePage VerifyMobileLinkandClick() {
		boolean mob = mobile.isDisplayed();
		if(mob) {
			mobile.click();
		}
		return new MobilePage();
	}
	
	public TVPage verifyTVlinkandClick() {
		boolean tv = TV.isDisplayed();
		if(tv) {
			mobile.click();
		}
		return new TVPage();
	}

}
