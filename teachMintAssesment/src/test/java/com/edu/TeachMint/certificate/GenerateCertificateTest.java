package com.edu.TeachMint.certificate;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.TeachMint.genericLibrary.BaseClass;
import com.edu.TeachMint.objectRepo.DashBoardPage;
/**
 * @author PRAGATHI
 * this test script is to Generate a School Leaving certificate for Sam
 */
public class GenerateCertificateTest extends BaseClass{
	@Test
	public void schoolLeavingCertificateTest() throws IOException {
		DashBoardPage db=new DashBoardPage(driver);
		String Remarks=fLib.readExcel("result", 1, 1);
		//close the pop up
		db.shadowBtn();
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
		//update the remarks and generate the certificate
		db.updateRemarks(wLib, driver, Remarks);
		//click on download
		db.getDownload_btn().click();
		//back to certificate page
		db.getCertificate_and_doc().click();
		//validating
		String actualName = db.getStudent_name().getText();
		String expectedName=fLib.readExcel("result", 1, 0);
		Assert.assertEquals(actualName, expectedName);
	}
}

