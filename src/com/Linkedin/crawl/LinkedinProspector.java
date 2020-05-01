package com.Linkedin.crawl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LinkedinProspector {
	
	public static void main(String[] args) {
		
	 try {
		 WebDriver driver = new FirefoxDriver();
		 String email = "User_email";
		 String password = "User_password";
		 String url = "https://www.linkedin.com/";
//		 String url = "http://www.government.co.bw/";
		 driver.navigate().to(url);
		 Thread.sleep(20000);
		 
		 WebElement username = driver.findElement(By.id("login-email"));
		 WebElement pass = driver.findElement(By.id("login-password"));
		 username.sendKeys(email);
		 pass.sendKeys(password);
		 driver.findElement(By.id("login-submit")).click();
		 Thread.sleep(20000);
		 
		 //Required user details by using the user url
		 url = "https://www.linkedin.com/in/USER_PROFILE_NAME/";
		 System.out.println("Navigated to persons profile.....");
		 driver.navigate().to(url);
		 Thread.sleep(20000);
		 
		//*[@id="ember87"]//*[@id="ember87"]  
//		  driver.findElement(By.xpath("//*[@id='ember87']/span[2]")).click();
//		 div.findElement(By.xpath("//*[@id='ember87']"));
//		 div.findElement(By.tagName("button")).click();
//		 System.out.println("***************************************"+div.getTagName());
		 Thread.sleep(500);
		 System.out.println("Fetching Contact Information please wait......");
		 WebElement div = driver.findElement(By.id("profile-wrapper"));
		 WebElement div1 = div.findElement(By.className("ember-view"));
		 WebElement div2 = div1.findElement(By.className("pv-content"));
		 WebElement div3 = div2.findElement(By.className("core-rail"));
//		 WebElement div4 = div3.findElement(By.className("ember-view"));
		 List<WebElement> list = div3.findElements(By.className("ember-view"));
		 for(int i=0; i<list.size(); i++) {
			 if(i == 1){
				 WebElement div5 = list.get(i).findElement(By.tagName("section"));
				 // WebElement div6 = div5.findElement(By.className("ember-view"));
				 List<WebElement> list1 = div5.findElements(By.className("ember-view"));
				 for(int j=0; j<list1.size(); j++) {
					 if(j == 0) {
						 List<WebElement> div7 = list1.get(j).findElements(By.tagName("div"));
						 for(int k=0; k<div7.size(); k++) {
							 if(k == 1) {
								 List<WebElement> div8 = div7.get(k).findElements(By.className("ember-view"));
								 for(int l=0; l<div8.size(); l++) {
									 if(l == 0){
										 List<WebElement> div9 =  div8.get(l).findElements(By.tagName("span"));
										 for(int m=0; m<div9.size(); m++){
											 if(m == 0) {
												 div9.get(m).findElement(By.tagName("li-icon")).click();
											 }
										 }
									 }
								 }
							 }
						 }
					 }
				 }
			 }
		 }		 
		 System.out.println("Profile Link....... ");
		 System.out.println("Phone Number.......");
		 System.out.println("Email.............");
		 System.out.println("Twitter Id.........");
		 System.out.println("Date Of Birth......");

	 } catch(Exception e) {
		 e.printStackTrace();
	 }
	}
}
