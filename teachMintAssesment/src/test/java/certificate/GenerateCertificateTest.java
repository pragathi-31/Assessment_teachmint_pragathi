package certificate;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;
import repo.DashBoardPage;

public class GenerateCertificateTest extends BaseClass{
	@Test
	public void schoolLeavingCertificateTest() throws IOException {
		DashBoardPage db=new DashBoardPage(driver);
		String Remarks="good";
		//close the pop up
		SearchContext root = db.getShadowPopUpEle().getShadowRoot();
		root.findElement(By.cssSelector("svg[class='close-btn']")).click();
		//click on generate certificate
		db.getGenerateCertificate().click();
		//click on view all
		db.getViewAll().click();
		//click on school leaving certificate
		db.getSchoolLeavingCertificate().click();
		//click on generate
		db.getGenerate_Btn().click();
		//click on check box
		db.getCheckBox().click();
		//click on generate link
		db.getGenerate_link().click();
		//update remarks
		WebElement remarks = db.getRemarks();
		wLib.scrollElement(driver, remarks);
		wLib.explicitWait(driver, 10, db.getRemarksByType());
	
		remarks.sendKeys(Remarks);
		
		//click on generate
		int k=0;
		while(k<50) {
			try {
				db.getGenerate_Btn().click();
				break;
			} catch (Exception e) {
				k++;
			}
		}
		//click on download
		db.getDownload_btn().click();
		//back to certificate page
		db.getCertificate_and_doc().click();
		
		//validating
	
		String aname = db.getStudent_name().getText();
		String ename="Sam";
		
		Assert.assertEquals(aname, ename);
	
	}
}

