package com.Shopping.pages;

import java.util.List;

import com.Shopping.base.TestBase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;

public class AddCart extends TestBase{
	
	
	
	public void everything() {
		//fetching prices of all items
		wait(1000);
		WebElement[] price = new WebElement[17];
		float array[] = new float[17];
		for(int i=1; i<17 ;i++)
		{
			price[i] = driver.findElement(By.xpath("(//*[@class='sc-124al1g-6 ljgnQL'])["+i+"]"));
			String save = price[i].getText().substring(1);
			array[i] = Float.parseFloat(save);
			System.out.print(array[i]+" ");
			wait(600);
		}
		
		//loop for lowest
		float smallest = array[1];
		for(int i=1; i<17; i++)
		{
			if(array[i]<smallest)
			{
				smallest=array[i];
			}
		}
		
		// smallest will return the lowest price
		System.out.print("\nLowest price is : "+ smallest);
		
		
		//fetching webElement use price tag is smallest and click checkout
		WebElement item,checkout;
		for(int i=1; i<17; i++)
		{
			float fetch=Float.parseFloat(driver.findElement(By.xpath("(//*[@class='sc-124al1g-6 ljgnQL'])["+i+"]")).getText().substring(1));
			wait(500);
			if (fetch == smallest)
			{
				item=driver.findElement(By.xpath("(//*[@class='sc-124al1g-0 jCsgpZ'])["+i+"]"));
				item.click();
				wait(500);
				checkout= driver.findElement(By.xpath("//*[@class='sc-1h98xa9-11 gnXVNU']"));
				checkout.click();
				wait(1000);
				driver.switchTo().alert().accept();
			//	break;
			}
		}
		
		//handling alerted window
//		wait(1000);
//		try
//		{Alert alert = driver.switchTo().alert();
//		String alertText = alert.getText();
//		System.out.println("Alert Text: " + alertText);
//		alert.accept();
//		}catch(UnhandledAlertException e ){}
		
		//driver.switchTo().alert().accept();
		



		
	}
	
	
}