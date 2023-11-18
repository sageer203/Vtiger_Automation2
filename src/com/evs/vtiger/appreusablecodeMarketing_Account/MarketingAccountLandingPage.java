package com.evs.vtiger.appreusablecodeMarketing_Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class MarketingAccountLandingPage {
	@ FindBy(xpath = "//img[@title='Create Account...']")
	private WebElement McreateAccountPB;
	
	public void MarketingAccountplusbutton() {
		WebUtil.myClick(McreateAccountPB, "MarketingAccount plusbutton");
		
	}
//public void MarketingAccountcheckboxTable() {
//	boolean chbox = WebUtil.myIsSelected("//input[@name='selectall']", "CheckBox");
//
//	if (chbox==true) {
//		System.out.println("Check Box is selected(Checked)");
//	}else {
//		System.out.println("Check Box is NOT selected(Checked)");
//
//	}
//	WebUtil.myClick("//input[@name='selectall']", "CheckBox");
//
//	boolean chbox1 = WebUtil.myIsSelected("//input[@name='selectall']", "CheckBox");
//
//	if (chbox1==false) {
//		System.out.println("Check Box is NOT selected(Checked)");
//	}else {
//		System.out.println("Check Box is selected(Checked)");
//
//	}
//}

}
	


