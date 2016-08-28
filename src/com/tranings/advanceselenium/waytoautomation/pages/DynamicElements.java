package com.tranings.advanceselenium.waytoautomation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class DynamicElements {
	Utils util = new Utils();
	By dynamicElementWidget = By.linkText("Submit Button Clicked");
	By startsWithTab = By.id("example-1-tab-1");
	
	By endsWithTab = By.id("example-1-tab-2");
	
	By completeDynamicTab = By.id("example-1-tab-3");
	By completeIDDynamic = By.linkText("COMPLETE ID DYNAMIC");
	By DemoFrame = By.className("demo-frame");
	By startsWithButton= By.xpath("//input[starts-with(@id,'submit')]");
	//By startsWithInput= By.id("^submit");
//	By endsWithButton= By.id("^submit");
//	By completeDynamicButton= By.id("^submit");
	
public void clickDynamicButton(WebDriver driver){
	//click on partial Dynamic element
	util.minWaitForElementToBeVisible(driver, dynamicElementWidget);
	driver.findElement(dynamicElementWidget).click();
	
	util.minWaitForElementToBeVisible(driver, startsWithTab);
	util.minWaitForElementToBeVisible(driver, DemoFrame);
	driver.switchTo().frame(driver.findElement(startsWithTab).findElement(DemoFrame));
	
	//System.out.println(driver.findElement(startsWithTab).findElements(By.tagName("input")).size());
	//System.out.println(driver.findElement(DemoFrame).findElement(By.tagName("input")));
	System.out.println(driver.findElements(By.tagName("input")).size());
	List<WebElement> inputs = driver.findElements(By.tagName("input"));
	inputs.get(0).sendKeys("123");
	//inputs.get(1).click();
	util.minWaitForElementToBeVisible(driver, startsWithButton);
	
	driver.findElement(startsWithButton).click();
	driver.switchTo().defaultContent();
	
	
	
	
	
	//click on complete dynamic button
//	util.minWaitForElementToBeVisible(driver, completeIDDynamic);
//	driver.findElement(completeIDDynamic).click();
//	try {
//		Thread.sleep(3000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	util.minWaitForElementToBeVisible(driver,completeDynamicTab);
//	util.minWaitForElementToBeVisible(driver,DemoFrame);
//	driver.switchTo().frame(driver.findElement(completeDynamicTab).findElement(DemoFrame));
//	
//	List<WebElement> inputDynamic = driver.findElements(By.tagName("input"));
//	inputDynamic.get(0).sendKeys("123");
//	inputDynamic.get(1).click();
//	System.out.println(inputDynamic.get(0).getText());
//	driver.switchTo().defaultContent();
//	
	
	
	
}
}
