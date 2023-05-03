package org.run;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.pom.Cart;
import org.pom.LoginPojo;
import org.pom.ProductList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.util.UtilClass;

public class Cart_CheckOut extends UtilClass {
	
	@BeforeClass
	public void launchURL() {
		launchUrl(" https://www.saucedemo.com/");
	} 
    
	
	@Test
	public static void Login() throws IOException {
		LoginPojo l = new LoginPojo();
		WebElement userName = l.getUserName();
		userName.sendKeys(readDataFromExcel(1, 0, 1));
		WebElement password= l.getPassword();
		password.sendKeys(readDataFromExcel(1, 4, 1));
		WebElement loginButton = l.getLoginButton();
		loginButton.click();
	}
	
	@Test
	public void cart() {
		ProductList p = new ProductList();
		Cart c = new Cart();
		WebElement product_Count_in_cart = p.getProduct_Count_in_cart();
		String text = product_Count_in_cart.getText();
		int co=Integer.parseInt(text);
		product_Count_in_cart.click();
		
		List<WebElement> qty = c.getQty();
		int size = qty.size();
		WebElement webElement = qty.get(0);
		
		boolean enabled = webElement.isEnabled();
		System.out.println("Quantity can be Increase : "+ enabled);
		
		if(co==size) {
			System.out.println("Quantity of added product count correct");
		}
		else {
			System.out.println("Count mismatch");
		}
		
		List<WebElement> remove = c.getRemove();
		WebElement webElement2 = remove.get(0);
		boolean displayed = webElement2.isDisplayed();
		System.out.println("Remove button id displaying : "+ displayed);
		
		WebElement checkout = c.getCheckout();
		boolean displayed2 = checkout.isDisplayed();	
		System.out.println("Checkout Button in Displayed :" + displayed2);
		checkout.click();
		
		String title = driver.getTitle();
		 if(title.contains("checkout")) {
			 System.out.println("Application Dispaying currect page");
		 }
		 else {
			 System.out.println("Check the Page/Fuction");
		 }
		 
		 backword();
		 implicitWait();
		 
		 WebElement continue_shop = c.getContinue_shop();
		 continue_shop.click();
		 String title2 = driver.getTitle();
		 if(title2.contains("inventory")) {
			 System.out.println("Application was in correct page ");
			 System.out.println("\n Continue Shoping");
		 }
		 else {
			 System.out.println("application was in wrong page");
		 }
		
		
		
		
		
		
	}

}
