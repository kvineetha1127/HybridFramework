package ObjectRepository;

import org.openqa.selenium.By;

public class LoginPage 
{
	public static By edtEmail = By.id("logonId");
	public static By edtPwd = By.xpath("//input[@name='logonPassword']");
	public static By btnSignIn = By.xpath("//input[@value='Sign In']");
}
