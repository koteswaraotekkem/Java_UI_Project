package listeners.screenshots.ExtentReports;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenrsScreenShotsExtentreports {
	
	
	static WebDriver driver;
	ExtentReports report;
	ExtentTest testReport;
	
	
	
	@BeforeClass
	public void beforeClss() {
		report= new ExtentReports("/Users/koteswarararaotekkem/Documents/ReportsExt/IGBCTestResults.html",false);
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method method){
		testReport = report.startTest(method.getName());
	}
	
	@BeforeMethod
	public void befrmrd() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Map<String, Object> prefs = new HashMap<String, Object>();

		options.setExperimentalOption("prefs", prefs);


		System.setProperty("webdriver.chrome.driver", "/Users/koteswarararaotekkem/Documents/seleniumJars/Drivers/chromeDrivers/76/chromedriver");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		testReport.log(LogStatus.PASS, "successfull login - ans maximized");
		
	}
	
	
	@Test
	public void jsexaple(Method method) throws InterruptedException {
		String url = "https://igbc.in/igbc";
		driver.get(url);
		
		testReport.log(LogStatus.PASS, "Navigated to URL "+url);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("createAccount()");
		
		jse.executeScript("document.getElementById('salutation1').click();");
		jse.executeScript("scroll(0, -250)");
		
		driver.findElement(By.name("input")).click();
		
		driver.switchTo().alert().accept();
		
		WebElement countrySelelct = 	driver.findElement(By.id("country_id"));
		
		
		
		methodtoSelectfrDropDownByIndex(countrySelelct, 1);
		
		Thread.sleep(9000);
		WebElement stateID = 	driver.findElement(By.id("state_id"));
		
		
		
		methodtoSelectfrDropDownByIndex(stateID, 5);
		
		
		Assert.assertTrue(false);
		
		
		
		System.out.println(0);
		
	}
	
	
	private void methodtoSelectfrDropDownByIndex(WebElement ele, int inxVal) {
		Select select = new Select(ele);
		
		select.selectByIndex(inxVal);
	}
	
	@Test
	public void actionsClss() throws InterruptedException {
		driver.get("https://www.axisbank.com");
		
		Thread.sleep(5000);
		WebElement loginBtn = driver.findElement(By.xpath("//div[@class='loginClk jsloginClk']"));
		
		loginBtn.click();
		System.out.println(0);
	}
	
	
	@Test
	public void waitsEx() {
		driver.get("http://dumbitdude.com");
		driver.findElement(By.name("s")); 

	}
	
	
	@Test
	public void framesTest() throws InterruptedException {
		
		driver.get("https://www.google.com/recaptcha/api2/demo");
		Thread.sleep(5000);
		
		String strrrr = driver.findElement(By.xpath("//*[@id=\"recaptcha-demo-form\"]/fieldset/ul/li[1]/label")).getText();
		System.err.println(strrrr);
		
		driver.switchTo().frame(0);
		String str = driver.findElement(By.id("recaptcha-anchor-label")).getText();


		System.out.println(str);
		//driver.switchTo().defaultContent();
		
		
		 strrrr = driver.findElement(By.xpath("//*[@id=\"recaptcha-demo-form\"]/fieldset/ul/li[1]/label")).getAttribute("for");
		System.err.println(strrrr);
		
	}
	
	
	
	@Test
	public void createUser() throws InterruptedException {
		
		
		int somevalu = sub();
		
		System.out.println(0000);
		
	//	driver.get("https://classic.crmpro.com/login.cfm");
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		WebElement clickElement = driver.findElement(By.id("button1")); 

		String parentWindowNamew = driver.getWindowHandle();
		
		
		System.out.println(parentWindowNamew);
		for (int i = 0; i <=3; i++) {
			clickElement.click();
			Thread.sleep(2000);
			
		}
		
		clickElement.click();
		
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//div[text()='Selenium Online Trainings']")).click();
	
		
		Set<String> allWindows = driver.getWindowHandles();
		
		
		
		System.out.println("All the windows "+allWindows.size());
		
		for (String windowname : allWindows) {
			System.out.println("Name of the Window : "+windowname);
			if (!windowname.equals(parentWindowNamew)) {
				driver.switchTo().window("");
				Thread.sleep(2000);
				System.out.println("new value  "+driver.findElement(By.xpath("//div[text()='Selenium Online Trainings']")).getText());
			}
			
		}
		
		driver.switchTo().window(parentWindowNamew);
		//clickElement = driver.findElement(By.id("button1")); 
		clickElement.click();

		
		
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	

	
	@AfterMethod
	  public void closeBrowser(ITestResult result) throws IOException{
		 String screenshot_path;
		  if(result.getStatus()==ITestResult.FAILURE){
			  testReport.log(LogStatus.FAIL, "Test Failed");
			  screenshot_path =  TakescreenShot.captureScreenshot(driver, "LoginPageScreen"); 
			 String failedImage =  testReport.addScreenCapture(screenshot_path);
			  
			testReport.log(LogStatus.FAIL, "Assertion", failedImage);
			
		  }
		if(result.getStatus()==ITestResult.SUCCESS){
			  TakescreenShot a = new TakescreenShot();
			  screenshot_path =  TakescreenShot.captureScreenshot(driver, "LoginPageScreen"); 
			String image =testReport.addScreenCapture(screenshot_path);
			testReport.log(LogStatus.PASS, "PASSED",image);
			
		  }
		  
		  report.endTest(testReport);
			report.flush();
			 //driver.quit();
	  }
		
		public void screenshotReuse3() throws IOException{
		String 	screenshot_path =  TakescreenShot.captureScreenshot(driver, "LoginPageScreen"); 
			String image =testReport.addScreenCapture(screenshot_path);
			testReport.log(LogStatus.PASS, "PASSED",image);
		}
		
	
	
	public static boolean isSignInBtnDisplayed() {
		
		return driver.findElement(By.className("login-window")).isDisplayed();
	}





@Test
public static int sub() {
	
	int a=98;
	int b=677;
	System.out.println(a-b);
	
	return a-b;
	}

public void screenshotReuse(String Getimagename){
	TakescreenShot a = new TakescreenShot();
	String screenshot_path= a.captureScreenshot(driver, Getimagename);
	String image =testReport.addScreenCapture(screenshot_path);
	testReport.log(LogStatus.PASS, "PASSED",image);
}
}

