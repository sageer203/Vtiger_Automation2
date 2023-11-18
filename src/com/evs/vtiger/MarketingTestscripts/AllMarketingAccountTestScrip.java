package com.evs.vtiger.MarketingTestscripts;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.appreusablecode.common.CommonReusableCodes;
import com.evs.vtiger.appreusablecodeMarketing_Account.MarketingAccountCreatePage;
import com.evs.vtiger.appreusablecodeMarketing_Account.MarketingAccountEditDetailepage;
import com.evs.vtiger.appreusablecodeMarketing_Account.MarketingAccountLandingPage;
import com.evs.vtiger.utils.WebUtil;

public class AllMarketingAccountTestScrip {
	public void T001AccountLanding() {
		 CommonReusableCodes cc=PageFactory.initElements(WebUtil.driver,CommonReusableCodes.class ); 
				 cc.login();
		 cc.gotoMarketingAccountsPage();
		 
		  MarketingAccountLandingPage malp=new MarketingAccountLandingPage();
		//  malp.MarketingAccountcheckboxTable();
		//  malp.MarketingAccountplusbutton();
		  
	  MarketingAccountCreatePage macp=new MarketingAccountCreatePage();
		  
		  macp.enterAndSaveMarketingAccountInfo();
		  
		 
		 
		
	}
	public void T002AccounEdit() {
		 MarketingAccountEditDetailepage maedp=new MarketingAccountEditDetailepage();
		  maedp.clickeditmarketingAccountEdite();
	}

}
