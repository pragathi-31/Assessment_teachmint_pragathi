package com.edu.TeachMint.objectRepo;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.TeachMint.genericLibrary.FileUtils;
import com.edu.TeachMint.genericLibrary.WebUtils;


public class LoginPage {
	@FindBy(id = "user-input")
	private WebElement mob_num;
	
	@FindBy(id = "send-otp-btn-id")
	private WebElement otp_btn;
	
	@FindBy(id="submit-otp-btn-id")
	private WebElement submit_btn;
	
	@FindBy(xpath = "//div[@class='profile-label']")
	private WebElement profile;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @author PRAGATHI
	 * This method is used to login with number and enter otp and displaying dashboard page
	 * @param driver
	 * @throws IOException
	 */
	public void Login(WebDriver driver) throws IOException {
		FileUtils fLib=new FileUtils();
		WebUtils wLib=new WebUtils();
		String num = fLib.readProperty("number");
		int j=0;
		while(j<50) {
		try {
			mob_num.sendKeys(num);
			wLib.explicitWait(driver, 10, otp_btn);
			otp_btn.click();
			break;
		} catch (Exception e) {
			j++;
		}
		}
		
		String eData = fLib.readExcel("otp", 1, 0);
		for(int i=0;i<=5;i++) {
			char ch=eData.charAt(i);
			String s=Character.toString(ch);
			driver.findElement(By.xpath("//input[@data-group-idx='"+i+"']")).sendKeys(s);
		}
		
		submit_btn.click();
		profile.click();
	}
}
