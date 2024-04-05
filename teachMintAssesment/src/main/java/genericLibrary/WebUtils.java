package genericLibrary;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implicitWaitStatement(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public Actions actionObject(WebDriver driver) {
		Actions act= new Actions(driver);
		return act;
	}
	public void scrollElement(WebDriver driver,WebElement element) {
		actionObject(driver).scrollToElement(element).perform();
	}
	public void explicitWait(WebDriver driver,int sec,By by) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public void explicitWait(WebDriver driver,int sec,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
