package AutomationExcercisePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountDeletedPage {
  private WebDriver driver ;


  //---------Constructor---------\\
    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    //---------Locators---------\\
    private By accountDeletedVisible = By.xpath("//b[contains(text(),'Account Deleted!')]");

    //---------Validations--------\\
  @Step("validate that account deleted message is appeared")
    public AccountDeletedPage assertAccountDeletedMessageIsVisible() {
        Assert.assertTrue(driver.findElement(accountDeletedVisible).isDisplayed(), "Message is not appeared");
    return this;
    }
}
