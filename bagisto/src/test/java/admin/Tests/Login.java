package admin.Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import common.BaseTest;
import admin.pageObjects.LoginPageObject;

public class Login extends BaseTest {
	
	@Test(groups={"Login.adminLogin"})
	public void adminLogin() throws IOException {
		getGlobalProperty();
		String email = prop.getProperty("AdminEmail");
		String password = prop.getProperty("AdminPassWord");
		LoginPageObject LoginPageObject = launcDashboard();
		LoginPageObject.Login(email,password);
	}
}
