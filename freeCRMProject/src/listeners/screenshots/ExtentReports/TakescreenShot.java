package listeners.screenshots.ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakescreenShot {
	
public static String captureScreenshot(WebDriver driver, String screenshotName) 
	
	{
		try{
			
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String dest = "/Users/koteswarararaotekkem/Documents/ScSh/"+System.currentTimeMillis()+screenshotName+".jpeg";
		
		File destination = new File (dest);
		FileUtils.copyFile(source,destination );
		
		System.out.println("Screenshot is taken");
		
		return dest;
		}
		catch(Exception e){
			System.out.println("Exception while taking screenshot"+e.getMessage());
			return e.getMessage();
		}
	}
	
	public String captureScreenshot1(WebDriver driver,StringBuilder screenshotName) throws IOException 
	
	{
		try{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String dest = "D:\\ReportsOG\\"+screenshotName+".jpeg";
		File destination = new File (dest);
		FileUtils.copyFile(source,destination );
		System.out.println("Screenshot is taken");
		
		return dest;
		}
		catch(Exception e){
			System.out.println("Exception while taking screenshot builder"+e.getMessage());
			return e.getMessage();
		}
	}

}
