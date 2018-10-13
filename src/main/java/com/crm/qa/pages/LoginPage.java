package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repositories
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login' and @type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive') and (@alt='free crm logo')]")
	private WebElement crmLogo;
	
	@FindBy(xpath="//font[text()='Sign Up']")
	private WebElement signUpBtn;
	
	//Access the WebElements
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		boolean flag= crmLogo.isDisplayed();
		return flag;
	}
	
	public HomePage Login(String un, String pwd) {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		//Will direct the user from Login to HomePage
		return new HomePage();
	}
	
	
	
}
