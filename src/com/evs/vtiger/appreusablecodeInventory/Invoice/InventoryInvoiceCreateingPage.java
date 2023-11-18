package com.evs.vtiger.appreusablecodeInventory.Invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.vtiger.utils.WebUtil;

public class InventoryInvoiceCreateingPage {
	
	@FindBy(xpath = "//input[@name='subject']")
	private WebElement subject;
	@FindBy(xpath = "//img[@onclick='selectSalesOrder();']" )
	private WebElement saleorderbutton;
	
	@FindBy(xpath = "//input[@id='search_txt']")
private WebElement searchtx;	
	@FindBy(xpath = "//select[@name='search_field']")
			private  WebElement searchfied;
	@FindBy (xpath = "//input[@class='crmbutton small create']")
	private WebElement crbuttonclick;
	
	@FindBy(xpath = "//a[text()='MA capital']")
	private WebElement capitalclick;
	
	
	public void createpagefill() {
		WebUtil.mySendKeys(subject,"Economics", "Subject");
		WebUtil.myClick(saleorderbutton, "Saleorderpulusbutton");
		WebUtil.mySwitchToWindowByUrl("http://localhost:8888/index.php?module=SalesOrder&action=Popup&html=Popup_picker&popuptype=specific&form=EditView");
		WebUtil.mySendKeys(searchtx,"MA", "search");
		WebUtil.selectByValue(searchfied, "subeject", "subject");
		WebUtil.myClick(crbuttonclick, "Clicksearch");
		WebUtil.myClick(capitalclick, "Ma");
		WebUtil.mySwitchToWindowByUrl("http://localhost:8888/index.php?module=Invoice&action=EditView&return_action=DetailView&parenttab=Inventory");
	}

}
