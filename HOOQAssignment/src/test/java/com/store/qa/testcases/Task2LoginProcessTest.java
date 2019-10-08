package com.store.qa.testcases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.qa.base.Testbase;
import com.store.qa.pages.ForgotPasswordPage;
import com.store.qa.pages.HomePage;
import com.store.qa.pages.IndexPage;
import com.store.qa.pages.LoginPage;

public class Task2LoginProcessTest extends Testbase {
	LoginPage loginPage;
	HomePage homePage;
	IndexPage indexPage;
	ForgotPasswordPage forgotPasswordPage;
	public Task2LoginProcessTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
	}
	
	@Test(priority=1)
	public void loginTestCase1(){
		homePage = loginPage.verifyLogin(prop.getProperty("email"), prop.getProperty("password"));
		homePage.verifyLogoutLabel();
		homePage.verifyUserName();
	}
	
	@Test(priority=2)
	public void loginTestCase2(){
		homePage = loginPage.verifyLogin("","");
		loginPage.verifyEmailRequiredError();
		homePage.verifyLogoutLabelNegative();//to test login is not successful
	}
	
	@Test(priority=3)
	public void loginTestCase3(){
		homePage = loginPage.verifyLogin(prop.getProperty("notRegisteredEmail"),prop.getProperty("incorrectPassword"));
		loginPage.verifyAuthenticationError();
		homePage.verifyLogoutLabelNegative();
	}
	
	@Test(priority=4)
	public void loginTestCase4(){
		homePage = loginPage.verifyLogin(prop.getProperty("email"),prop.getProperty("incorrectPassword"));
		loginPage.verifyAuthenticationError();
		homePage.verifyLogoutLabelNegative();
	}
	
	@Test(priority=5)
	public void loginTestCase5(){
		homePage = loginPage.verifyLogin(prop.getProperty("email"),prop.getProperty("pwdForSQLInjection"));
		loginPage.verifyAuthenticationError();
		homePage.verifyLogoutLabelNegative();
	}
	
	@Test(priority=6)
	public void loginTestCase6(){
		forgotPasswordPage = loginPage.verifyForgotPasswordLink();
		forgotPasswordPage.retrivePassword(prop.getProperty("email"));
	}
	
	@Test(priority=7)
	public void loginTestCase7(){
		forgotPasswordPage = loginPage.verifyForgotPasswordLink();
		forgotPasswordPage.retrivePasswordNegative(prop.getProperty("notRegisteredEmail"));
	}
	
	@Test(priority=8)
	public void loginTestCase8(){
		loginPage.verifyPasswordMasking(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(priority=9)
	public void loginTestCase9(){
		homePage=loginPage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		homePage.clickOnSignOut();
		loginPage.verifySessionHijacking();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
