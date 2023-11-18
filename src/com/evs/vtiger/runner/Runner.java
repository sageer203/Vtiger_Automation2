package com.evs.vtiger.runner;

import com.evs.vtiger.InventoryTestscripts.InventoryInvoiceTestScript;
import com.evs.vtiger.MarketingTestscripts.AllMarketingAccountTestScrip;


public class Runner {

	/// mrthod of this class will call TestScripts methods only
	//// Runner class will not call reusablecode and generic methods
	public static void main(String[] args) throws InterruptedException {
//		AllMarketingAccountTestScrip amats=new AllMarketingAccountTestScrip();
	//	amats.T001AccountLanding();
	//	amats.T002AccounEdit();
		InventoryInvoiceTestScript iits= new InventoryInvoiceTestScript();
	iits.TC001InventoryInvoice();
	}

}
