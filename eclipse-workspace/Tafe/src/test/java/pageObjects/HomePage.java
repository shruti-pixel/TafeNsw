package pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    
   
  
   @FindBy(xpath = "//input[@id='headerSearch']")
   WebElement searchBox ;
   
    @FindBy(xpath = "//*[@for='headerSearch']")
    WebElement  searchButton ;
    
   @FindBy(xpath = "//h4[contains(text(),'Advanced Barista Skills')]")
   WebElement searchResult ;
   
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //driver initialization
    }

    public void enterCourseName(String courseName) {
    	Actions advSearch = new Actions(driver);// Actions class used to perform click operation
    	advSearch.moveToElement(searchBox).click().perform();
        searchBox.clear();
        searchBox.sendKeys(courseName);
    }

    public CoursePage clickSearchButton() {
    	searchBox.sendKeys(Keys.RETURN); //Enter button
        return new CoursePage(driver);
    }
}

