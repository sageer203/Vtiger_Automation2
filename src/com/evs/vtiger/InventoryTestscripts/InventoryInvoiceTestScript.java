package com.evs.vtiger.InventoryTestscripts;

import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.appreusablecode.common.CommonReusableCodes;
import com.evs.vtiger.appreusablecodeInventory.Invoice.InventoryInvoiceCreateingPage;
import com.evs.vtiger.appreusablecodeInventory.Invoice.InventoryInvoiceLandingPage;
import com.evs.vtiger.utils.WebUtil;

public class InventoryInvoiceTestScript {
public void TC001InventoryInvoice() {
	WebUtil.openurlpage();
	 CommonReusableCodes crc=PageFactory.initElements(WebUtil.driver, CommonReusableCodes.class);
             crc.login();
             crc.gotoInvontryPage();
             InventoryInvoiceLandingPage iilp=new InventoryInvoiceLandingPage();
             iilp.InventoryInvoicePlusbutton();
             InventoryInvoiceCreateingPage iicp=new InventoryInvoiceCreateingPage();
             iicp.createpagefill();


}
}
