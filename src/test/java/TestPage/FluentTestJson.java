package TestPage;
import AutomationExcercisePages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilites.JsonFileManager;

public class FluentTestJson {
    private WebDriver driver;
    private JsonFileManager jsonFileManager;

    @BeforeClass
    public void openTheBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        jsonFileManager = new JsonFileManager("src/test/resources/data.json");

    }

    @Test
    public void registrationTestCase() {
        new HomePage(driver).navigateToUrl()
                .assertUserInHomePage();
        new MenuPage(driver).clickOnSignup();
        new SignupAndLoginPage(driver).assertUserInSignupPage()
                .enterNameAndEmailInSignUpPage(jsonFileManager.getTestData("UserName"), jsonFileManager.getTestData("UserMail"));
        new RegistrationFormPage(driver).assertUserInAccountInformationPage()
                .enterAccountInformation(jsonFileManager.getTestData("Password"), jsonFileManager.getTestData("Day"), jsonFileManager.getTestData("Month"), jsonFileManager.getTestData("Year"))
                .enterAddressInformtion("Waleed", "Ahmed", "GizaSystems", "27streetnasrcity", "27streetnasrcity" , "India" , "Cairo" , "Cairooo" , "02" , "0100000000");
        new AccountCreatedPage(driver).assertAccountCreatedMessageIsVisible()
                .clickContinueButtonAfterAccountCreation();
        new MenuPage(driver).assertLoggedinAsUsernameIsVisible()
                .clickDeleteAccountButton();
        new AccountDeletedPage(driver).assertAccountDeletedMessageIsVisible();
    }

    @AfterClass
    public void closeTheBrowser() {
        driver.quit();
    }
}

