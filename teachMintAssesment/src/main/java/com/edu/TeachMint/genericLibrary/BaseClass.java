package com.edu.TeachMint.genericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.edu.TeachMint.objectRepo.LoginPage;

public class BaseClass {
	public FileUtils fLib= new FileUtils();
	public WebUtils wLib=new WebUtils();
	public WebDriver driver;
/**
 * @author PRAGATHI
 * this method is for opening the browser
 * @throws IOException
 */
	@BeforeClass
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		wLib.maximizeTheBrowser(driver);
		wLib.implicitWaitStatement(driver, 10);
		String URL = fLib.readProperty("url");
		driver.get(URL);
	}
	/**
	 * @author PRAGATHI
	 * this method is for logging in
	 * @throws IOException
	 */
	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.Login(driver);
		
	}
	/**
	 * @author PRAGATHI
	 * this method is for closing the browser
	 */
	@AfterClass
	public void closeBrowser() {
		//driver.quit();
	}
	
}
