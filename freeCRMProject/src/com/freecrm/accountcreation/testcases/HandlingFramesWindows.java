package com.freecrm.accountcreation.testcases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.CRMTestBase;

public class HandlingFramesWindows extends CRMTestBase{

	static WebDriver driver;

	@BeforeMethod
	public void befrmrd() {
		intitDriver();
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

		String strrrr = driver.findElement(By.xpath("//*[@id=\"recaptcha-demo-form\"]/fieldset/ul/li[1]/label"))
				.getText();
		System.err.println(strrrr);

		driver.switchTo().frame(0);
		String str = driver.findElement(By.id("recaptcha-anchor-label")).getText();

		System.out.println(str);
		// driver.switchTo().defaultContent();

		strrrr = driver.findElement(By.xpath("//*[@id=\"recaptcha-demo-form\"]/fieldset/ul/li[1]/label"))
				.getAttribute("for");
		System.err.println(strrrr);

	}

	@Test
	public void createUser() throws InterruptedException {

		int somevalu = sub();

		System.out.println(0000);

		// driver.get("https://classic.crmpro.com/login.cfm");
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		WebElement clickElement = driver.findElement(By.id("button1"));

		String parentWindowNamew = driver.getWindowHandle();

		System.out.println(parentWindowNamew);
		for (int i = 0; i <= 3; i++) {
			clickElement.click();
			Thread.sleep(2000);

		}

		clickElement.click();

		Thread.sleep(5000);
		// driver.findElement(By.xpath("//div[text()='Selenium Online
		// Trainings']")).click();

		Set<String> allWindows = driver.getWindowHandles();

		System.out.println("All the windows " + allWindows.size());

		for (String windowname : allWindows) {
			System.out.println("Name of the Window : " + windowname);
			if (!windowname.equals(parentWindowNamew)) {
				driver.switchTo().window("");
				Thread.sleep(2000);
				System.out.println("new value  "
						+ driver.findElement(By.xpath("//div[text()='Selenium Online Trainings']")).getText());
			}

		}

		driver.switchTo().window(parentWindowNamew);
		// clickElement = driver.findElement(By.id("button1"));
		clickElement.click();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public static boolean isSignInBtnDisplayed() {

		return driver.findElement(By.className("login-window")).isDisplayed();
	}

	@Test
	public static int sub() {

		int a = 98;
		int b = 677;
		System.out.println(a - b);

		return a - b;
	}
}
