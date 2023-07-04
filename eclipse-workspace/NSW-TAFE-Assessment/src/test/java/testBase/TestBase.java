package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CoursePage;
import pageObjects.HomePage;

public class TestBase {
	public static WebDriver driver;
	public static HomePage homePage;
	public static CoursePage coursePage;

	public static void setUp(){
		// Set ChromeDriver path
		System.setProperty("webdriver.chrome.driver","C://Users//Me//eclipse-workspace//NSW-TAFE-Assessment//Driver1//chromedriver.exe");

		driver = new ChromeDriver();// Initialize ChromeDriver

		driver.manage().window().maximize();//web page maximize

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//wait applied on driver

		// Initialize the HomePage, CoursePage
		homePage = new HomePage();
		coursePage = new CoursePage();
	}
}
