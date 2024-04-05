package com.edu.TeachMint.objectRepo;


import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.TeachMint.genericLibrary.WebUtils;


public class DashBoardPage {
	@FindBy(xpath = "//releases-panel[@viewing='all']")
	private WebElement shadowPopUpEle;
	
	@FindBy(xpath = "//div[@class='QuickActions_quickActionsIconDiv__3FUvw' and @data-for='GENERATE_CERTIFICATE']")
	private WebElement generateCertificate;
	
	@FindBy(xpath = "//h6[text()='Default templates - 7']/following-sibling::span[text()='View All']")
	private WebElement viewAll;
	
	@FindBy(xpath = "//div[@class='Cards_cardDetails__WsZ-E' and contains(.,'School leaving certificate')]")
	private WebElement schoolLeavingCertificate;
	
	@FindBy(xpath = "//div[text()='Generate']")
	private WebElement generate_Btn;
	
	@FindBy(xpath = "//table/tbody/tr/td[@class='krayon__TableVirtualized-module__KaQPS krayon__TableVirtualized-module__J-lQJ']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//table/tbody/tr/td[@class='krayon__TableVirtualized-module__KaQPS krayon__TableVirtualized-module__1bLc2']/descendant::div[text()='Generate']")
	private WebElement generate_link;
	
	@FindBy(xpath = "//div[text()='Remarks']/ancestor::div[@class='krayon__Input-module__iHNUs']/descendant::input[@class='krayon__TextInput-module__3VrcP']")
	private WebElement remarks;
	
	@FindBy(xpath = "//div[text()='Download']")
	private WebElement download_btn;
	
	@FindBy(xpath = "//a[text()='Certificates and Documents']")
	private WebElement certificate_and_doc;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[@class='krayon__TableVirtualized-module__KaQPS krayon__TableVirtualized-module__J-lQJ']/descendant::p[@class='krayon__Para-module__VmUAA krayon__Para-module__Qddrw krayon__Para-module__5m3qF krayon__Para-module__Bz9pG']")
	private WebElement student_name;
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getShadowPopUpEle() {
		return shadowPopUpEle;
	}

	public WebElement getGenerateCertificate() {
		return generateCertificate;
	}

	public WebElement getViewAll() {
		return viewAll;
	}

	public WebElement getSchoolLeavingCertificate() {
		return schoolLeavingCertificate;
	}

	public WebElement getGenerate_Btn() {
		return generate_Btn;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getGenerate_link() {
		return generate_link;
	}

	public WebElement getRemarks() {
		return remarks;
	}

	public WebElement getDownload_btn() {
		return download_btn;
	}

	public WebElement getCertificate_and_doc() {
		return certificate_and_doc;
	}

	public WebElement getStudent_name() {
		return student_name;
	}
	
	public By getRemarksByType() {
		return By.xpath("//div[text()='Remarks']/ancestor::div[@class='krayon__Input-module__iHNUs']/descendant::input[@class='krayon__TextInput-module__3VrcP']");
	}
	
	public void shadowBtn() {
		//close the pop up
				SearchContext root = shadowPopUpEle.getShadowRoot();
				root.findElement(By.cssSelector("svg[class='close-btn']")).click();
	}
	public void updateRemarks(WebUtils wLib,WebDriver driver,String Remarks){{
		wLib.scrollElement(driver, remarks);
		wLib.explicitWait(driver, 10, getRemarksByType());
	
		remarks.sendKeys(Remarks);
		
		//click on generate
		int k=0;
		while(k<50) {
			try {
				getGenerate_Btn().click();
				break;
			} catch (Exception e) {
				k++;
			}
		}
	}
}
}
