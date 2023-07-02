package stepDefinitions;


import pageObjects.CoursePage;
import pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;


public class TafeStepDefinitions {
    public WebDriver driver;
    public HomePage homePage;
    public CoursePage coursePage;
    public SoftAssert soft;

    @Given("I am on the TAFE NSW home page {string}")
    public void i_am_on_the_TAFE_NSW_home_page(String url) throws Exception {
    	
    	// Set ChromeDriver path
       System.setProperty("webdriver.chrome.driver","C://Users//Me//eclipse-workspace//infy//Driver1//chromedriver.exe");
       // Initialize ChromeDriver
        driver = new ChromeDriver();
        //webpage maximize
        driver.manage().window().maximize();
        //wait applied driver
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Navigate to the TAFE NSW home page
        driver.get(url);
        
      // Initialize the HomePage, CoursePage, SearchResultsPage
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);
}
  
    @When("I search for a course {string}")
    public void i_search_for_a_course(String courseName) {
    	 homePage.enterCourseName(courseName); // Enter the course name in the search box
    }

    @And("I click on the search button")
    public void i_click_on_the_search_button() {
          homePage.clickSearchButton(); // Click the search button and navigate to the search results page
    }

    @Then("I should see the course {string} in the search results")
    public void i_should_see_the_course_in_the_search_results(String courseName) {
    	 soft = new SoftAssert(); // Check if the specified course is displayed in the search results
    	 soft.assertTrue(coursePage.isCourseDisplayed(courseName), "course name selcted is \"Advanced Barista Skills\"");
    }
    
    @When("I apply the delivery filter {string}")
    public void i_apply_the_delivery_filter(String deliveryOption) {
    	coursePage.isDeliveryFilterApplied(deliveryOption); // Apply the specified delivery filter
    }

    @Then("I should see the delivery filter {string} applied to the course")
    public void i_should_see_the_delivery_filter_applied_to_the_course(String deliveryOption) {
    	soft.assertEquals(coursePage.onCampus, deliveryOption);
    }
    
    @After
    public void tearDown() {
        driver.quit(); // Quit the WebDriver after the scenario finishes
    }
}
       