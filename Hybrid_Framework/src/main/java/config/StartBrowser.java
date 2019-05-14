package config;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class StartBrowser {
	
  public static WebDriver driver;
  ExtentHtmlReporter htmlReporter;
  public static ExtentReports extent;
  public static ExtentTest parentTest;
  public static ExtentTest childTest;
  
  //This is New Commit
  @BeforeTest  
  public void beforeTest()
  {
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/MyReport.html");
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
  }
  
  @BeforeMethod
  public void beforeMethod(Method method)
  {
	  
	  parentTest = extent.createTest(method.getName());
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  
	  ChromeOptions chromeOptions= new ChromeOptions();
	  chromeOptions.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\ais\\.m2\\repository\\webdriver\\chromedriver\\win32\\75.0.3770.8\\chromedriver.exe");
	  driver = new ChromeDriver(chromeOptions);
	  //WebDriverManager.chromedriver().setup();
	  //System.out.println(WebDriverManager.chromedriver().getBinaryPath());
	  //driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
	 extent.flush();
  }
}
