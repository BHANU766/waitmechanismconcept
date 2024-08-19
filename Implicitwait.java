package com.waitmechanismconcept;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicitwait {
         
	   protected static String url="https://demoqa.com/automation-practice-form";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 //global wait mechanism or implicit wait mechanism
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@BeforeMethod
public void openurl() {
	  driver.get(url);
}

@Test
public void f() {
	
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
} 
}
