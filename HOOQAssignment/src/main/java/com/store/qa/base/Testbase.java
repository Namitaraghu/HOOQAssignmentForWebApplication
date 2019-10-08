package com.store.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.store.qa.utilities.Testutil;

public class Testbase {
public static WebDriver driver;
public static Properties prop;

	public Testbase() {
		try {
			prop = new Properties();
			FileInputStream fio = new FileInputStream(
					System.getProperty("user.dir")+ "\\src\\main\\java\\com\\store\\qa\\config\\config.properties");
		    prop.load(fio);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void initialization() {
		String browserName= prop.getProperty("browser"); 
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\JAVA Stuff\\Browser\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.geckodriver.driver", "D:\\JAVA Stuff\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait( Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
