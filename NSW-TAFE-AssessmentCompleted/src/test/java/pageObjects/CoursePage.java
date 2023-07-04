package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;



public class CoursePage extends TestBase{

	@FindBy(xpath = "//h3[contains(text(),'Delivery')]")
	WebElement deliveryFilter ;

	@FindBy(xpath = "//label[contains(text(),'On campus')]")
	WebElement onCampusElement ;

	@FindBy(xpath = "//span[contains(text(),'On campus')]")
	WebElement onCampusValidate ;


	@FindBy(xpath = "//h4[contains(text(),'Advanced Barista Skills')]")
	WebElement searchResult ;

	public CoursePage() {
		PageFactory.initElements(driver, this); //webElement initialization
	}

	public void filterApplied(String filter) {
		deliveryFilter.click();//click on delivery
		onCampusElement.click(); // click on campus
	}

	public String validateCourse(String courseText ){   
		courseText = onCampusValidate.getText(); //get on campus
		return courseText; // return on campus
	}

	public String Course(String course ){   
		course = searchResult.getText(); // get on campus from delivery filter applied
		return course; // return on campus 
	}
}










