package mainPackage;
import common.AllControls;
import common.ExecuteTests;
import common.Login;
import common.SwicthModule;
import common.Web_Driver;
import company.Add_Company;
import company.View_Company;


public class Fynd_CC_Main extends Web_Driver  {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul Patil\\Downloads\\chromedriver_win32\\chromedriver.exe");
		GenerateLogs();
		WriteLog("Test Suite Start");
		initiate_WebDriver();
		Login.do_login("obscuro", "reset123$");				
		ExecuteTests.ExecuteAllTests();
		WriteLog("Test Suite End");
		Close_logs();
		
	}
}
