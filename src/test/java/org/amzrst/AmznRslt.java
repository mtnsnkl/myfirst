package org.amzrst;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmznRslt {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.sendKeys("iphone",Keys.ENTER);
		List<WebElement> all = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		File f = new File("C:\\Users\\Public\\phone.xlsx");
		FileOutputStream fo = new FileOutputStream(f);
		Workbook wi = new XSSFWorkbook();
		Sheet sheet = wi.createSheet("one");
		for (int i = 0; i < all.size(); i++) {
			WebElement fort = all.get(i);
			String text = fort.getText();
			System.out.println(text);
			Row createRow = sheet.createRow(i);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(text);
				
		}
		wi.write(fo);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.quit();
		
		
		
		
		
	}

}
