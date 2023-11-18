package com.evs.vtiger.testscripts;




import com.evs.vtiger.appreusablecode.common.CommonReusableCodes;
import com.evs.vtiger.utils.WebUtil;

public class MarketingLeadsTestScripts {

  
	public void verifyVT006AccountTableUpdateAfterAccountCreation() throws InterruptedException {
		CommonReusableCodes rc=new  CommonReusableCodes();
		rc.login();


		WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
		WebUtil.mouseClick("//div[@id='Marketing_sub']//a[text()='Accounts']", "Marketing Accounts Link");

		int beforeAccountCount=WebUtil.getTableRowCount("//table[@class='lvt small']", "Account Table");
		
		WebUtil.myClick( "//img[@title='Create Account...']", "Create Account Button");
		WebUtil.mySendKeys( "ramesh7913", "//input[@name='accountname']", "Username Textbox");
		WebUtil.myClick("//input[@class='crmbutton small save']", "Save Button");
  
		WebUtil.myClick("//table[@class='level2Bg']//a[text()='Accounts']", "Marketing Accounts Link");
		
		int afterAccountCount=WebUtil.getTableRowCount("//table[@class='lvt small']", "Account Table");
        int expectedAccountCount=beforeAccountCount+1;
		
		WebUtil.verifyNumber(afterAccountCount, expectedAccountCount);
	 int columnCount =	WebUtil.getTableColumnNameCount("//table[@class='lvt small']", "Account Table");
       System.out.println(columnCount);
	}


	public void verifyVT001AccountCreation() throws InterruptedException {
		CommonReusableCodes rc=new CommonReusableCodes();
		rc.login();

		WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
		WebUtil.mouseClick("//div[@id='Marketing_sub']//a[text()='Accounts']", "Marketing Accounts Link");

		WebUtil.myClick("//img[@alt='Create Account...']", "Account Creation Button");
		WebUtil.mySendKeys("PracticeVtiger", "//input[@name='accountname']", "Account Name Box");
		WebUtil.mySendKeys("VtigerPractice.com", "//input[@name='website']", "Website Name Box");
		WebUtil.mySendKeys("(765) 435 325", "//input[@id='phone']", "Phone Number Box");
		WebUtil.mySendKeys("arjun_yadav@1secmail.com", "//input[@id='email1']", "Email Box");

		WebUtil.selectByValue("//select[@name='assigned_user_id']", "Assign To Dropdown", "1");

		WebUtil.mySendKeys("State-UP-City-Jaunpur", "//textarea[@name='bill_street']", "Billing Address Box");
		WebUtil.mySendKeys("None", "//input[@id='bill_pobox']", "bill_pobox ");
		WebUtil.mySendKeys("Varanasi", "//input[@id='bill_city']", "Billing City Box");
		WebUtil.mySendKeys("UP", "//input[@id='bill_state']", "Billing State Box");
		WebUtil.mySendKeys("423245", "//input[@id='bill_code']", "Billing Postal Code Box");
		WebUtil.mySendKeys("India", "//input[@id='bill_country']", "Billing Country Box");
		WebUtil.myClick("//b[text()='Copy Billing address']/preceding-sibling::input",
				"Account inforamation copy checkbox");
		WebUtil.mySendKeys("This Account Creation is only for testing Purpose", "//textarea[@name='description']",
				"Description Box");
		WebUtil.myClick("(//input[@title='Save [Alt+S]'])[2]", "Save Button");
	}



	public void verifyVT002AccountUpdate() {
		WebUtil.launchBrowser();
		WebUtil.openUrl( "http://localhost:8888/");
		WebUtil.mySendKeys( "admin", "//input[@name='user_name']", "Username Textbox");
		WebUtil.mySendKeys( "Arjun", "//input[@name='user_password']", "Password Textbox");
		WebUtil.myClick( "//input[@name='Login']", "Login Button");


		WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
		WebUtil.mouseClick("//div[@id='Marketing_sub']//a[text()='Accounts']", "Marketing Accounts Link");

	}

	public void verifyVT003AccountDelete() {
		CommonReusableCodes rc=new CommonReusableCodes();
		rc.login();
		WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
		WebUtil.mouseClick("//div[@id='Marketing_sub']//a[text()='Accounts']", "Marketing Accounts Link");
		
		WebUtil.getColumDataListByColumName("//table[@class='lvt small']", "Account Table", "Account Name");
		
		WebUtil.getRowNumberByAccountId("//table[@class='lvt small']//tr//td[2]", "Account Table", "ACC5", "Account No");
//		WebUtil.getRowDataListByRowNumber("//table[@class='lvt small']", "Account Table" , 4);
	
//		WebUtil.getColumDataListByColumNumber("//table[@class='lvt small']", "Accoun Table", 5);
		
//		WebUtil.getColumNameInList("//table[@class='lvt small']", "Account Table");
//		WebUtil.getColumNumberByColumName("//table[@class='lvt small']", "Account Table", "Account Name");
		
//		int beforeDeleteData = WebUtil.getTableDataCount("//input[@name='selected_id']", "Table Data");
//		WebUtil.myClick("//input[@id='150']", "Account Table Data");
//		WebUtil.myClick("//input[@class='crmbutton small delete']", "Delete Account Button");
//		WebUtil.alertHandleByAccept();
//		int afterDeleteData = WebUtil.getTableDataCount("//input[@name='selected_id']", "Table Data");
//		int expectTableData = beforeDeleteData-1;
//		WebUtil.verifyNumber(expectTableData, afterDeleteData);

	}

	public void verifyVT004AccountCheckbox() throws InterruptedException {
		WebUtil.launchBrowser();
		WebUtil.openUrl( "http://localhost:8888/");
		WebUtil.mySendKeys( "admin", "//input[@name='user_name']", "Username Textbox");
		WebUtil.mySendKeys( "Arjun", "//input[@name='user_password']", "Password Textbox");
		WebUtil.myClick( "//input[@name='Login']", "Login Button");
		WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
		WebUtil.mouseClick("//div[@id='Marketing_sub']//a[text()='Accounts']", "Marketing Accounts Link");
		WebUtil.myClick("//input[@name='selectall']", "CheckBox");
		Thread.sleep(5000);
		boolean chbox = WebUtil.myIsSelected("//input[@name='selectall']", "CheckBox");

		if (chbox==true) {
			System.out.println("Check Box is selected(Checked)");
		}else {
			System.out.println("Check Box is NOT selected(Checked)");

		}
		WebUtil.myClick("//input[@name='selectall']", "CheckBox");

		boolean chbox1 = WebUtil.myIsSelected("//input[@name='selectall']", "CheckBox");

		if (chbox1==false) {
			System.out.println("Check Box is NOT selected(Checked)");
		}else {
			System.out.println("Check Box is selected(Checked)");

		}
	}

	
	public void name() {
		WebUtil.launchBrowser();
		WebUtil.openUrl( "http://localhost:8888/");
		WebUtil.mySendKeys( "admin", "//input[@name='user_name']", "Username Textbox");
		WebUtil.mySendKeys( "Arjun", "//input[@name='user_password']", "Password Textbox");
		WebUtil.myClick( "//input[@name='Login']", "Login Button");
		
		WebUtil.mouseOver("//a[text()='Marketing']", "Marketing Link");
		WebUtil.mouseClick("//div[@id='Marketing_sub']//a[text()='Accounts']", "Marketing Accounts Link");
		
	}
}
