package org.run;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.pom.LoginPojo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.util.UtilClass;

public class Login extends UtilClass {
	
	
		

	
	@BeforeClass
	public void launchBrowser() {
		openBrowser();
		maxWindow();
	}
	
	@Test
	public void launchURL() {
		launchUrl(" https://www.saucedemo.com/");
	}
	
	@Test
	public void login_with_valid_date() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement userName = l.getUserName();
		userName.sendKeys(readDataFromExcel(1, 3, 1));
		WebElement password = l.getPassword();
		password.sendKeys(readDataFromExcel(1, 4, 1));
		WebElement loginButton = l.getLoginButton();
		loginButton.click();
		backword();
		implicitWait();
		
	}
	
	@Test
	public void login_with_valid_date1() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement userName1 = l.getUserName();
		userName1.sendKeys(readDataFromExcel(1, 1, 1));
		WebElement password1 = l.getPassword();
		password1.sendKeys(readDataFromExcel(1, 4, 1));
		WebElement loginButton1 = l.getLoginButton();
		loginButton1.click();
		
		
	    refresh();
	    implicitWait();
	}
	
	@Test
	public void login_with_valid_date2() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement userName2 = l.getUserName();
		userName2.sendKeys(readDataFromExcel(1, 2, 1));
		WebElement password2 = l.getPassword();
		password2.sendKeys(readDataFromExcel(1, 4, 1));
		WebElement loginButton2 = l.getLoginButton();
		loginButton2.click();
	   backword();
	   implicitWait();
	}
	
	@Test
	public void login_with_valid_date3() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement userName3 = l.getUserName();
		userName3.sendKeys(readDataFromExcel(1, 0, 1));
		WebElement password3 = l.getPassword();
		password3.sendKeys(readDataFromExcel(1, 4, 1));
		WebElement loginButton3 = l.getLoginButton();
		loginButton3.click();
	}
	
	
}
