package com.tranings.advanceselenium.waytoautomation.system;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tranings.advanceselenium.waytoautomation.help.Helper;
import com.tranings.advanceselenium.waytoautomation.library.Mailer;

public class Init {
	public static WebDriver driver; 
	public static WebDriver initiate(){				
		String name= "vibhor", password="password123";			
		driver =startBrowser();
		Helper hlp = new Helper();
		hlp.navigateToDemoSite(driver,name,password);
		return driver;
	}
	public static WebDriver startBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");
		
		return driver;
	}
	public static void sendMail(ExtentReports report,ExtentTest logger){
	//close all reports		
	//send mail
	String from="2016.gudda@gmail.com";
	String pass="11$May@2016";
	String to="90.shalini@gmail.com";
	
	Mailer.sendReportByGMail(from, pass, to);

	report.endTest(logger);
	report.flush();
}
	public static void closeBrowser(){	
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		
		try{
			if(windows != null){
				for(int i=0; i<windows.size();i++){
					driver.switchTo().window(windows.get(i));
					driver.close();
				}
				windows = null;
			}
			System.out.println("closed all browsers....");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(windows != null){
				for(int i=0; i<windows.size();i++){
					driver.switchTo().window(windows.get(i));
					driver.close();
				}
			}
		}

	}


}	
