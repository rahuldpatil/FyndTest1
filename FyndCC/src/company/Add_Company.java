package company;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.AllControls;
import common.RandomData;
import common.Web_Driver;
import mainPackage.Fynd_CC_Main;

public class Add_Company extends Fynd_CC_Main {
	
	
	public static HashMap CompanyDetailsLocators = new HashMap();
	public static String randstring = RandomData.RandomString();
	public static String CompanyName;
	public static String CompanyShortName;
	public static String Companyaddress;
	public static String CompanyCity;
	public static String Companyeamil;
	
	
	/*public static void swicth_company()
	{
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one:nth-child(1)")));		
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one:nth-child(1)")));
	}*/
	
	/*public static void Open_AddCompany()
	{
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try{
		CompanyDetailsLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one:nth-child(1)")));		
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one.ng-scope:nth-child(1) div.level-one.menu-list div.menu-tab.ng-scope:nth-child(2)")));
		WriteLog("Add Company page opened");
		}
		catch(Exception e)
		{
			WriteLog(e.toString());
		}
	}*/
	
	public static void companydata()
	{	
		CompanyName= "Long"+randstring;
		CompanyShortName=randstring;
		Companyaddress = "Address "+randstring;
		Companyeamil=randstring+"@"+randstring+".com";
		
	}
	public static String Add_data_and_Save() throws Exception
	{
		companydata();
		Company_details_Page_fill();
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("button.btn.btn-wide[ng-click='nextStep()']")));
		Company_Contact_Page_fill();
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("button.btn.btn-wide[ng-click='nextStep()']")));
		Company_Documentation_Page_fill();
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("button.btn.btn-wide[ng-click='addThisCompany(brandObj.addCompanyPageObj);']")));
		WriteLog("Company: "+ CompanyName +" Saved successfully");
		return CompanyName;
	}
	
	public static void Company_details_Page_fill() throws Exception
	{
		
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Company Legal Name']")),CompanyName);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Company Short Name']")),CompanyShortName);
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.form-two-col:nth-child(2) span.select2-chosen.ng-binding")));
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("li[id^='ui-select-choices-row-']:nth-child(1)")));
		//thisdriver.findElement(By.cssSelector("li[id^='ui-select-choices-row-']:nth-child(1)")).sendKeys(Keys.ENTER);
		//thisdriver.findElement(By.cssSelector("li[id^='ui-select-choices-row-']:nth-child(1)")).click();
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Address']")),Companyaddress);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='City']")),randstring);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Pincode']")),"400072");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Phone']")),"1234567890");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Registered Address']")),randstring);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Registered City']")),randstring);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Registered Pincode']")),"400072");
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.form-two-col:nth-child(4) span.select2-chosen.ng-binding")));
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("li[id^='ui-select-choices-row-']:nth-child(1)")));
		WriteLog("Company Details Page 1 filled");
	}
	
	public static void Page_fill_Text(Map<String, Object> locatorandData) throws Exception
	{
		for(String key: locatorandData.keySet())
		{
			control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector(key)),(String)locatorandData.get(key).toString());
			control.focus_out();
		}
	}
	
	public static boolean element_visibility(String locator)
	{try
	{
		return thisdriver.findElement(By.cssSelector(locator)).isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
	}
	
	public static boolean Page_Field_level_Validations(String locator, String Data)
	{
		String strdata = thisdriver.findElement(By.cssSelector(locator)).getText();
		if(strdata.trim().compareTo(Data)==0)
		{
			return true;
		}
		else{
			return false;
		}
		//return strdata;
	}
	
	public static void Company_Contact_Page_fill()
	{
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Contact Person']")),"Test");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("[name='Contact Email']")),Companyeamil);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Account Password']")),Companyeamil);
		WriteLog("Company Contact Page 2 filled");
	}
	
	public static void Company_Documentation_Page_fill()
	{
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='PAN No.']")),"Test");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='TAN No.']")),"Test");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='VAT No.']")),"Test");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='CST No.']")),"Test");
		
		
		control.File_upload_window(thisdriver,thisdriver.findElement(By.cssSelector("div[label=\"'PAN scan:'\"] div[ng-style=\"imgStyler\"]")),"D:\\Fynd.png");
		control.File_upload_window(thisdriver,thisdriver.findElement(By.cssSelector("div[label=\"'TAN scan:'\"] div[ng-style=\"imgStyler\"]")),"D:\\Fynd.png");
		control.File_upload_window(thisdriver,thisdriver.findElement(By.cssSelector("div[label=\"'VAT scan:'\"] div[ng-style=\"imgStyler\"]")),"D:\\Fynd.png");
		control.File_upload_window(thisdriver,thisdriver.findElement(By.cssSelector("div[label=\"'CST scan:'\"] div[ng-style=\"imgStyler\"]")),"D:\\Fynd.png");
		WriteLog("Company Documentation Page 3 filled");
	}
	
	public static void add_brand_from_list()
	{
		thisdriver.findElement(By.cssSelector("div.company-item.ng-scope:nth-child("+View_Company.row+") div.company-item-info div.company-info-styles:nth-child(4)")).click();
		thisdriver.findElement(By.cssSelector("button[ng-click='brandObj.addBrandPageObj={};addBrandModal();']")).click();
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='Brand Name']")));		
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Brand Name']")),"Test");
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Alternate Name']")),"Test");
		control.File_upload_window(thisdriver,thisdriver.findElement(By.cssSelector("div[img-base-src='mainObj.addBrandPageObj.logo'] div.img-container")),"D:\\Logo1.jpg");
		control.File_upload_window(thisdriver,thisdriver.findElement(By.cssSelector("div[img-base-src='mainObj.addBrandPageObj.banner'] div.img-container")),"D:\\Banner1.jpg");
		thisdriver.findElement(By.cssSelector("button[ng-click='addThisBrand(mainObj.addBrandPageObj);']")).click();
			if(dynamicwaitVisible("html body.fynd-cc div#toast-container.ng-scope div.toast",45))
			{
				WriteLog("Company: Brand Added");
			}
			else{
			WriteLog("Company: Some problem in adding brand");
			
			return;}
		
	}
}
