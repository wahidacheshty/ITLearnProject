package com.ITLearn.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile{
	
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String fileName, String sheetName, int row ,int col) {
		try {
		fis = new FileInputStream(fileName);
		
		workbook = new XSSFWorkbook(fis);
		excelsheet = workbook.getSheet(sheetName);
		cell= excelsheet.getRow(row).getCell(col);
		
		workbook.close();
		return cell.getStringCellValue();
	
	}
	 catch(Exception e) {
		 return "";
	 }
	}
	
	public static int getRowCount (String fileName, String sheetName) {
		
		try {
			fis = new FileInputStream(fileName);
		
		workbook = new XSSFWorkbook(fis);
		excelsheet = workbook.getSheet(sheetName);
		int row = excelsheet.getLastRowNum()+1;
		workbook.close();
		return row;
	
      } catch (Exception e) {
	
	    return 0;
      }}
	
	public static int getColCount(String fileName,String SheetName) {
		
		try {
			fis = new FileInputStream(fileName);
		
		workbook = new XSSFWorkbook(fis);
		excelsheet = workbook.getSheet(SheetName);
		int colCount = excelsheet.getRow(0).getLastCellNum();
		workbook.close();
		return colCount;
		
		
            } catch (Exception e) {
            	return 0;
            }	
		}
		//for loop  form or purpose we create this 3 method
	
	public String getStrintData(int sheetIndex, int row, int column) {
 return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
 }
	public String 	getStringData(String sheetname, int row, int column) {
	return workbook.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
		//for numeric data
	public double getNumericData(String sheetname , int row ,int column) {
		
	return workbook.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
		
		
		
		
		
		
		

}
