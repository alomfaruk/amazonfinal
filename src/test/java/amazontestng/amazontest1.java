package amazontestng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.shams.excel.reader.utilities.Xlsx_Reeader_EAL;

import org.testng.annotations.Test;

import amazonpom.homepage;
import utilitiespack.utilities;

public class amazontest1 extends utilities {
  @Test(dataProvider ="amazondata" )
  public void f(String Name,String Email,String Password,String Repassword) throws InterruptedException {
	assertforurl();
	  homepage ob=new homepage(driver);
	  ob.accountlisthoverover();
	  Thread.sleep(1000);
	  ob.starthereclick();
	  Thread.sleep(1000);
	  ob.namefield(Name);
	  Thread.sleep(1000);
	  ob.emailfield(Email);
	  Thread.sleep(1000);
	  ob.passwordfield(Password);
	  Thread.sleep(1000);
	  ob.repasswordfield(Repassword);
	  Thread.sleep(1000);
	  screenshortrandom();
	  Thread.sleep(1000);
	  ob.continueclick();
	  Thread.sleep(4000);
	  driver.navigate().back();
	  Thread.sleep(4000);
	  
	  
  }
  @DataProvider
  public Object[][] amazondata() {
	  String excellsheetpath="/Users/anikhassan/eclipse-workspace/Amazonfinal/Testdata/Testdata3.xlsx";
	  Xlsx_Reeader_EAL reader=new Xlsx_Reeader_EAL(excellsheetpath);
	  Object[][] data= reader.getSheetData("amazon");
	  return data;
	  
  }
  
}
