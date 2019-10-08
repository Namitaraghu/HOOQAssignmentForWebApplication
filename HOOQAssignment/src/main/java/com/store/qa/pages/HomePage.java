package com.store.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.store.qa.base.Testbase;

public class HomePage extends Testbase {
	//Page Factory object repository
	//Verify Registration of new account is successful
	@FindBy(css = "a.logout")
	WebElement signoutLabel;
	
	@FindBy(xpath = "//a[@class='account']//span")
	@CacheLookup
	WebElement userNameLabel;
	
	//Initializing the Page Objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public void verifyUserName() {
		Assert.assertEquals(userNameLabel.getText(),"John Lerry"); 
		// can pass variable here for userName for different users specified in Test data Sheet
	}
	public void verifyLogoutLabel() {
		Assert.assertTrue(signoutLabel.isDisplayed());	
	}
	public void verifyLogoutLabelNegative() {
		try {
			Assert.assertFalse(signoutLabel.isDisplayed());
		}catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		
	}
	public void verifyUserNameNegative() {
		Assert.assertNotEquals(userNameLabel.getText(),"John Lerry"); 
	}
	public void clickOnSignOut() {
		signoutLabel.click();
	}
}
