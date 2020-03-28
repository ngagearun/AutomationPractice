package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;

public class TestBase {

	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver driver;

	public void initialize() throws IOException {

		if (driver == null) {

			CONFIG = new Properties();

			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\Utils\\config.properties");
			CONFIG.load(fi);

			if (CONFIG.getProperty("browser").equalsIgnoreCase("chrome")) {
				// user will need to specify the location of their chrome driver
				// to run this
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\java\\Executables\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (CONFIG.getProperty("browser").equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
		
		
	}

	public void tearDown() {

		driver.close();

	}

}
