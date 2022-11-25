package admin.Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import admin.TestComponents.BaseTest;
import admin.pageObjects.LoginPageObject;

public class Login extends BaseTest {
	
	@Test
	public void adminLogin() throws IOException {
		LoginPageObject LoginPageObject = launcDashboard();
		LoginPageObject.Login();
	}
}
