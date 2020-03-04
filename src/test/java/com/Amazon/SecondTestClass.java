package com.Amazon;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SecondTestClass extends BrowserFunction{
  @Test
  public void SecondTestFirst() throws InterruptedException {
	  
	  //test= extent.createTest("g");
	  String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement check = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
		check.click();
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		Thread.sleep(2000);
		System.out.println(check.isSelected());
		Assert.assertTrue(check.isSelected());
		check.click();
		System.out.println(check.isSelected());
		Assert.assertFalse(check.isSelected());
  }
  
  @Test
  public void SecondTestSecond() throws InterruptedException {
	  //test= extent.createTest("l");
	  String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys("Gaurav");
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
  }
  
  


}
