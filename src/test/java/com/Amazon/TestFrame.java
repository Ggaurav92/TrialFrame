package com.Amazon;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestFrame extends BrowserFunction{
	String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
	String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
  
	
	
	@Test
  public void firstTestFirst() {
	  //test= extent.createTest("f");
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			
			String name  = products.get(i).getText();
			//format name to get actual vegetable name
			String[] veggieFirstName = name.split("-");
			String formattedName = veggieFirstName[0].trim();
			
			//check whether the name you extracted is present in array
			//convert array into array list for easy search
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			//We are not usng array list directly since array take less memory
			
			
			System.out.println(name);
			if(itemsNeededList.contains(formattedName)) {
				//click on add to Cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				//Incrementing counter
				j++;
				System.out.println(j);
				
				//Breaking the loop when all the items in the arraylist are added to cart
				if(j==itemsNeeded.length) {
					break;
				}
				
			}

		}

	  
  }
  

  
  
  
}
