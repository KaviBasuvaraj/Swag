package org.run;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.pom.LoginPojo;
import org.pom.ProductDetails;
import org.pom.ProductList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.util.UtilClass;

public class Inventry_List_Page extends UtilClass {
	int productAdded=0;
	int productremoved=0;
	int finalProduct_cart=0;
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
	public void visibility_Check() throws IOException {
		ProductList p = new ProductList();
		WebElement menu_Button = p.getMenu_Button();
		boolean displayed = menu_Button.isDisplayed();
		System.out.println("Menu Button is Visible : "+displayed);
		WebElement cart_Icon = p.getCart_Icon();
		boolean displayed2 = cart_Icon.isDisplayed();
		System.out.println("Cart Icon is Visible : "+displayed2);
		WebElement filter_Button = p.getFilter_Button();
		boolean displayed3 = filter_Button.isDisplayed();
		System.out.println("Filter Option is Available : "+displayed3);
	
		
		
		
		
		
		List<WebElement> product_image = p.getProduct_image();
		WebElement webElement4 = product_image.get(0);
		boolean displayed6 = webElement4.isDisplayed();
		System.out.println("Product Image is visiable : "+displayed6);
		
		List<WebElement> product_Price = p.getProduct_Price();
		WebElement webElement5 = product_Price.get(0);
		boolean displayed7 = webElement5.isDisplayed();
		System.out.println("Product Prise is Visiable :"+displayed7);
		
		List<WebElement> product_Description = p.getProduct_Description();
		WebElement webElement6 = product_Description.get(0);
		boolean displayed8 = webElement6.isDisplayed();
		System.out.println("Product Discription is visiable :"+displayed8);
		
		
		List<WebElement> products = p.getProducts();
		for (int i = 0; i < products.size();i++){
			WebElement webElement3= products.get(i);
			String text =webElement3.getText();
			System.out.println("Product Name"+i+" : "+text);
			
			
		}
		BrokenLink();
		
		
	}
	
	@Test
	public void addToCart() {
		ProductDetails p1= new ProductDetails();
		ProductList p = new ProductList();
		List<WebElement> products = p.getProducts();
		for (int i = 0; i < products.size();i++){
			WebElement webElement3= products.get(i);
			webElement3.click();
			
			WebElement addToCart_DetailPage = p1.getAddToCart_DetailPage();
			addToCart_DetailPage.click();
			WebElement backToProductPage = p1.getBackToProductPage();
			backToProductPage.click();

			productAdded++;
			
		}
		
		
	}
	
	@Test(priority=1)
	public void remove_Product() {
		
		ProductList p = new ProductList();
		
	
		List<WebElement> removet_Button_proPage = p.getRemovet_Button_proPage();
		WebElement webElement = removet_Button_proPage.get(2);
		webElement.click();
		productremoved++;
		WebElement webElement1= removet_Button_proPage.get(4);
		webElement1.click();
		productremoved++;
		
	}
	
	@Test(priority=2)
	public void Card_count() {
		ProductList p = new ProductList();
		 WebElement product_Count_in_cart = p.getProduct_Count_in_cart();
		 String text = product_Count_in_cart.getText();
		System.out.println("Total Product available in cart : "+ text);
		
		
	}
	
}
