package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//input[@id='headerSearch']")
	WebElement searchBox ;

	@FindBy(xpath = "//*[@for='headerSearch']")
	WebElement  searchButton ;

	@FindBy(xpath = "//h4[contains(text(),'Advanced Barista Skills')]")
	WebElement searchResult ;

	public HomePage() {
		PageFactory.initElements(driver, this); //webElement initialization
	}

	public void enterCourseName(String course) {
		Actions advSearch = new Actions(driver);// Actions class used to perform click operation on search 
		advSearch.moveToElement(searchBox).click().perform();
		searchBox.clear();
		searchBox.sendKeys(course);//send the course name 
	}

	public CoursePage clickSearchButton() {
		searchBox.sendKeys(Keys.RETURN); //Enter button for course search
		return new CoursePage();
	}
}

