package gov.nsw.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	
	
	WebDriver driver;
	
	public WebDriver getDriver(String name) {
		if(name.equalsIgnoreCase("Chrome"))
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tresa\\Desktop\\chromedriver.exe");
		 return driver = new ChromeDriver();
		 
		 
			
	}
	
	
}
