package com.store.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.store.qa.base.Testbase;

public class ForgotPasswordPage extends Testbase {
	// Page Factory object repository

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-default button button-medium']")
	WebElement retrieveButton;
    
	@FindBy(xpath = "//p[contains(text(),'A confirmation email has been sent to your address: Johnlerry@gmail.com')]")
	WebElement confirmationMailSent;
	
	@FindBy(xpath = "//li[contains(text(),'There is no account registered for this email address.')]")
	WebElement confirmationMailSentError;
	
	// Initializing the Page Objects
	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void retrivePassword(String emailID) {
		email.sendKeys(emailID);
		retrieveButton.click();
		Assert.assertTrue(confirmationMailSent.isDisplayed());
	}
	public void retrivePasswordNegative(String emailID) {
		email.sendKeys(emailID);
		retrieveButton.click();
		Assert.assertTrue(confirmationMailSentError.isDisplayed());
	}
}
