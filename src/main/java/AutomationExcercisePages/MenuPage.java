package AutomationExcercisePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MenuPage {
    private WebDriver driver;

    //Constructor
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By loginAndSignupVisible = By.linkText("Signup / Login");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By userLoggedVisible = By.xpath("//a/b");

    //Methods
    @Step("click on sign up button")
    public MenuPage clickOnSignup() {
        driver.findElement(loginAndSignupVisible).click();
        System.out.println("User is in Signup Page");
    return this;
    }

    @Step("click on delete account button")
    public MenuPage clickDeleteAccountButton() {
        driver.findElement(deleteAccountButton).click();
        System.out.println("User Pressed on Delete Account");
    return this;
    }

    //Validations
    @Step("validate that username is visible in menu bar")
    public MenuPage assertLoggedinAsUsernameIsVisible() {
        Assert.assertEquals("Logged in as" + driver.findElement(userLoggedVisible).getText(), "Logged in asWaleed Ahmed", "Username is not visible");
        System.out.println("Username is visible");
    return this;
    }
}
