package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//PageObjects- OR
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	private WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement tasksLink;
	
	//Initialize the PageObjects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//create the methods
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickonContacts(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDeals(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasks(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
}
