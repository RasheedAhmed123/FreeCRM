package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testutil;
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void browserSetUp() throws InterruptedException{
		initialization();
		Thread.sleep(10000);
		loginPage= new LoginPage();
		testutil= new TestUtil();
		contactsPage= new ContactsPage();
		homePage=loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactsPage= homePage.clickonContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void verifySelectContactNameTest(){
		contactsPage.verifySelectContactName();
		Reporter.log("Contact selected", true);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
