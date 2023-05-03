package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.util.UtilClass;

public class LoginPojo extends UtilClass{
	
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(xpath="//input[@type='text']"),
		@FindBy(id="user-name"),
		@FindBy(name="user-name")
	})
	private WebElement userName;
	
			@FindBy(xpath="//input[@type='password']")
		
	private WebElement password;
	
	@FindAll({
		@FindBy(xpath="//input[@type='submit']"),
		@FindBy(id="login-button"),
		@FindBy(xpath="//input[@value='Login']"),
	})
	private WebElement loginButton;
	
	@FindBy(xpath="//h3[@data-test='error']")
	private WebElement blockedUser;

	public WebElement getMessage() {
		return blockedUser;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	
	
	
	

}
