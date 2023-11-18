package com.evs.vtiger.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {

	public static WebDriver driver; /// null

	///  generic methods , web utility methods  -   application independent methods
	///  wrapper methods  -   
	
	
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions(); 
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Chrome Browser launched successfully");

	}
	public static void openurlpage() {
		WebUtil.launchBrowser();
		WebUtil.openUrl("http://localhost:8888/");
	}
	

	public static void openUrl(String url) {
		try {
			driver.get(url);
		} catch (NullPointerException e) {
			System.out.println("Our driver is null");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Hit the URL successfully");
	}

	public static void mySendKeys(WebElement we, String inputValue, String elementName) {
		

		try {
			we.sendKeys(inputValue);
			System.out.println(inputValue + " value entered in " + elementName + "Element");

		} catch (StaleElementReferenceException e) {
		
			we.sendKeys(inputValue);
			System.out.println(inputValue + " value entered in " + elementName + " Element");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].value='admin'", we);
			System.out.println(inputValue + " value entered in " + elementName + " Element");

		} catch (NullPointerException e) {
			

			System.out.println(inputValue + " value NOT entered in " + elementName + " Element");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
//	public static List<WebElement> myFindElements(WebElement we, String elementName) {
//		List<WebElement> we = null;
//		try {
//			we = driver.findElements(By.xpath(xpathValue));
//			System.out.println(elementName + " Element found successfully ");
//		} catch (InvalidArgumentException e) {
//			System.out.println("There is something mistake or invalid syntex of xpath ");
//			throw e;
//
//		}catch (UnhandledAlertException e) {
//			System.out.println("There is Atert on WebPage");
//		}
//		catch (Exception e) {
//			System.out.println(elementName + " Element NOT found successfully ");
//			e.printStackTrace();
//		}
//		return we;
		
		/*  This method does'n throw NoSuchElementExpection
		 *  catch (NoSuchElementException e) {
			WebDriverWait webDriWat = new WebDriverWait(driver, Duration.ofSeconds(30));
			webDriWat.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue)));
			we = driver.findElements(By.xpath(xpathValue));

		}
		 */
	//}

	public static void myClick(WebElement we, String elementName) {

	 
		try {
			we.click();
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (StaleElementReferenceException e) {
		
			we.click();
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (ElementNotInteractableException e) {

			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on " + elementName + " Button Succesfully");
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (Exception e) {
			System.out.println("Unable to Click on " + elementName + " Button ");
			e.printStackTrace();
		}
	}

	public static boolean myIsSelected(WebElement we, String elementName) {
	
		boolean elementStatus = false;
		try {
			elementStatus = we.isSelected();
		}catch (StaleElementReferenceException e) {
			
			elementStatus = we.isSelected();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return elementStatus;

	}

	public static boolean myIsEnabled(WebElement we, String elementName) {
	
		boolean elementStatus = false;
		try {
			elementStatus = we.isEnabled();
		}catch (StaleElementReferenceException e) {
			
			elementStatus = we.isEnabled();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return elementStatus;

	}

	public static boolean myIsDesplayed(WebElement we, String elementName) {
	
		boolean elementStatus = false;
		try {
			elementStatus = we.isDisplayed();
		}catch (StaleElementReferenceException e) {
			
			elementStatus = we.isDisplayed();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return elementStatus;

	}

	public static int myGetElementHight(WebElement we , String elementName) {
	
		Dimension dimeObj = null;
		int elementHight = 0;
		try {
			dimeObj = we.getSize();
		}catch (StaleElementReferenceException e) {
			
			dimeObj = we.getSize();
		}catch (Exception e) {
			e.printStackTrace();
		}
		elementHight = dimeObj.getHeight();
		try {
			elementHight = dimeObj.getHeight();
		}catch (NullPointerException e) {
			
			dimeObj = we.getSize();
			elementHight = dimeObj.getHeight();
		}
		return elementHight;

	}

	public static int myGetElementWidth(WebElement we , String elementName) {
	
		Dimension dimeObj = null;
		int elementHight = 0;
		try {
			dimeObj = we.getSize();
		}catch (StaleElementReferenceException e) {
			
			dimeObj = we.getSize();
		}catch (Exception e) {
			e.printStackTrace();
		}
		elementHight = dimeObj.getWidth();
		try {
			elementHight = dimeObj.getWidth();
		}catch (NullPointerException e) {
			
			dimeObj = we.getSize();
			elementHight = dimeObj.getWidth();
		}
		return elementHight;

	}

	public static String myGetText(WebElement we, String elementName) {
	
		String innerText = null;
		try {
			innerText = we.getText();
			System.out
			.println("InnerText of the " + elementName + "Found successfully And InnerText is-->" + innerText);
		} catch (StaleElementReferenceException e) {
			
			System.out
			.println("InnerText of the " + elementName + "Found successfully And InnerText is-->" + innerText);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return innerText;
	}

	public static String myGetAttribute(WebElement we, String elementName, String attributeName) {
	
		String attributeValue = null;
		try {
			attributeValue = we.getAttribute(attributeName);
			System.out.println("attributeValue of the " + elementName + "Found successfully And attributeValue is-->"
					+ attributeValue);
		} catch (StaleElementReferenceException e) {
			
			System.out.println("attributeValue of the " + elementName + "Found successfully And attributeValue is-->"
					+ attributeValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeValue;
	}


	public static void mouseOver(WebElement we, String elementName) {
		Actions actionsObj = new Actions(driver);
	
		try {
			actionsObj.moveToElement(we).build().perform();
			System.out.println("MovseOver Action perform on " + elementName + " Successfully");

		} catch (NullPointerException e) {
			
			actionsObj.moveToElement(we).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mouseContextClick(WebElement we, String elementName) {
		Actions actObj = new Actions(driver);
	
		try {
			actObj.contextClick(we).build().perform();
			System.out.println("Right Click Action perform on " + elementName + " Successfully");
		} catch (NullPointerException e) {
			
			actObj.contextClick(we).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mouseClick(WebElement we, String elementName) {
		Actions actionsObj = new Actions(driver);
	
		try {
			actionsObj.click(we).build().perform();
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (ElementClickInterceptedException e) {

			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mouseDoubleClick(WebElement we, String elementName) {
		Actions actionsObj = new Actions(driver);
	
		try {
			actionsObj.doubleClick(we).build().perform();
			System.out.println("DoubleClick Action perform on " + elementName + " Successfully");
		} catch (NullPointerException e) {
			
			actionsObj.doubleClick(we).build().perform();
		} catch (ElementClickInterceptedException e) {

			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jss = (JavascriptExecutor) driver;
			jss.executeScript("arguments[0].click()'", we);
			System.out.println("Clicked on " + elementName + " Button Succesfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mouseClickAndHold(WebElement we, String elementName) {
		Actions actObj = new Actions(driver);
	
		try {
			actObj.clickAndHold(we).build().perform();
			System.out.println("ClickAndHold Action perform on " + elementName + " Successfully");
		} catch (NullPointerException e) {
			
			actObj.clickAndHold(we).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mouseDragAndDrop(WebElement firstElementWebEle, WebElement secondElementWebEle,
			String firstElementName, String secondElementName) {
		Actions actObj = new Actions(driver);
//	condElementWebEle = myFindElement(secondElementxpathValue, secondElementName);
		try {
			actObj.dragAndDrop(firstElementWebEle, secondElementWebEle).build().perform();
			System.out.println(
					"DragAndDrop Action perform on " + firstElementName + " To " + secondElementName + " Successfully");
		//} catch (NullPointerException e) {
	//		firstElementWebEle = myFindElement(firstElementxpathValue, firstElementName);
		//	secondElementWebEle = myFindElement(secondElementxpathValue, secondElementName);
		} catch (Exception e) {
		//	e.printStackTrace();
		}
	}

	public static void verifyText(String actualText, String expectedText) {
		if (actualText.equalsIgnoreCase(expectedText) == true) {
			System.out.println(" Validation is Passed. Actual-" + actualText + ", Expected-" + expectedText);
		} else {
			System.out.println(" Validation is Failed. Actual-" + actualText + ", Expected-" + expectedText);
		}
	}

	public static void verifyNumber(int actualNumber, int expectedNumber) {
		if(actualNumber==expectedNumber) {
        	System.out.println("passed. expected="+expectedNumber+", Actual="+actualNumber);
        }else {
        	System.out.println("failed. expected="+expectedNumber+", Actual="+actualNumber);
        }
	}
	
	
	public static void selectByValue(WebElement we, String elementName, String value) {
	
		Select selectObj = new Select(we);
		try {
			selectObj.selectByValue(value);
		} catch (NullPointerException e) {
			selectObj = new Select(we);
			selectObj.selectByValue(value);
			System.out.println("Our Referance variable was null");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectByIndex(WebElement we, String elementName, int indexValue) {
	
		Select selectObj = new Select(we);
		try {
			selectObj.selectByIndex(indexValue);
		} catch (NullPointerException e) {
			selectObj = new Select(we);
			selectObj.selectByIndex(indexValue);
			System.out.println("Our Referance variable was null");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectByText(WebElement we, String elementName,
			String innerTextOfOption) {
		
		Select selectObj = new Select(we);
		try {
			selectObj.selectByValue(innerTextOfOption);
		} catch (NullPointerException e) {
			selectObj = new Select(we);
			selectObj.selectByVisibleText(innerTextOfOption);
			System.out.println("Our Referance variable was null");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getSelectedOptionText(WebElement weOption, String elementName) {
	
		Select selectObj = new Select(weOption);
	weOption = selectObj.getFirstSelectedOption();
		String optionText=weOption.getText();
		return optionText;
	}

//	public static List<String> getSelectAllOptionsText() {
//	
//		Select selectObj = new Select(we);
//
//		String optionText = null;
//		List<String> listObj = new ArrayList<String>();
//		List<WebElement> listOfOption = selectObj.getOptions();
//		for (int i = 0; i < listOfOption.size(); i++) {
//		weOfOption = listOfOption.get(i);
//			optionText = weOfOption.getText();
//			listObj.add(optionText);
//		}
//		System.out.println("Options Present in " + elementName + " Dropdown is -->" + listObj);
//
//
//		return listObj;
//	}

	public static void mySwitchToWindowByTitle(String expectTitle) {
		Set<String> allHandleValue = driver.getWindowHandles();
		for (String singleHandleValue : allHandleValue) {
			driver.switchTo().window(singleHandleValue);
			String actualTitle = driver.getTitle();
			if (actualTitle.equalsIgnoreCase(expectTitle)) {
				System.out.println(
						"Your driver Foucse is now Switch on Desire Window And handleValue is->" + singleHandleValue);
				break;
			}
		}
	}

	public static void mySwitchToWindowByUrl(String expectUrl) {
		Set<String> allHandleValue = driver.getWindowHandles();
		for (String singleHandleValue : allHandleValue) {
			driver.switchTo().window(singleHandleValue);
			String actualUrl = driver.getCurrentUrl();
			if (actualUrl.contains(expectUrl)) {
				System.out.println(
						"Your driver Foucse is now Switch on Desire Window And handleValue is->" + singleHandleValue);
				break;
  
			}
			
		}
	}

	public static void switchToIframeByIndex(int indexValue) {
		try {
			driver.switchTo().frame(indexValue);
			System.out.println("You have switched on your Desire Frame");
		} catch (NoSuchFrameException e) {
			driver.switchTo().frame(indexValue);
			System.out.println("You have switched on your Desire Frame");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToIframeByString(String idOrNameValue) {
		try {
			driver.switchTo().frame(idOrNameValue);
			System.out.println("You have switched on your Desire Frame");

		} catch (NoSuchFrameException e) {
			driver.switchTo().frame(idOrNameValue);
			System.out.println("You have switched on your Desire Frame");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToIframeByWebElement(WebElement weFrame, String elementName) {

		

		try {
			driver.switchTo().frame(weFrame);
			System.out.println("You have switched on your Desire Frame");

		} catch (NoSuchFrameException e) {
			driver.switchTo().frame(weFrame);
		} catch (StaleElementReferenceException e) {
			
			driver.switchTo().frame(weFrame);
			System.out.println("You have switched on your Desire Frame");

		}
	}

	public static void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			System.out.println("You have switched on Parent Frame");

		} catch (NoSuchFrameException e) {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToMainWindow() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("You have switched on Main Frame");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alertHandleByAccept() {
		Alert alertObj =driver.switchTo().alert();
		try {
			alertObj.accept();
			System.out.println("You have clicked on Accept Button Of Alert");
		}catch (NullPointerException e) {
			alertObj =driver.switchTo().alert();
			alertObj.accept();
			System.out.println("You have clicked on Accept Button Of Alert");
		}catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void alertHandleByDismiss() {
		Alert alertObj =driver.switchTo().alert();
		try {
			alertObj.dismiss();
			System.out.println("You have clicked on Dismiss Button Of Alert");
		}catch (NullPointerException e) {
			alertObj =driver.switchTo().alert();
			alertObj.dismiss();
			System.out.println("You have clicked on Dismiss Button Of Alert");
		}catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String alertHandleGetText() {
		Alert alertObj =driver.switchTo().alert();
		String text = null;
		try {
			text = alertObj.getText();
			System.out.println("This is the Text Present on Alert -> "+text);
		}catch (NullPointerException e) {
			alertObj =driver.switchTo().alert();
			text = alertObj.getText();
			System.out.println("This is the Text Present on Alert -> "+text);
		}catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}
	public static void alertHandleSendKeys(String inputValue ) {
		Alert alertObj = driver.switchTo().alert();
		try {
			alertObj.sendKeys(inputValue);
			System.out.println("You have entered the "+inputValue +"in Alert TextBox");
		}catch (NullPointerException e) {
			alertObj = driver.switchTo().alert();
			alertObj.sendKeys(inputValue);
			System.out.println("You have entered the "+inputValue +"in Alert TextBox");
		}catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

//    public static void checkAllCheckboxes(String xpath) {
//    	
//    	List<WebElement> weListCheckboxes=driver.findElements(By.xpath(xpath));
//    	for(int i=0; i<=weListCheckboxes.size()-1;i++) {
//    	weCheckbox=weListCheckboxes.get(i);
//    		boolean checkboxStatus=weCheckbox.isSelected();
//    		if(checkboxStatus==false) {
//    			weCheckbox.click();
//    		}
//    		
//    	}
//    
//    }
//    
//    public static void uncheckAllCheckboxes(String xpath) {
//    	
//    	List<WebElement> weListCheckboxes=driver.findElements(By.xpath(xpath));
//    	for(int i=0; i<=weListCheckboxes.size()-1;i++) {
//    	weCheckbox=weListCheckboxes.get(i);
//    		boolean checkboxStatus=weCheckbox.isSelected();
//    		if(checkboxStatus==true) {
//    			weCheckbox.click();
//    		}
//    		
//    	}
//    
//    }
//    
    
	//////   findElement - 1) search element page or html 
                         //  2)return WebELement - 1 element - 1st 
	                    ///  xpath- wrong - no element - NoSuchELementException
	//////  findElements - search all the elements as per xpath
     ///    return -  List<WebElement>
     /// xpath -wrong - empty List	
	
//	public static int getTableRowCount(String tableXPath, String tableElementName) {
//		
//		List<WebElement> listRow=driver.findElements(By.xpath(tableXPath+"//tr"));
//		int rowCount=listRow.size();
//		return rowCount-1;
//	}
//	
//	public static int getTableColumnNameCount(String tableXPath, String tableElementName) {
//		
//		List<WebElement> listColumnNames=driver.findElements(By.xpath(tableXPath+"//tr[1]//td"));
//		int columnCOubnt=listColumnNames.size();
//		return columnCOubnt;
//	}
//	public static int getTableColumnNamesList(String tableXPath, String tableElementName) {
//		
//		List<WebElement> listColumnNames=driver.findElements(By.xpath(tableXPath+"//tr[1]//td"));
//		int columnCOubnt=listColumnNames.size();
//		return columnCOubnt;
//	}
//	
//	public static int getTableDataCount(String xpathValue , String elementName) {
//		List<WebElement> listOfData = myFindElements(xpathValue, elementName);
//		int dataCount = listOfData.size();
//		return dataCount;
//	}
//	 
//	public static List<String> getColumNameInList(String tableXpathValue , String elementName) {
//		
//		List<WebElement> listOfWeb = myFindElements(tableXpathValue+"//tr[1]//td", elementName);
//		List<String> listobj = new ArrayList<String>();
//	
//		for (int i = 0; i < listOfWeb.size(); i++) {
//		singleWeb = listOfWeb.get(i);
//			String elementText = singleWeb.getText();
//			if (elementText!="") {
//				listobj.add(elementText);
//			}
//		}
//		
//		System.out.println(listobj);
//		
//		for (int i = 0; i < listobj.size(); i++) {
//			String columName = listobj.get(i);
//			System.out.println("Colum Name is =>"+columName);
//		}
//		return listobj;
//	}
//	
//	public static void getColumNumberByColumName(String tableXpathValue , String elementName , String expectElementText) {
//		List<String> listobj = getColumNameInList(tableXpathValue, elementName);
//		for (int i = 0; i < listobj.size(); i++) {
//			String actualElementText = listobj.get(i);
//			if (actualElementText.equalsIgnoreCase(expectElementText)) {
//				i++;
//				System.out.println(expectElementText +" Colum Number is =>"+i);
//
//			}
//
//		}
//		
//	}
	
//	public static int getColumNumberByColumName2(String tableXpathValue , String elementName , String expectElementText) {
//
//		List<WebElement> listOfWeb = myFindElements(tableXpathValue+"//tr[1]//td", elementName);
//		int columNumber = -1;
//	
//		for (int i = 0; i < listOfWeb.size(); i++) {
//		singleWeb = listOfWeb.get(i);
//			String elementText = singleWeb.getText();
//			if (elementText.equalsIgnoreCase(expectElementText)) {
//				columNumber = i+1;
//			}
//		}
//		return columNumber;
//	}
//	
//	public static List<String> getRowDataListByRowNumber(String tableXpathValue , String elementName , int rowValue) {
//		List<WebElement> listOfWeb = myFindElements("("+tableXpathValue+"//tr"+")"+"["+rowValue+"]"+"//td", elementName);
//		List<String> listobj = new ArrayList<String>();
//		for (int i = 0; i < listOfWeb.size(); i++) {
//		singleWeb = listOfWeb.get(i);
//			String elementText = singleWeb.getText();
//			if (elementText!="") {
//				listobj.add(elementText);
//			}
//			
//
//		}
//		System.out.println(listobj);
//		for (int i = 0; i < listobj.size(); i++) {
//			String rowData = listobj.get(i);
//			System.out.println("Colum Name is =>"+rowData);
//		}
//	
//		return listobj;
//	}
//	
//	public static List<String> getColumDataListByColumNumber(String tableXpathValue , String elementName ,int columNumber ) {
//		List<WebElement> listOfWeb = myFindElements(tableXpathValue+"//tr//td["+columNumber+"]", elementName);
//		List<String> listobj = new ArrayList<String>();
//		for (int i = 0; i < listOfWeb.size(); i++) {
//		singleWeb = listOfWeb.get(i);
//			String elementText = singleWeb.getText();
//			if (elementText!="") {
//				listobj.add(elementText);
//			}
//			

	//	}
//		System.out.println(listobj);
//		for (int i = 0; i < listobj.size(); i++) {
//			String rowData = listobj.get(i);
//			System.out.println("Colum Name is =>"+rowData);
//		}
//	
//		return listobj;
//	}
	
	
//	public static List<String> getColumDataListByColumName(String tableXpathValue , String elementName ,String columName ) {
//	int columNumber =	getColumNumberByColumName2(tableXpathValue, elementName, columName);
//	List<String> columText = getColumDataListByColumNumber(tableXpathValue, elementName, columNumber);
//	return columText;
//	}
	
//	public static int getRowNumberByAccountId(String idXpathValue , String elementName , String accountNo , String ColumnName) {
//		int rowNumber=-1;
//		List<String> listCOlumnData=getColumDataListByColumName(idXpathValue, elementName, ColumnName);
//        for(int i=0; i<=listCOlumnData.size()-1;i++) {
//        	String columnValue=listCOlumnData.get(i);
//        	if(columnValue.equalsIgnoreCase(accountNo)) {
//        		rowNumber=i;
//        		break;
//        	}
//        	System.out.println("Row Number is => "+rowNumber);
//        }
//          return rowNumber;
//
//	}
	
}
