package com.evs.vtiger.appreusablecode.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class CommonReusableCodes {
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userTB;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement passwordTB;
	
	@FindBy(xpath = "//input[@name='Login']")
	private WebElement Click;
	
	@FindBy(xpath = "//a[text()='Marketing']")
	private WebElement mouseoverMarketing;
	
	@FindBy(xpath = "//div[@id='Marketing_sub']//a[text()='Accounts']")
	private WebElement mouseclickMA;
	
	@FindBy(xpath = "//a[text()='Inventory']")
	private WebElement mouseoverMarketingInventory;
	
	@FindBy(xpath = "//div[@id='Inventory_sub']//a[text()='Invoice']")
	private WebElement  mouseclickMI;

	////  it will use generic methods to automate application dependent generic methods
	public  void login() {
		
		
		WebUtil.mySendKeys(userTB,"admin", "Username Textbox");
		WebUtil.mySendKeys(passwordTB,"user", "Password Textbox");
		WebUtil.myClick(Click, "Login Button");
	
	}
	
	public void logout() {
		
	}
	
	public void gotoMarketingAccountsPage() {
		WebUtil.mouseOver(mouseoverMarketing, "Marketing Link");
		WebUtil.mouseClick(mouseclickMA, "Marketing Accounts Link");

	}
	public void gotoInvontryPage() {
		WebUtil.mouseOver(mouseoverMarketingInventory, "Inventory Link");
		WebUtil.mouseClick(mouseclickMI, "Marketing Accounts Link");

	}

	
	
	
}
