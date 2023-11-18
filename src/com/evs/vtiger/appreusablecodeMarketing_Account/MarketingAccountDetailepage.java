 package com.evs.vtiger.appreusablecodeMarketing_Account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class MarketingAccountDetailepage {
	@FindBy(xpath =  "//img[@alt='Create Account...']")
     private WebElement maplusbutton;
    
	
	
    public void clickCreateMarketingAccountButton() {
    	WebUtil.myClick(maplusbutton, "Account Creation Button");
    }
	
	

	
}
