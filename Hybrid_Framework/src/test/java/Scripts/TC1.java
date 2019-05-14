package Scripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import reuseFunctions.BusinessFunctions;

public class TC1 extends StartBrowser {
  @Test
  public void testLogin() throws Exception 
  {
	  BusinessFunctions fs = new BusinessFunctions();
	  fs.gotoApplication();
	  fs.login();
	  if(fs.getTextFromApp("Add Membership Number"))
	  {
		  StartBrowser.childTest.pass("verification successfull");
		  
	  }
	  else
	  {
		  StartBrowser.childTest.fail("verification not successfull");
	  }
  }
}
