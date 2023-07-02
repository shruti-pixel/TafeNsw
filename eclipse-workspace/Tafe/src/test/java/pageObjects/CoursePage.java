package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursePage {
	
    public WebDriver driver;
    public static String onCampus; 
    
    @FindBy(xpath = "//h3[contains(text(),'Delivery')]")
    WebElement deliveryFilter ;
    
    @FindBy(xpath = "//label[contains(text(),'On campus')]")
    WebElement onCampusElement ;
 
    @FindBy(xpath = "span[contains(text(),'On campus')]")
    WebElement onCampusValidate ;
    
    
    @FindBy(xpath = "//h4[contains(text(),'Advanced Barista Skills')]")
    WebElement searchResult ;
    
	
	public CoursePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //initialization of driver
    }

    
	public void isDeliveryFilterApplied(String deliveryOption) {
    	 deliveryFilter.click();//click on delivery
       	 onCampusElement.click();
    	 onCampus = onCampusElement.getText();// get on campus text
    	
	}
     
     public boolean isCourseDisplayed(String courseName) {
         
         return searchResult.isDisplayed();
     }

 
 }

     
     
     






