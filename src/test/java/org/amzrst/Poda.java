package org.amzrst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Poda {
	public static void main(String[] args) throws IOException {
		System.out.println("The program is...");
		File f = new File("C:\\Users\\Public\\sample.xlsx");
		FileOutputStream fi = new FileOutputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellValue("value");
		FileOutputStream fo = new FileOutputStream(f);
		wb.write(fo);
		
		
	}

}
