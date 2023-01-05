package utilitiespack;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class utilities {
 public static WebDriver driver;
  
  @AfterMethod
  public void afterMethod() {
	  
  }

@Parameters({"browser","url"})
@BeforeClass
public void Ibrowsers(String NameOfBrowser,String url) throws InterruptedException {
		
	     String ud=System.getProperty("user.dir");

		if(NameOfBrowser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",ud+"/driver/chromedriver");
			
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.get(url);
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		else if(NameOfBrowser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", ud+"/driver/msedgedriver");
			
			driver= new EdgeDriver();
			driver.manage().window().maximize();
			
			driver.get(url);
			Thread.sleep(40000);
			// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}	

}

  @AfterClass
  public void afterClass() {
	 driver.close();
  }
  
  public void screenshorts(String foldername) {
	  String ud= System.getProperty("user.dir");
	  Date datein=new Date();
	  datein.toString().replace(" ","_").replace(":", "_");
	  File screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileHandler.copy(screen,new File(ud+"/pictures/"+foldername+"/"+datein+"myss.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  public void assertforurl() {
	   String currenturl=driver.getCurrentUrl();
	  String frs="https://www.amazon.com/";
		 // Assert.assertEquals(currenturl,frs);
		 
		 SoftAssert sofob=new SoftAssert();
		 sofob.assertEquals(currenturl, frs);
		 System.out.println("the url is correct");
		 sofob.assertAll();
  }
  public void screenshortrandom() {
	  String ud= System.getProperty("user.dir");
	  Date datein=new Date();
	  datein.toString().replace(" ","_").replace(":", "_");
	  File screen= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		FileHandler.copy(screen,new File(ud+"/screenshorts/random/"+datein+"myss.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }

}
