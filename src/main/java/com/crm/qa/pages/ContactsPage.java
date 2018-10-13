package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//PageObjects- OR
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	private WebElement contactsLabel;
	
	@FindBy(xpath="(//input[@name='contact_id'])[last()]")
	private WebElement selectContact;
	
	
	//initialize the objects
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//create the methods
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void verifySelectContactName(){
		selectContact.click();
	}
	
	
}
