package com.tranings.advanceselenium.waytoautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class DynamicElements {
	Utils util = new Utils();
	By dynamicElementWidget = By.linkText("Submit Button Clicked");
	By startsWithTab = By.id("example-1-tab-1");	
	By endsWithTab = By.id("example-1-tab-2");	
	By completeDynamicTab = By.id("example-1-tab-3");
	By completeIDDynamicLink = By.linkText("COMPLETE ID DYNAMIC");
	By endsWithLink = By.linkText("ENDS WITH");
	By DemoFrame = By.className("demo-frame");
	By startsWithButton= By.xpath("//input[starts-with(@id,'submit')]");
	By endsWithButton= By.xpath("//input[contains(@id,'1111')]");
	List<WebElement> inputs =null;

	public void clickDynamicButton(WebDriver driver,ExtentTest logger){
		try{
			//click on partial Dynamic element
			util.minWaitForElementToBeVisible(driver, dynamicElementWidget);
			driver.findElement(dynamicElementWidget).click();




			//Starts with Functionality
			System.out.println("clickDynamicButton->Starts With Functionality:");
			util.minWaitForElementToBeVisible(driver, startsWithTab);
			util.minWaitForElementToBeVisible(driver, DemoFrame);
			driver.switchTo().frame(driver.findElement(startsWithTab).findElement(DemoFrame));	
			inputs = driver.findElements(By.tagName("input"));
			inputs.get(0).sendKeys("123");
			util.minWaitForElementToBeVisible(driver, startsWithButton);	
			driver.findElement(startsWithButton).click();
			driver.switchTo().defaultContent();


			//Ends with Functionality
			System.out.println("clickDynamicButton->Ends With Functionality:");
			util.minWaitForElementToBeVisible(driver,endsWithLink);
			driver.findElement(endsWithLink).click();
			driver.switchTo().frame(driver.findElement(endsWithTab).findElement(DemoFrame));	
			inputs = driver.findElements(By.tagName("input"));
			inputs.get(0).sendKeys("123");
			util.minWaitForElementToBeVisible(driver, endsWithButton);	
			driver.findElement(endsWithButton).click();
			driver.switchTo().defaultContent();


			//Complete Dynamic Button Functionality
			System.out.println("clickDynamicButton->Complete ID Dynamic Functionality:");
			util.minWaitForElementToBeVisible(driver,completeIDDynamicLink);
			driver.findElement(completeIDDynamicLink).click();
			driver.switchTo().frame(driver.findElement(completeDynamicTab).findElement(DemoFrame));	
			inputs = driver.findElements(By.tagName("input"));
			inputs.get(0).sendKeys("123");
			inputs.get(1).click();
			driver.switchTo().defaultContent();
		}
		catch(Exception e){
			e.printStackTrace();
			String testName = this.getClass().getEnclosingMethod().getName();
			util.captureScreeshot(logger,driver,testName);
		}



	}
}
