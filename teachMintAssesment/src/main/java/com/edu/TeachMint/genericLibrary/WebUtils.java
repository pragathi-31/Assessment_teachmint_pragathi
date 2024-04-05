package com.edu.TeachMint.genericLibrary;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * @author PRAGATHI
 */
public class WebUtils {
	/**
	 * this method is to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is for implicit wait 
	 * @param driver
	 * @param sec
	 */
	public void implicitWaitStatement(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	/**
	 * this method is to get the object of actions
	 * @param driver
	 * @return
	 */
	public Actions actionObject(WebDriver driver) {
		Actions act= new Actions(driver);
		return act;
	}
	/**
	 * this method is to scroll to a particular element using actions class
	 * @param driver
	 * @param element
	 */
	public void scrollElement(WebDriver driver,WebElement element) {
		actionObject(driver).scrollToElement(element).perform();
	}
	/**
	 * this method is to wait explicitly till the element is present
	 * @param driver
	 * @param sec
	 * @param by
	 */
	public void explicitWait(WebDriver driver,int sec,By by) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	/**
	 * this method is to wait explicitly till the element is clickable
	 * @param driver
	 * @param sec
	 * @param element
	 */
	
	public void explicitWait(WebDriver driver,int sec,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
