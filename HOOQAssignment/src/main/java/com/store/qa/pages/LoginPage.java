package com.store.qa.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.store.qa.base.Testbase;
import com.store.qa.pages.HomePage;
import com.store.qa.utilities.Testutil;

public class LoginPage extends Testbase {
	// Page Factory object repository
	@FindBy(id = "email_create")
	WebElement email;

	@FindBy(id = "SubmitCreate")
	WebElement createAccountButton;

	@FindBy(id = "email")
	WebElement loginEmail;

	@FindBy(id = "passwd")
	WebElement loginPassword;
    
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;

	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasswordLink;

	@FindBy(xpath = "//li[contains(text(),'An email address required')]")
	WebElement requiredEmailError;
	
	@FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
	WebElement authenticationError;
	
	@FindBy(xpath = "//li[contains(text(),'Password is required')]")
	WebElement requiredPasswordError;
	
	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public CreateAccountPage clickCreateAccount() {
		email.sendKeys("johnlerry" + Testutil.dateAsString + "@gmail.com");
		createAccountButton.click();
		return new CreateAccountPage();
	}

	public HomePage verifyLogin(String email, String pwd) {
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(pwd);
		submitLogin.click();
		return new HomePage();
	}
	
	public void verifyPasswordMasking(String email, String pwd) {
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(pwd);
		Assert.assertEquals(loginPassword.getText(),"");
	}
	
	public void verifySessionHijacking() {
		driver.navigate().back();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://automationpractice.com/index.php?controller=authentication&back=my-account" );
	}
	
	public void verifyAuthenticationError() {
		assertTrue(authenticationError.isDisplayed());
	}
	
	public void verifyEmailRequiredError() {
		assertTrue(requiredEmailError.isDisplayed());
	}
	
	public void verifyPasswordRequiredError() {
		assertTrue(requiredPasswordError.isDisplayed());
	}
	
	public ForgotPasswordPage verifyForgotPasswordLink() {
		forgotPasswordLink.click();
		return new ForgotPasswordPage();
	}
}
