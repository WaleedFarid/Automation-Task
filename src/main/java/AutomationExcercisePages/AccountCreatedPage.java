package AutomationExcercisePages;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountCreatedPage {
    private WebDriver driver ;

    //---------Constructor---------\\
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    //--------Locators--------\\
    private By accountCreatedVisible = By.xpath("//h2[@data-qa='account-created']");
    private By countinueButton = By.xpath("//a[@data-qa='continue-button']");

    //----------Methods--------\\
    @Step("click continue button after account creation")
    public AccountCreatedPage clickContinueButtonAfterAccountCreation() {
        driver.findElement(countinueButton).click();
        System.out.println("Account is Created Successfully");
        return this;
    }

    //--------Validations--------\\
    @Step("validate that account creation message is appeared")
    public AccountCreatedPage assertAccountCreatedMessageIsVisible() {
        Assert.assertEquals(driver.findElement(accountCreatedVisible).getText(), "ACCOUNT CREATED!", "Message Is Not Displayed");
        return this;
    }
}
