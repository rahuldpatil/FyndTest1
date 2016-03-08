package flows;



import java.util.HashMap;

import common.SwicthModule;
import company.Add_Company;
import company.View_Company;

public class CompanyTests extends Add_Company {
	
	static String CompanyName;
	
	public static void Add_new_Company1()
	{   
		try{
		WriteLog("********************************************************************************************");
		WriteLog("Test Name : Add_new_Company1 Started... ");
		SwicthModule.Switch_Mod("Company Info");
		SwicthModule.switch_tab("Add New Company");
		CompanyName = Add_Company.Add_data_and_Save();
		WriteLog("Test Name : Add_new_Company1 End.");
		WriteLog("********************************************************************************************");
		}
		catch(Exception e)
		{
			WriteLog(e.toString());
			WriteLog("Test Name : Add_new_Company1 End. Failed");
			WriteLog("********************************************************************************************");
		}
	}
	
	public static void Add_new_Company_and_Check()
	{	
		try{
		WriteLog("********************************************************************************************");
		WriteLog("Test Name : Add_new_Company_and_Check Started... ");
		SwicthModule.Switch_Mod("Company Info");
		SwicthModule.switch_tab("Add New Company");
		CompanyName = Add_Company.Add_data_and_Save();
		SwicthModule.switch_tab("View Companies");
		View_Company.Search_Company(CompanyName);
		View_Company.Compare_Company(CompanyName);
		WriteLog("Test Name : Add_new_Company_and_Check End.");
		WriteLog("********************************************************************************************");
		}
		catch(Exception e)
		{
			WriteLog(e.toString());
			WriteLog("Test Name : Add_new_Company_and_Check End. Failed");
			WriteLog("********************************************************************************************");
		}
		}
	
	public static void Add_New_Brand_From_Search()
	{
		
	}
	
	public static void Add_Company_Validations1()
	{
		try{
		HashMap locatordata = new HashMap();
		locatordata.put("input[name='Company Legal Name']", "");
		WriteLog("********************************************************************************************");
		WriteLog("Test Name : Add_Company_Validations1 Started... ");
		SwicthModule.Switch_Mod("Company Info");
		SwicthModule.switch_tab("Add New Company");
		Add_Company.Page_fill_Text(locatordata);
		if(Page_Field_level_Validations("div[label='labels.legal_name'] div.error div.ng-scope span","This field is required"))
		{
			WriteLog("Validation messege is matching");
		}
		else
		{
			WriteLog("Validation messege is not matching");
		}
		WriteLog("Test Name : Add_Company_Validations1 End.");
		WriteLog("********************************************************************************************");
		}
		catch(Exception e)
		{
			WriteLog(e.toString());
			WriteLog("Test Name : Add_Company_Validations1 End. FAILED");
			WriteLog("********************************************************************************************");
		}
	}
	
	public static void Company_Management_Basic_Check1()
	{
		WriteLog("********************************************************************************************");
		WriteLog("Test Name : Company_Management_Basic_Check1 Started... ");
		if(element_visibility("div.card-list div.card:nth-child(1)"))
		{
			WriteLog("Add Company Tile available on screen");
		}
		else
		{
			WriteLog("Add Company Tile is not on screen");
		}
		WriteLog("Test Name : Company_Management_Basic_Check1 End.");
		WriteLog("********************************************************************************************");
	}
	
	public static void add_Brand_from_Search()
	{	
		WriteLog("********************************************************************************************");
		WriteLog("Test Name : Add_Brand_from_Search1 Started... ");
		add_brand_from_list();
		WriteLog("Test Name : Add_Brand_from_Search1 End.");
		WriteLog("********************************************************************************************");
	}
	
	}
	
	


