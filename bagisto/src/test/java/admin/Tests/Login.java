package admin.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import common.BaseTest;
import admin.pageObjects.LoginPageObject;

public class Login extends BaseTest {

	@Test(groups = { "Login.adminLogin" })
	public void adminLogin() throws IOException {
		getGlobalProperty();
		String email = prop.getProperty("AdminEmail");
		String password = prop.getProperty("AdminPassWord");
		//String emaill =getExceldata("adminLogin", "Email");
		 getExceldata("adminLogin", "Pass");
		//System.out.println(emaill+" "+pass);
		//LoginPageObject LoginPageObject = launcDashboard();
		//LoginPageObject.Login(email, password);
	}
}
