package com.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annonations {

	@BeforeMethod
	public void beforemethod(){
	System.out.println("I am in before method");	
	}
	
	@AfterMethod
	public void aftermethod(){
		System.out.println("I am in afte method");
	}
	
	@Test
	public void m1(){
		
	System.out.println("I am in method1");
	}
	
	@Test
	public void m2(){
		
	System.out.println("I am in method2");
	}
	
	@Test
	public void m3(){
		
	System.out.println("I am in method3");
	}
}
