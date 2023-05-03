package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.UtilClass;

public class Cart extends UtilClass {
	
	public Cart() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cart_quantity']")
	private List<WebElement> Qty;
	
	@FindBy(xpath="//div[@class='item_pricebar']//div")
	private List<WebElement> price;
	
	@FindBy(xpath="//button[text()='Remove']")
	private List<WebElement> Remove;
	
	@FindBy(xpath="//button[text()='Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	private WebElement continue_shop;

	public List<WebElement> getQty() {
		return Qty;
	}

	public List<WebElement> getPrice() {
		return price;
	}

	public List<WebElement> getRemove() {
		return Remove;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getContinue_shop() {
		return continue_shop;
	}
	
	
	
	

}
