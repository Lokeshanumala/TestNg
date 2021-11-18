package com.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseClass.LibraryClass;
import com.Pages.OrangeHRM_Login_Page;
import com.SeleniumUtility.Selenium_Utility_Class;

public class OrangeHRM_Login_TestCase extends LibraryClass {
	
	@BeforeTest
	public void start() throws IOException {
		LaunchApplication();
	}

	@Test
	public void Login_Page() {
		OrangeHRM_Login_Page loginpg=new OrangeHRM_Login_Page(driver);
		loginpg.username(prop.getProperty("uname"));
		loginpg.password(prop.getProperty("pwd"));
		loginpg.loginbtn();
	
	}
	
	@AfterTest
	public void close() throws IOException {
		Selenium_Utility_Class selut= new Selenium_Utility_Class(driver);
		selut.Take_Screenshot(prop.getProperty("loginscreenshot"));
		TearDown();
	
	}
}

