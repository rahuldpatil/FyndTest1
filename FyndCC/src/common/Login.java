package common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mainPackage.Fynd_CC_Main;

public class Login extends Fynd_CC_Main {
	
	public static void do_login(String username, String password)
	{
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.login-input:nth-child(1)")));
		AllControls control=new AllControls();
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("div.login-input:nth-child(1)")),username);
		control.TextBox_EnterData(thisdriver,thisdriver.findElement(By.cssSelector("div.login-input:nth-child(2)")),password);
		control.Button_Click(thisdriver,thisdriver.findElement(By.cssSelector("button.btn.btn-wide")));
		
	}

}
