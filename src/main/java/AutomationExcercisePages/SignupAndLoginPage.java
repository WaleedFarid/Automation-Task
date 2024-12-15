package AutomationExcercisePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupAndLoginPage {
    private WebDriver driver ;

    //--------------Constructor-----------\\
    public SignupAndLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //-----------Locators---------\\
    private By signupIsVisible = By.cssSelector("div.signup-form h2");
    private By nameOfSignup = By.name("name");
    private By emailOfSignup = By.xpath("//input[@data-qa='signup-email']");
    private By signupClickButton = By.xpath("//button[@data-qa='signup-button']");

    //----------Methods----------\\
    @Step("filling the required data to signup")
    public SignupAndLoginPage enterNameAndEmailInSignUpPage(String name, String email) {
        driver.findElement(nameOfSignup).sendKeys(name);
        driver.findElement(emailOfSignup).sendKeys(email);
        driver.findElement(signupClickButton).click();
        System.out.println("User signup successfully");
    return this;
    }

    //-----------Validations----------\\
    @Step("validate that user in signup page")
    public SignupAndLoginPage assertUserInSignupPage() {
        Assert.assertTrue(driver.findElement(signupIsVisible).isDisplayed(), "New User Signup!");
    return this;
    }
}
