package com.tranings.advanceselenium.waytoautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.tranings.advanceselenium.waytoautomation.library.Utils;

public class DatePicker {
	String yearValue = "2017";
	String dayValue = "11";
	By datePickerLink = By.linkText("Datepicker");
	By DemoFrame = By.cssSelector("#example-1-tab-1 .freme_box .demo-frame");
	By DemoFrame2 = By.cssSelector("#example-1-tab-2 .freme_box .demo-frame");
	By DemoFrame3 = By.cssSelector("#example-1-tab-3 .freme_box .demo-frame");
	By DemoFrame4 = By.cssSelector("#example-1-tab-4 .freme_box .demo-frame");
	By datePicker = By.id("datepicker");
	By animationLink= By.cssSelector("a[href='#example-1-tab-2']");
	By animationDropDown = By.id("anim");
	By displayMonthYearLink = By.cssSelector("a[href='#example-1-tab-3']");
	By calendrMonth= By.cssSelector("select[class='ui-datepicker-month']");
	By calendrYear = By.cssSelector("select[class='ui-datepicker-year']");
	By formatDateLink = By.cssSelector("a[href='#example-1-tab-4']");
	By formatOptions= By.id("format");
	By Day = By.linkText(dayValue);
	Utils util = new Utils();
		public void pickDate(WebDriver driver,ExtentTest logger){
		
			try{
			
			//clicking on DatePicker Widget
			util.minWaitForElementToBeVisible(driver, datePickerLink);
			driver.findElement(datePickerLink).click();
			util.minWaitForElementToBeVisible(driver, DemoFrame);
			util.switchToFrame(driver,DemoFrame);			
//			List<WebElement> datesList = new ArrayList<WebElement>();
			util.minWaitForElementToBeVisible(driver, datePicker);
			driver.findElement(datePicker).sendKeys("05/03/2016");
			driver.findElement(datePicker).sendKeys("ENTER");
			driver.switchTo().defaultContent();
			
		
//			
//			//set month and year display
//			driver.findElement(displayMonthYearLink).click();
//			util.switchToFrame(driver,DemoFrame3);
//			util.minWaitForElement(driver, datePicker);			
//			driver.findElement(datePicker).click();
//			Select month = new Select(driver.findElement(calendrMonth));
//			month.selectByValue("10");
//			Select year = new Select(driver.findElement(calendrYear));
//			year.selectByValue(yearValue);
//			driver.findElement(Day).click();
//			util.minWaitForElement(driver, datePicker);			
//			System.out.println("Selected Date:" +driver.findElement(datePicker).getText());
//			driver.switchTo().defaultContent();
//			
//			//format Date
//			driver.findElement(formatDateLink).click();
//			util.switchToFrame(driver,DemoFrame4);
//			Select formatOptionsDropDown = new Select(driver.findElement(formatOptions));
//			formatOptionsDropDown.selectByValue("d MM, y");
//			util.minWaitForElement(driver, datePicker);			
//			System.out.println("Date in special format: "+driver.findElement(datePicker).getText());
//			driver.switchTo().defaultContent();
			}
			catch(Exception e){
				e.printStackTrace();
				String testName = this.getClass().getName();
				util.captureScreeshot(logger, driver,testName);
				
			}
			
			
		}
		public void setAnimationDate(WebDriver driver){
			System.out.println("On animation date test caseS");
			driver.findElement(animationLink).click();
			util.switchToFrame(driver,DemoFrame2);
			util.minWaitForElement(driver, datePicker);			
			driver.findElement(datePicker).sendKeys("05/03/2016");
			driver.findElement(datePicker).sendKeys(Keys.TAB);
			util.minWaitForElement(driver, animationDropDown);		
			//driver.findElement(animationDropDown).click();
			Select animation = new Select(driver.findElement(animationDropDown));
			animation.selectByIndex(2); 
			driver.switchTo().defaultContent();
			
		}
}
