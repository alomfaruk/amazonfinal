package amazonpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javascriptpack.javautilities;

public class homepage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Account & Lists']")WebElement accountlist;
	@FindBy(xpath="//div[@id='nav-flyout-ya-newCust']/child::a")WebElement starthere;
	@FindBy(xpath="//input[@id='ap_customer_name']")WebElement name;
	@FindBy(xpath="//input[@id='ap_email']")WebElement email;
	@FindBy(xpath="//input[@id='ap_password']")WebElement password;
	@FindBy(xpath="//input[@id='ap_password_check']")WebElement repassword;
	@FindBy(xpath="//input[@id='continue']")WebElement continues;
	
	public void continueclick() {
		continues.click();
	}
	
	public void repasswordfield(String Repassword) throws InterruptedException {
		repassword.click();
		Thread.sleep(1000);
		repassword.clear();
		Thread.sleep(1000);
		repassword.sendKeys(Repassword);
	}
	
	public void passwordfield(String Password) throws InterruptedException {
		password.clear();
		Thread.sleep(1000);
		password.click();
		Thread.sleep(1000);
		password.sendKeys(Password);
	}
	
	
	public void emailfield(String Email) throws InterruptedException {
		email.click();
		Thread.sleep(1000);
		email.clear();
		Thread.sleep(1000);
		email.sendKeys(Email);
	}
	
	public void namefield(String Name) throws InterruptedException {
		name.click();
		Thread.sleep(1000);
		name.clear();
		Thread.sleep(1000);
		name.sendKeys(Name);
		}
	
	
	public void starthereclick() throws InterruptedException {
		
		
		javautilities.drawBorderblue(driver, starthere);
		Thread.sleep(1000);
		starthere.click();
	}
	
public void accountlisthoverover() throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(accountlist).build().perform();
	Thread.sleep(1000);
	javautilities.drawBorderblue(driver, accountlist);
}
public homepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}
