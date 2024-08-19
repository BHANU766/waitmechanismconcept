package com.waitmechanismconcept;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluentwait {
       
    
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
public void fluentwait() throws InterruptedException {
	//create an object of fluentwait
	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(40))
			.pollingEvery(Duration.ofSeconds(15))
			.ignoring(NoSuchElementException.class);
	
	WebElement firstnamefield=wait.until(new Function<WebDriver,WebElement>() {
	      public WebElement apply(WebDriver driver) {
	    	  return driver.findElement(By.id("firstName"));
	      }
	});
	
	firstnamefield.sendKeys("bhanu");
	Thread.sleep(4000);
	
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}

}
