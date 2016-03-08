package common;

import java.util.HashMap;

public class AllLocators {
	
	public static HashMap SideBarLocators = new HashMap();
	public static HashMap AddCompanyLocators = new HashMap();
	public static HashMap ViewCompanyLocators = new HashMap();
	public static HashMap SortCompanyLocators = new HashMap();
		
	public static void Initiate_SidebarLocators()
	{
		SideBarLocators.put("Company Info", "div.menu-tab.level-one:nth-child(1) div.menu-cell.level-one");
		SideBarLocators.put("Content", "div.menu-tab.level-one:nth-child(2)");
	}
	
	
	public static void Initiate_CompanyInfoLocators()
	{
		//Add Company Page 1
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Short Name", "input[name='Company Short Name']");
		AddCompanyLocators.put("Company Type Control", "div.form-two-col:nth-child(2) span.select2-chosen.ng-binding");
		AddCompanyLocators.put("Company Type Retail", "li[id^='ui-select-choices-row-']:nth-child(1)");
		AddCompanyLocators.put("Company Type Franchise", "li[id^='ui-select-choices-row-']:nth-child(2)");
		AddCompanyLocators.put("Address", "input[name='Address']");
		AddCompanyLocators.put("City", "input[name='City']");
		AddCompanyLocators.put("Pin Code", "input[name='Pincode']");
		AddCompanyLocators.put("Phone", "input[name='Phone']");
		AddCompanyLocators.put("Registered Address", "input[name='Registered Address']");
		AddCompanyLocators.put("Registered City", "input[name='Registered City']");
		AddCompanyLocators.put("Registered Pincode", "input[name='Registered Pincode']");
		AddCompanyLocators.put("Payment Method Control", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Payment Method Happay", "li[id^='ui-select-choices-row-']:nth-child(1)");
		AddCompanyLocators.put("Payment Method Later", "li[id^='ui-select-choices-row-']:nth-child(2)");
		
		//Add Company Page 2
		AddCompanyLocators.put("Contact Person", "input[name='Contact Person']");
		AddCompanyLocators.put("Contact Email", "[name='Contact Email']");
		AddCompanyLocators.put("Account Password", "input[name='Account Password']");
		
		//Add Company Page 3
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		AddCompanyLocators.put("Company Legal Name", "input[name='Company Legal Name']");
		
		
	}
	

}
