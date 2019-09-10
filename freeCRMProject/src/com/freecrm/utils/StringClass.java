package com.freecrm.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringClass {

	public String str= " Learn jaVa ";
	public int i =23;
	
	String numericval = "56";
	
	
@Test
public void stringMethods(){
	
	int arr[] = new int[5];
	
	System.out.println(arr[4]);
	try {
		Assert.assertTrue(false);
		System.out.println("**************h");
	} catch (AssertionError e) {
		e.printStackTrace();
	}
	
	System.out.println("after Try catch");
	
	System.out.println("catch");
	
	
}
	
}
