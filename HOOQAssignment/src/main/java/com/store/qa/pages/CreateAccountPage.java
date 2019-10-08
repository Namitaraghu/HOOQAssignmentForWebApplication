package com.store.qa.pages;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.store.qa.base.Testbase;
import com.store.qa.utilities.Testutil;

public class CreateAccountPage extends Testbase {
	//Page Factory object repository
			@FindBy(id="id_gender2")
			WebElement gender2;
			
			@FindBy(id="id_gender1")
			WebElement gender1;
			
			@FindBy(xpath="//input[@id=\"customer_firstname\"]")
			WebElement customerFirstName;
			
			@FindBy(xpath="//input[@id=\"customer_lastname\"]")
			WebElement customerLastName;
			
			@FindBy(id="email")
			WebElement email;
			
			@FindBy(name="passwd")
			WebElement password;
			
			@FindBy(xpath="//select[@id=\"days\"]")
			WebElement dobDays;
			
			@FindBy(xpath="//select[@id=\"months\"]")
			WebElement dobMonths;
			
			@FindBy(xpath="//select[@id=\"years\"]")
			WebElement dobYears;
			
			@FindBy(id="optin")
			WebElement offerCheckbox;
			
			@FindBy(id="firstname")
			WebElement firstName;
			
			@FindBy(id="lastname")
			WebElement lastName;
			
			@FindBy(id="company")
			WebElement company;
			
			@FindBy(id="address1")
			WebElement address;
			
			@FindBy(id="address2")
			WebElement addressLine2;
			
			@FindBy(id="city")
			WebElement city;

			@FindBy(id="id_state")
			WebElement state;
			
			@FindBy(id="postcode")
			WebElement postalCode;
			
			@FindBy(id="id_country")
			WebElement country;
			
			@FindBy(id="other")
			WebElement additionalInfo;
			
			@FindBy(id="phone")
			WebElement phoneNumber;
			
			@FindBy(id="phone_mobile")
			WebElement mobileNumber;
			
			@FindBy(id="alias")
			WebElement addressAlias;
			
			@FindBy(id="submitAccount")
			WebElement submitAccount;
			//Initializing the Page Objects
			public CreateAccountPage(){
				PageFactory.initElements(driver, this);
			}
			//Actions
			public HomePage createNewAccount() {
				int genderSpecifier = Testutil.dateAsString.hashCode();
				if(genderSpecifier%2==0) {
					gender2.click();
				}
				gender1.click();
				customerFirstName.clear();
				customerFirstName.sendKeys("John");
				customerLastName.clear();
				customerLastName.sendKeys("Lerry");
				email.clear();
				email.sendKeys("Johnlerry"+Testutil.dateAsString+"@gmail.com");
				password.sendKeys("1234567");
				Select dobDaysDropDown=new Select(dobDays);
				dobDaysDropDown.selectByValue("2");
				Select dobMonthsDropDown=new Select(dobMonths);
				dobMonthsDropDown.selectByValue("11");
				Select dobYearsDropDown=new Select(dobYears);
				dobYearsDropDown.selectByValue("2002");
				offerCheckbox.click();
				//firstName.sendKeys("John");
				//lastName.sendKeys("Lerry");
				company.sendKeys("HOOQ");
				address.sendKeys("Andheri East");
				addressLine2.sendKeys("Chulia Road");
				city.sendKeys("Singapore");
				Select stateDropDown=new Select(state);
				stateDropDown.selectByVisibleText("Alabama");
				postalCode.sendKeys("12345");
				Select countryDropDown=new Select(country);
				countryDropDown.selectByVisibleText("United States");
				additionalInfo.sendKeys("I love shoping");
				phoneNumber.sendKeys("23456789");
				mobileNumber.sendKeys("987654321");
				addressAlias.clear();
				addressAlias.sendKeys("My Address");
				
				submitAccount.click();
				return new HomePage();
			}
}
