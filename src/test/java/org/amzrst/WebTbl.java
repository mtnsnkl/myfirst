package org.amzrst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTbl {
	private static Row row;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		WebElement btnclk = driver.findElement(By.id("details-button"));
		WebElement table = driver.findElement(By.tagName("table"));
		WebElement thead = table.findElement(By.tagName("tr"));
		WebElement ttitle = thead.findElement(By.tagName("td"));
		List<WebElement> datas = ttitle.findElements(By.tagName("th"));
		
		
		File f = new File("C:\\Users\\Public\\Webtable2.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row rowi = sheet.createRow(0);
		
		for (int i = 0; i < datas.size(); i++) {
			
				WebElement data1 = datas.get(i);
				String text = data1.getText();
				Cell cell = rowi.createCell(i);
				cell.setCellValue(text);
				
				WebElement tbody = table.findElement(By.tagName("tbody"));
				List<WebElement> tbody2 = tbody.findElements(By.tagName("tr"));
		for (int j = 0; j < tbody2.size(); j++) {
			    Row row2 = sheet.createRow(j);
			    WebElement data2 = tbody2.get(j);
			    
			    List<WebElement> td2 = data2.findElements(By.tagName("td"));
		for (int k = 0; k < td2.size(); k++) {
			    WebElement data3 = td2.get(k);
			    String text2 = data3.getText();
			    Cell createCell = row2.createCell(k);
			    createCell.setCellValue(text2);
		}	
		}		
				
				
			}
			wb.write(fo);
			driver.quit();
		}
		
	
	}


