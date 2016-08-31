package com.tranings.advanceselenium.waytoautomation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tranings.advanceselenium.waytoautomation.pages.Alerts;
import com.tranings.advanceselenium.waytoautomation.pages.DatePicker;
import com.tranings.advanceselenium.waytoautomation.pages.DynamicElements;
import com.tranings.advanceselenium.waytoautomation.pages.Selectable;
import com.tranings.advanceselenium.waytoautomation.system.Init;

public class TestScriptSimpleElements {
	WebDriver driver = null;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeSuite
	public void initialize() throws Exception { 
		//String testName = method.getName();
		//logger = report.startTest(testName);
		this.driver = Init.initiate();
		//logger.log(LogStatus.INFO, "Application is up and running for: "+testName);
//		Date today = new Date();
//		report=new ExtentReports(".\\Reports\\Report"+today.toString()+".html");
		
	}
	
	/**DatePicker Test case to handle calendar**/
	@Test
	public void testDatePicker(){
		DatePicker dp = new DatePicker();
		dp.pickDate(driver,logger);
	}
	
	
	@Test
	public void testSelectables(){
		Selectable selectItem = new Selectable();
		selectItem.Select(driver,logger);	
		}
	

	@Test
	public void testDynamicElements(){
		DynamicElements de = new DynamicElements();
		de.clickDynamicButton(driver,logger);
	}
	
//	@Test
//	public void testAlert(){
//		Alerts al = new Alerts();
//		al.alertFunction(driver);
//	}

	@AfterSuite
	public void closeProject(){
		new Init().closeBrowser(driver,logger);
		//Init.sendMail(report,logger);
	}









}
