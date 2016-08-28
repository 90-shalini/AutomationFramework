package com.tranings.advanceselenium.waytoautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class Selectable {
	By DemoFrame = By.className("demo-frame");
	By defaultFunctionality = By.linkText("Default functionality");
	By bottomDiv = By.className("container margin-top-20");
	By selectableLink = By.linkText("Selectable");
	By displayAsGridLinkTab= By.linkText("DISPLAY AS GRID");
	By seralizeTab= By.linkText("SERIALIZE");
	By getItemNumber = By.id("select-result");
	By defaultFuncTab = By.id("example-1-tab-1");
	By displayGridTab = By.id("example-1-tab-2");
	By serializeExampleTab = By.id("example-1-tab-3");

	Utils util = new Utils();
	
	public void Select(WebDriver driver,ExtentTest logger){

		try{
			//clicking on Selectable element
		//driver.get("http://way2automation.com/way2auto_jquery/selectable.php");
			System.out.println("Current URL: "+driver.getCurrentUrl());
			
			driver.switchTo().defaultContent();
			System.out.println("Current URL 2: "+driver.getCurrentUrl());
			
			//util.minWaitForElementToBeVisible(driver, bottomDiv);
			util.minWaitForElementToBeVisible(driver, selectableLink);
			//.findElement(bottomDiv)
			driver.findElement(selectableLink).click();
			//perform select on Default Fucntionality
			util.minWaitForElementToBeVisible(driver, DemoFrame);
			driver.switchTo().frame(driver.findElement(defaultFuncTab).findElement(DemoFrame));
			clickItem("Item 4", driver);
			driver.switchTo().defaultContent();
			
			//perform select on display as grid			
			util.minWaitForElementToBeVisible(driver,displayAsGridLinkTab);
			driver.findElement(displayAsGridLinkTab).click();
			driver.switchTo().frame(driver.findElement(displayGridTab).findElement(DemoFrame));
			clickItem("6", driver);
			driver.switchTo().defaultContent();
			
			

		}catch(Exception e){
			e.printStackTrace();
			String testName = this.getClass().getName();
			util.captureScreeshot(logger, driver,testName);

		}


	}
	public void serializeTab(WebDriver driver){
		util.minWaitForElementToBeVisible(driver, selectableLink);
		//.findElement(bottomDiv)
		driver.findElement(selectableLink).click();
		//perform select on serialize
		driver.switchTo().defaultContent();
		util.minWaitForElementToBeVisible(driver,seralizeTab);
		driver.findElement(seralizeTab).click();
		driver.switchTo().frame(driver.findElement(serializeExampleTab).findElement(DemoFrame));
		clickItem("Item 2", driver);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		//js.executeScript("alert('hello world');");
//		String jsText = js.executeScript("window.document.getElementById('select-result').getText()").toString();
//		System.out.println("text from javascript:" +jsText);
		System.out.println(driver.findElement(getItemNumber).getText());
		driver.switchTo().defaultContent();
	}

	public void clickItem(String itemName,WebDriver driver){
		By item = By.xpath("//li[contains(text(),'"+itemName+"')]");
		try {
			util.minWaitForElementToBeVisible(driver,item);
			WebElement itemToClick = driver.findElement(item);				
			itemToClick.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
