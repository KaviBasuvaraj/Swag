package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.UtilClass;

public class ProductList extends UtilClass {
	
	public ProductList() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cart_Icon;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement Filter_Button;
	
	@FindBy(xpath="//img[@alt='Open Menu']")
	private WebElement Menu_Button;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	private List<WebElement> products;
	
	
	@FindBy(xpath="//div[@class='inventory_item_price']")
	private List<WebElement> product_Price;
	
	@FindBy(xpath="//div[@class='inventory_item_desc']")
	private List<WebElement> product_Description;
	
	@FindBy(xpath="//div[@class='inventory_item_img']")
	private List<WebElement> product_image;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	private List<WebElement> add_To_Cart_Button_proPage;
	
	@FindBy(xpath="//button[text()='Remove']")
	private List<WebElement> removet_Button_proPage;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement Product_Count_in_cart;

	public WebElement getCart_Icon() {
		return cart_Icon;
	}

	public WebElement getFilter_Button() {
		return Filter_Button;
	}

	public WebElement getMenu_Button() {
		return Menu_Button;
	}

	public List<WebElement> getProducts() {
		return products;
	}

	public List<WebElement> getProduct_Price() {
		return product_Price;
	}

	public List<WebElement> getProduct_Description() {
		return product_Description;
	}

	public List<WebElement> getProduct_image() {
		return product_image;
	}

	public List<WebElement> getAdd_To_Cart_Button_proPage() {
		return add_To_Cart_Button_proPage;
	}

	public List<WebElement> getRemovet_Button_proPage() {
		return removet_Button_proPage;
	}

	public WebElement getProduct_Count_in_cart() {
		return Product_Count_in_cart;
	}
	
	
	
	
	

}
