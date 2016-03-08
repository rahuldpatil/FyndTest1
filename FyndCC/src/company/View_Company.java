package company;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import mainPackage.Fynd_CC_Main;
import common.AllControls;

public class View_Company extends Fynd_CC_Main {
	
	static WebElement element;
	static int row;
	static int col;
	
	public static void Search_Company(String CompanyName)
	{
		try {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.ti-arrow-circle-left")));
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("input[name='Search By Company/Brand']")),CompanyName);
		Thread.sleep(2000);
		WriteLog("Company name:"+CompanyName+" entered into search box");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Search By Company/Brand
	}
	public static void Compare_Company(String CompanyName)
	{
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.ti-arrow-circle-left")));
		List <WebElement> elements = thisdriver.findElements(By.cssSelector("div.company-item.ng-scope"));
		for (WebElement outerele : elements)
		{
			List<WebElement> inerele = outerele.findElements(By.cssSelector("div.company-item-info div.company-info-styles"));
			for (WebElement childele: inerele)
			{
				
				System.out.println(childele.getText());
				if(childele.getText().trim().compareTo(CompanyName.trim())==0)
				{
					row=elements.indexOf(outerele)+1;
					col=inerele.indexOf(childele)+1;
					WriteLog("Record Found :"+CompanyName+" Found in Row "+row+" and Column "+col);
										
				}
			}
		}
	}
	

}
