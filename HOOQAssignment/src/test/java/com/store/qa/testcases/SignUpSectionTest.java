package com.store.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.Testbase;
import com.store.qa.pages.CreateAccountPage;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.IndexPage;
import com.store.qa.pages.LoginPage;
import com.store.qa.utilities.Testutil;

public class SignUpSectionTest extends Testbase{
	IndexPage indexPage;
	Testutil testUtil;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	HomePage homePage;
	   
	public SignUpSectionTest(){
			super();	
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new Testutil();
		//signInPage = new Signinpage();
		indexPage = new IndexPage();
		//testUtil.date;
		loginPage = indexPage.clickOnSignIn();
		createAccountPage=loginPage.clickCreateAccount();
		homePage=createAccountPage.createNewAccount();
	}
	
	@Test
	public void verifyAccountCreationTest() {
		// setup();
		homePage.verifyLogoutLabel();
		homePage.verifyUserName();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
