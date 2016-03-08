package common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mainPackage.Fynd_CC_Main;

public class SwicthModule extends Fynd_CC_Main {
	
	public static void Switch_Mod(String module)
	{
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dd-trigger div.user-info span.ng-binding")));
		switch(module)
		{
		case "Company Info":
			control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.menu-tab.level-one:nth-child(1) div.menu-cell.level-one")));
			WriteLog("Switched to Company Info Module");
			break;
		case "Content":
			control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.menu-tab.level-one:nth-child(2)")));
			WriteLog("Switched to Content Module");
			break;
			
		default:
			break;
				
		}
	}
	
	public static void switch_tab(String tab)
	{
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one:nth-child(1)")));
		switch(tab)
		{
		case "View Companies":
			control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one.ng-scope:nth-child(1) div.level-one.menu-list div.menu-tab.ng-scope:nth-child(1)")));
			WriteLog("Switched to View Companies tab");
			break;
		case "Add New Company":
			control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("div.main-container div.menu-panel.navigation-menu.ng-isolate-scope div.menu-container div.menu-tab.level-one.ng-scope:nth-child(1) div.level-one.menu-list div.menu-tab.ng-scope:nth-child(2)")));
			WriteLog("Switched to Add New Company tab");
			break;
			
		default:
			break;
				
		}
	}
	

}
