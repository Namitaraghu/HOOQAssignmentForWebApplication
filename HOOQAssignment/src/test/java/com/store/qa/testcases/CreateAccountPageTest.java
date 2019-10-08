package com.store.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.Testbase;
import com.store.qa.pages.CreateAccountPage;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.IndexPage;
import com.store.qa.pages.LoginPage;
import com.store.qa.utilities.Testutil;

public class CreateAccountPageTest extends Testbase {
	IndexPage indexPage;
	Testutil testUtil;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	HomePage homePage;
	   
	public CreateAccountPageTest(){
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
	}
	
	//@Test    // Can uncomment for page testing of CreateAccount
	public void createNewAccountTest() {
		// setup();
		homePage=createAccountPage.createNewAccount();
	}
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
