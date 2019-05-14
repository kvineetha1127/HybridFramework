package reuseFunctions;



import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.MyAccountPage;
import config.StartBrowser;
import wdcmnds.ActionDriver;

public class BusinessFunctions extends ActionDriver {
	ActionDriver adriver;
	public BusinessFunctions()
	{
		adriver = new ActionDriver();
	}
	/**
	 * Navigate to the application
	 * @throws Exception 
	 */
	public void gotoApplication() throws Exception
	{
		StartBrowser.childTest=StartBrowser.parentTest.createNode("Navigate to Cosco");
		adriver.navigateToApplication("https://www.costco.com");
	}
	
	public void login() throws Exception
	{
		StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to Cosco");
		adriver.click(HomePage.lnkSignIn, "Link Sign In");
		adriver.setText(LoginPage.edtEmail, "kvineetha1127@gmail.com", "Email");
		adriver.setText(LoginPage.edtPwd, "selenium123", "password");
		adriver.click(LoginPage.btnSignIn, "Button Sign In");
	}
	
	public boolean getTextFromApp(String testdata) throws Exception
	{
		StartBrowser.childTest=StartBrowser.parentTest.createNode("get the text value");
		String actual = adriver.getText(MyAccountPage.pageHeader);
		if(actual.equalsIgnoreCase(testdata))
		{
			System.out.println("Both values are matching");
			return true;
		}
		else
		{
			System.out.println("Both values are not matching");
			return false;
		}
	}

}
