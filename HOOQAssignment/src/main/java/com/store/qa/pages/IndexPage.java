package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.qa.base.Testbase;
import com.store.qa.utilities.Testutil;

public class IndexPage extends Testbase{
	
    //Page Factory object repository
	@FindBy(linkText="Sign in")
	WebElement signIn;
	
	//Initializing the Page Objects
	public IndexPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public LoginPage clickOnSignIn() {
		signIn.click();
		return new LoginPage();
	}
}
