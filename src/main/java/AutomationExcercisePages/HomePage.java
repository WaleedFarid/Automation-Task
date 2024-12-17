package AutomationExcercisePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilites.DriverFactory;

public class HomePage {
    private WebDriver driver ;

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //------------Locators------------\\
    private By imageVisible = By.xpath("//img[@src='/static/images/home/logo.png']");

    //-------------Methods------------\\
    @Step("Navigate to Website Home page")
    public HomePage navigateToUrl() {
        DriverFactory.initiateDriver("Chrome", true , "headless");
        return this;
    }

    //-------------Validations-----------\\
    @Step("validate that user is in home page")
    public HomePage assertUserInHomePage() {
        Assert.assertTrue(driver.findElement(imageVisible).isDisplayed(), "Image not appeared");
       // Assert.assertEquals(driver.getCurrentUrl() , "https://automationexercise.com/");
        System.out.println("User is in Home Page");
    return this;
    }
}
