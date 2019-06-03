package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import TestCases.TestRunner;

public class ActionMethods
{
	
	public static void enterText(String property, String identifier, String value)
	{
		switch(property)
		{
		case "ID":
			WebElement element1 = TestRunner.driver.findElement(By.id(identifier));
			element1.sendKeys(value);
			break;
		case "classname":
			WebElement element2 = TestRunner.driver.findElement(By.className(identifier));
			element2.sendKeys(value);
			break;
		case "name":
			WebElement element3 = TestRunner.driver.findElement(By.name(identifier));
			element3.sendKeys(value);
			break;
		case "xpath":
			WebElement element4 = TestRunner.driver.findElement(By.xpath(identifier));
			element4.sendKeys(value);
			break;
		}
	}
	
	public static void clickButton(String property, String identifier)
	{
		switch(property)
		{
		case "ID":
			WebElement element1 = TestRunner.driver.findElement(By.id(identifier));
			element1.click();;
			break;
		case "classname":
			WebElement element2 = TestRunner.driver.findElement(By.className(identifier));
			element2.click();
			break;
		case "name":
			WebElement element3 = TestRunner.driver.findElement(By.name(identifier));
			element3.click();
			break;
		case "xpath":
			WebElement element4 = TestRunner.driver.findElement(By.xpath(identifier));
			element4.click();
			break;
		}
	}
	
	public static HashMap<String, String> dataFetchFromExcel(String sheetName, int rowNumber) throws IOException, InvalidFormatException
	{
		File file = new File("TestData.xlsx");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		HashMap<String,String> currenthash = new HashMap<String,String>();
		
		Row headerRow = sheet.getRow(0);
			
		for(int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++)
		{
			Row currentRow = sheet.getRow(i);
			
			if(i == rowNumber)
			{
				for(int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++)
				{
					Cell cell = currentRow.getCell(j);
					CellType celltype = cell.getCellTypeEnum();
					
					switch(celltype)
					{
					case STRING:
						currenthash.put(headerRow.getCell(j).getStringCellValue(), cell.getStringCellValue());
						break;
					case NUMERIC:
						currenthash.put(headerRow.getCell(j).getStringCellValue(), Integer.toString((int) cell.getNumericCellValue()));
						break;
					default:
						break;
					}
				//	currenthash.put(headerRow.getCell(j).getStringCellValue(), currentRow.getCell(j).getStringCellValue());
				}
			}
		}
		workbook.close();
		return currenthash;
		
	}
}
