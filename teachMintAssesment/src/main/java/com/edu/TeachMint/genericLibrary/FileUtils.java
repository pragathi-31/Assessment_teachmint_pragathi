package com.edu.TeachMint.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {
	/**
	 * @author PRAGATHI
	 * This method will return data from property file when we pass the key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstants.pfURL);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * @author PRAGATHI
	 * This method will return single data from excel 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstants.efURL);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		return sh.getRow(row).getCell(cell).getStringCellValue();
		
	}
	
}