package javascriptpack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javautilities {
	public static void Jsclick(WebDriver driver,WebElement element) {
		JavascriptExecutor jsexecutor= (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].click()", element);		
	}
	
	//calender Selection
	public static void selectdatebyjs(WebDriver driver,WebElement element,String datevalue) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].setAttribute('value','" + datevalue+ "')", element);	
	}
	
	//scrollDown upto the element
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	
	//scroll bottom at the page
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	//flashing Concept
	//color change method
	public static void changeColor(String color,WebElement element,WebDriver driver) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//flashing method :
	public static void flash(WebElement element,WebDriver driver) {
		String bgcolor= element.getCssValue("backgroundColor");
		
		for(int i=0;i<50;i++) {
			changeColor("#FF0000", element, driver);//1
			changeColor(bgcolor, element, driver);
		}
		
		
	}
	
	//draw a border 
	public static void drawBordergreen(WebDriver driver,WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].style.border='6px solid green'", element);
	}
	
	public static void drawBorderred(WebDriver driver,WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].style.border='6px solid red'", element);
	}
	public static void drawBorderblue(WebDriver driver,WebElement element) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("arguments[0].style.border='6px solid blue'", element);
	}
	
	
	
	//draw alert 
	public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
		jsexecutor.executeScript("alert('" +message+ "')");
	}

}
