package com.tranings.advanceselenium.waytoautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class Alerts {
	By alertLink = By.linkText("Alert");
	By simpleAlertTab= By.linkText("SIMPLE ALERT");
	By Tab1 = By.id("example-1-tab-1");	
	By DemoFrame = By.className("demo-frame");
	Utils util = new Utils();

	public void alertFunction(WebDriver driver){
		util.minWaitForElementToBeVisible(driver, alertLink);
		driver.findElement(alertLink).click();
		util.minWaitForElementToBeVisible(driver,simpleAlertTab);
		driver.findElement(simpleAlertTab).click();
		util.minWaitForElementToBeVisible(driver,Tab1);
		driver.switchTo().frame(driver.findElement(Tab1).findElement(DemoFrame));
		
		WebElement alertButton = driver.findElement(By.tagName("button"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("myFunction();");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//js.executeScript("arguments[0].click();", alertButton);
		//js.executeScript("document.getElementsByTagName('button').click();");
		//driver.findElement(By.tagName("button")).click();
		System.out.println("clicked");
	}
}
