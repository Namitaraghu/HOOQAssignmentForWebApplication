package com.store.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.Testbase;
import com.store.qa.pages.IndexPage;
import com.store.qa.pages.LoginPage;

public class IndexPageTest extends Testbase{
	public IndexPage indexPage;
	public LoginPage loginPage;
	public IndexPageTest() {
		super();
	}

	@BeforeMethod
    public void setup() {
	    initialization();
	    indexPage=new IndexPage();
	    loginPage=new LoginPage();
    }

	//@Test   //--- can uncomment for page testing of Main Page
	public void clickOnSignInTest() {
		// setup();
		indexPage.clickOnSignIn();
	}
	//@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
