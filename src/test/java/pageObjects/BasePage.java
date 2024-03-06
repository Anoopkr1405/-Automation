package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;
    
    // Constructor to initialize the BasePage with WebDriver instance
    public BasePage(WebDriver driver) {
        this.driver = driver;
        
        // Initialize the elements in the page using PageFactory
        PageFactory.initElements(driver, this);
        // The above line initializes the elements in the page object class, using the provided WebDriver instance and the current page object instance.
        // This allows you to use the @FindBy annotation to locate and initialize elements on the page without explicitly calling the findElement method.
        // It helps in making the code more readable and maintainable by reducing the boilerplate code for element initialization.
        // By using PageFactory, you can directly access the elements defined in the page object class.
    }
}
