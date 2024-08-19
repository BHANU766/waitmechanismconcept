package com.waitmechanismconcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicitwait {
     
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
public void explicitwait() throws InterruptedException {
	//create an object of the webdriverwait
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
	WebElement firstnamefield=driver.findElement(By.id("firstName"));
	firstnamefield.sendKeys("bhanu");
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
	WebElement lastnamefield=driver.findElement(By.id("lastName"));
	lastnamefield.sendKeys("rekha");
	 	
	WebElement submitbtn=driver.findElement(By.id("submit"));
	//locate submit button using scroll effect
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", submitbtn);
	submitbtn.click();
	
	Thread.sleep(5000);
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}

}
