package com.tranings.advanceselenium.waytoautomation.library;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static String takeSnapShot(WebDriver webdriver,String screenshotName){
		try{
			//Convert web driver object to TakeScreenshot

			TakesScreenshot scrShot =((TakesScreenshot)webdriver);

			//Call getScreenshotAs method to create image file
			Date today = new Date();
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			screenshotName = screenshotName+":"+today.toString();
			//Move image file to new destination
			String destination="D:\\Trainings\\advanceSelenium\\WayToAutomation\\Screenshot"+screenshotName+ ".png";
			File DestFile=new File(destination);

			//Copy file at destination

			FileUtils.copyFile(SrcFile, DestFile);
			System.out.println("Screenshot Captured");

			return destination;

		}    

		catch(Exception e){
			System.out.println("Exception while taking screenshot");
			e.printStackTrace();
			return e.getMessage();

		}
	}
}
