package com.freecrm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMTestBase {
	public WebDriver driver;
	public static Properties props;
	public String currentDir = System.getProperty("user.dir");
	
	{
		props = new Properties();
		try { 
			FileInputStream fis = new FileInputStream(currentDir+"\\src\\configuration.properties");
			props.load(fis);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void intitDriver(){
		if (props.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", currentDir+"//externalFiles//drivers//chromedriver_win32//chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
	}
}
	
	public String getID(){
		
		return "i am Normal Class Get method";
	}
}
