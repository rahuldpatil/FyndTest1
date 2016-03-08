package common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mainPackage.Fynd_CC_Main;

public class AllControls extends Fynd_CC_Main {
	
	public void TextBox_EnterData(WebDriver driver, WebElement element, String data)
	{
		driverwait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(data);
		actions.build().perform();
	}
	
	public void Button_Click(WebDriver driver, WebElement element)
	{
		driverwait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
	}
	
	public void File_upload_window(WebDriver driver,WebElement element, String filepath)
	{ try{
		driverwait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.build().perform();
		Thread.sleep(2000);
		StringSelection stringSelection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		//native key strokes for CTRL, V and ENTER keys
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		//Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
		catch(Exception e)
	{
			
	}
		
	}
	public static void focus_out()
	{
		try{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		}catch (Exception e){}
		
	}
	

}
