package admin.Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import common.BaseTest;
import admin.pageObjects.LoginPageObject;

public class Login extends BaseTest {
	
	@Test(groups={"Login.adminLogin"})
	public void adminLogin() throws IOException {
		LoginPageObject LoginPageObject = launcDashboard();
		LoginPageObject.Login();
	}
}
