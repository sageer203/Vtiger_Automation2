package com.evs.vtiger.appreusablecodeMarketing_Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class MarketingAccountEditDetailepage {
	@FindBy(xpath = "input[@name='Edit']")
	private WebElement MAeditbutton;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement accountname;
	@FindBy(xpath =  "//input[@name='website']")
	private WebElement website;
	@FindBy(xpath =  "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath ="//input[@id='email1']" )
	private WebElement email;
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[2]" )
	private WebElement savebutton;
	
	public void clickeditmarketingAccountEdite() {
		WebUtil.myClick(MAeditbutton, "edit button");
		WebUtil.mySendKeys(accountname,"PracticeVtiger", "Account Name Box");
		WebUtil.mySendKeys(website,"VtigerPractice.com", "Website Name Box");
		WebUtil.mySendKeys(phone,"(765) 435 325", "Phone Number Box");
		WebUtil.mySendKeys(email,"arjun_yadav@1secmail.com",  "Email Box");
		WebUtil.myClick(savebutton, "Save Button");
	}
	
}
