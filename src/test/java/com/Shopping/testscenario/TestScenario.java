package com.Shopping.testscenario;

import com.Shopping.base.TestBase;
import com.Shopping.pages.AddCart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenario extends TestBase{
	
	@BeforeClass
	public void setUp() {
		launchBrowser();
		navigateToURL();
		wait(2000);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	@Test(priority=1, enabled= true)
	public void AddCartTest() {
		AddCart work = new AddCart();
		work.everything();
	}
	
}