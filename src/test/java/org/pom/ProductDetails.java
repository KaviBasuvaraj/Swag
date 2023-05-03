package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.UtilClass;

public class ProductDetails extends UtilClass {
	
	public ProductDetails() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addToCart_DetailPage;
	
	@FindBy(xpath="//button[text()='Back to products']")
	private WebElement backToProductPage;
	
	@FindBy(xpath="//button[text()='Back to products']")
	private WebElement removeProduct;

	public WebElement getRemoveProduct() {
		return removeProduct;
	}

	public WebElement getAddToCart_DetailPage() {
		return addToCart_DetailPage;
	}

	public WebElement getBackToProductPage() {
		return backToProductPage;
	}

}
