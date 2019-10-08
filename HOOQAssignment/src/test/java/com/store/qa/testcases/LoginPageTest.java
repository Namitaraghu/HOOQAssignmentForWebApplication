package com.store.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.Testbase;
import com.store.qa.pages.CreateAccountPage;
import com.store.qa.pages.IndexPage;
import com.store.qa.pages.LoginPage;
import com.store.qa.utilities.Testutil;

public class LoginPageTest extends Testbase{
	IndexPage indexPage;
	Testutil testUtil;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	   
	public LoginPageTest(){
			super();
			
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new Testutil();
		//signInPage = new SignInPage();
		indexPage = new IndexPage();
		//testUtil.date;
		loginPage = indexPage.clickOnSignIn();
	}
	
	//@Test    //---Can uncomment for page testing of Login page
	public void createAccount() {
		// setup();
		createAccountPage=loginPage.clickCreateAccount();
	}
	//@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
