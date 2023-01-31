package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import admin.pageObjects.LoginPageObject;

public class BaseTest {

	private String ADMIN_URL = null;
	private String SHOP_URL = null;
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream files;

	public WebDriver initlizeBrowser() throws IOException {
		getGlobalProperty();
		SHOP_URL = prop.getProperty("SHOP_URL");
		ADMIN_URL = prop.getProperty("ADMIN_URL");
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			// driver.manage().window().setSize(new Dimension(1440,900));
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			// System.getProperty("webdriver.gecko.driver", "user.dir"+ "/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// TODO object of edge class;
		} else {
			System.out.println("I AM ELSE AND BROWSER NAME=" + browserName);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}

	public void launcShop() throws IOException {
		driver = initlizeBrowser();
		goToVelocityShop();
	}

	public void goToVelocityShop() {
		driver.get(SHOP_URL);
		// scrollDown(driver);
	}

	public LoginPageObject launcDashboard() throws IOException {
		driver = initlizeBrowser();
		goToAdminPanel();
		return new LoginPageObject(driver);
	}

	public void goToAdminPanel() {
		driver.get(ADMIN_URL);
		// scrollDown(driver);
	}

	@AfterMethod
	public void closeBrowser() {
		// driver.close();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		// String To HashMap Jackson DataBind Dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshot(String testClassNmae, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File File = new File(System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png");
		FileUtils.copyFile(source, File);
		return System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png";
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void getGlobalProperty() throws IOException {
		prop = new Properties();
		files = new FileInputStream(
		System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlobalData.properties");
		prop.load(files);
	}
	
}
