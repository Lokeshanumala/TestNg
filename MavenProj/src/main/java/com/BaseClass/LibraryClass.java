package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LibraryClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void LaunchApplication() throws IOException {
		FileInputStream file =new FileInputStream(".\\src\\test\\resources\\Config Properties\\config.properties");
		prop=new Properties();
		prop.load(file);
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver=new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.geko.driver", prop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
	}
	
	public void TearDown() {
		driver.quit();
	}

}
