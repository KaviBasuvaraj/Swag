package org.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilClass {

	public static WebDriver driver;
	public static Select s;
	

	public static void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String fetchTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void backword() {
		driver.navigate().back();
		
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void closeCurrentTab() {
		driver.close();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static String fetchText(WebElement txt) {
		String text = txt.getText();
		return text;
	}

	public static void SendText(WebElement e1, String value) {
		e1.sendKeys(value);
	}
	

	public static void click(WebElement e2) {
		e2.click();
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}

	public static String fetchTxtPassed(WebElement e3, String name) {
		String valuePassed = e3.getAttribute(name);
		return valuePassed;

	}

	public static void selectIndex(WebElement e4, int index) {
		s = new Select(e4);
		s.selectByIndex(index);
	}
	public static String readDataFromExcel(int sheetNo, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\KAVI B\\eclipse-workspace\\Swag\\Excel\\Swag Labs Manual Test-Case.xlsx");
		FileInputStream fil = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fil);
		Sheet sheet = w.getSheetAt(sheetNo);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int type = cell.getCellType();

		String input;
		if (type == 1) {
			input = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd/MMM/yyyy");
			input = sim.format(date);

		} else {
			double dou = cell.getNumericCellValue();
			long l = (long) dou;
			input = String.valueOf(l);
		}

		return input;

	}
	
	public static void BrokenLink() throws IOException {
		int count =0;
		
		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		int size = findElements.size();
		for(WebElement link:findElements) {
			
			String LinkUrl = link.getAttribute("href");
			
			if(LinkUrl!=null) {
				URL url = new URL(LinkUrl);
				URLConnection o = url.openConnection();
				HttpsURLConnection h =(HttpsURLConnection)o;
				int code = h.getResponseCode();
				if(code!=200) {
					System.out.println(LinkUrl+ "Broken "+ code);
					count++;
				}
			}
		}
		System.out.println("Total Boken Link Count : "+count);
		System.out.println("Total Link Count : "+size);
	}


}
