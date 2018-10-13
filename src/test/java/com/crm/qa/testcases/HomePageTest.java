package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void browserSetUp() throws InterruptedException{
		initialization();
		testutil= new TestUtil();
		contactsPage= new ContactsPage();
		loginPage= new LoginPage();
		Thread.sleep(10000);
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homePage.verifyHomePageTitle();	
		Assert.assertEquals(homePageTitle, "CRMPRO", "Homepage title not matched");
	}
	
	@Test(priority=2)
	public void verifycorrectUserName(){
		testutil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testutil.switchToFrame();
		contactsPage= homePage.clickonContacts();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
