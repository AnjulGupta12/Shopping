package com.Shopping.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	
	
	//METHOD 1 
	public void launchBrowser() {
	
		//to call config file
		String fileName = ".\\src\\main\\resources\\config\\config.properties";
		
		try {
			fis = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop = new Properties();
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//calling webDriver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		wait(4000);
		}
	
	//METHOD 2
	public void wait(int wt) {
		try {
			Thread.sleep(wt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//METHOD 3
	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}
	
	
	
	}