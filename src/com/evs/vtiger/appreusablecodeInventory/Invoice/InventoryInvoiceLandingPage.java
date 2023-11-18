package com.evs.vtiger.appreusablecodeInventory.Invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class InventoryInvoiceLandingPage {
	@FindBy(xpath ="//img[@title='Create Invoice...']" )
	private WebElement iinvoicebutton;
	public void InventoryInvoicePlusbutton() {
		WebUtil.myClick(iinvoicebutton, "InventoryInvoice Button");
	}

}
