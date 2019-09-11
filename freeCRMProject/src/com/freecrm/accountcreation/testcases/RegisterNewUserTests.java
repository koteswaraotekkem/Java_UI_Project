package com.freecrm.accountcreation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.base.CRMTestBase;

public class RegisterNewUserTests extends CRMTestBase  {
int a;
String srt;
float fff;


@Parameters
@Test
public void multipleWindows(){
	System.out.println("execure");
}
	
	@Test(enabled=true)
	public void enumValidatiosn() throws InterruptedException, InvalidLicenceException{
		int age=34;
		
		if (age>3) {
			throw new InvalidLicenceException("Very less age ");
		}
	Thread.sleep(400);
		
		
		//array int[] = hiiiii {5};
		
		int[] arrr = new int[3];
		
		
		
		String logintitkel=null;
		
	
		
		try {
			//System.out.println(arrr[3]);
			Assert.assertNotNull(logintitkel, "Ecpected str not to be null "+logintitkel);
			//logintitkel.length();
		} 
		
		
		catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println(8888);
		
		/*finally{
			System.out.println(8888);
		}*/
		
	
		
		
	}
	
	
	
	@Test(enabled=true)
	public void createUser() throws InterruptedException{
		
		Thread.sleep(400);
		
		
		//array int[] = hiiiii {5};
		
		int[] arrr = new int[3];
		
		
		
		String logintitkel=null;
		//Assert.assertNotNull(logintitkel, "Ecpected str not to be null "+logintitkel);
	
		
		try {
			System.out.println(arrr[3]);
			
			logintitkel.length();
		} 
		catch (ArrayIndexOutOfBoundsException |NullPointerException e) {
			e.getMessage();
		}
		
		
		
		
		
		System.out.println();
		
		
	/*	String s = null;
		if (s==null) {
			throw new InvalidLicenceExpection("invalid pam licence e ntered");
			
		}
		System.out.println(addNum(222, 7867));
		
		System.out.println(addNum(12, 32));
		
		System.out.println((addNum(32, 435)));
		
		System.out.println(addNum(12, 325));
		
		System.out.println(addNum(132, 32));
		System.out.println(addNum(12, 324));
		
		System.out.println(currentDir);*/
		intitDriver();
		driver.get("https://igbc.in/igbc");
		
		String pageTitiel = "India is my country  ";
		
		
		System.out.println("Original Titile::"+pageTitiel.substring(1,10));
		
		System.out.println("To Uppercase.... "+pageTitiel.toUpperCase());
		System.out.println("To Lowecase...."+pageTitiel.toLowerCase());
		System.out.println(""+pageTitiel.charAt(5));
		System.out.println(""+pageTitiel.concat("Welocmeback"));
		
		System.out.println("After concatination--::"+pageTitiel);
		
		
		System.out.println(""+pageTitiel.trim());
		
		String pageTitiel22 = pageTitiel.trim();
		pageTitiel = pageTitiel.concat("Welocmeback");
		
		System.out.println(pageTitiel.equals(pageTitiel22));
		pageTitiel.compareTo(pageTitiel22);
		
		System.out.println("startswith"+pageTitiel.startsWith("India"));
		System.out.println(""+pageTitiel.endsWith("India"));
		
		
		
		
		//String feednback = driver.findElement(By.linkText("Feedback")).getText();
		//System.out.println(feednback);
		
		
	}
	
	
	@AfterClass
	public void afterClass() throws InterruptedException{
		//Thread.sleep(90000);
		//driver.quit();
	}
	
	public int addNum(int a, int b){
		
		int c = a+b;
		
		return c;
	}
}
