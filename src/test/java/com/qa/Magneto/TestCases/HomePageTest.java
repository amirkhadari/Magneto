package com.qa.Magneto.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Magneto.base.TestBase;
import com.qa.Magneto.pages.HomePage;
import com.qa.Magneto.pages.MobilePage;
import com.qa.Magneto.pages.TVPage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	MobilePage mobilep;
	TVPage tvp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp() {
		initialization();
		homepage = new HomePage();
		mobilep = new MobilePage();
		tvp = new TVPage();
	}
	
	@Test(priority=1)
	public void verifyTitleTest() {
		String homeTitle = homepage.VerifyTitle();
		Assert.assertEquals(homeTitle, "Home page");
	}
	
	@Test(priority=2)
	public void verifyMobileLinkandClickTest() {
		mobilep = homepage.VerifyMobileLinkandClick();
	}
	
	@Test(priority=3)
	public void verifyTVlinkandClick() {
		tvp = homepage.verifyTVlinkandClick();
	}
	
	@AfterTest()
	public void tearDown() {
		driver.close();
	}
}
