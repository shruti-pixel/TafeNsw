package stepDefinitions;

import testBase.TestBase;
import org.junit.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class LoginStepDefs extends TestBase {

	@Given("I am on the TAFE NSW home page {string}")
	public void i_am_on_the_TAFE_NSW_home_page(String pageURL) throws Exception {
		setUp();
		driver.get(pageURL); // Navigate to the TAFE NSW home page
	}

	@When("I search for a course {string}")
	public void i_search_for_a_course(String course) {
		homePage.enterCourseName(course); // Enter the course name in the search box
	}

	@And("I click on the search button")
	public void i_click_on_the_search_button() {
		homePage.clickSearchButton(); // Click the search button and navigate to the search results page
	}

	@Then("I should see the course {string} in the search results")
	public void i_should_see_the_course_in_the_search_results(String course) {
		Assert.assertEquals(course, coursePage.Course(course));//validate course applied successfully
	}

	@When("I apply the delivery filter {string}")
	public void i_apply_the_delivery_filter(String filter) {
		coursePage.filterApplied(filter); // Apply the specified delivery filter
	}

	@Then("I should see the delivery filter {string} applied to the course")
	public void i_should_see_the_delivery_filter_applied_to_the_course(String filter) {
		Assert.assertEquals(filter, coursePage.validateCourse(filter)); // Validate on Campus applied successfully
	}

	@After
	public void tearDown() {
		driver.quit(); // Quit the WebDriver after the scenario finishes
	}

}
