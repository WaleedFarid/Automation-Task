package TestPage;
import AutomationExcercisePages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilites.DriverFactory;
import utilites.JsonFileManager;
import utilites.PropertiesReader;

public class FluentTest {
    private WebDriver driver;
    String NavigateUrl = "https://automationexercise.com";

    @BeforeClass
    public void openTheBrowser() {
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver = DriverFactory.initiateDriver("chrome" , true);
        driver = DriverFactory.initiateDriver(System.getProperty("browserName") , true , System.getProperty("headless"));

        driver.navigate().to(NavigateUrl);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register New User")
    @Test
    public void registrationTestCase() {
        //new HomePage(driver).navigateToUrl()
        new HomePage(driver).assertUserInHomePage();
        new MenuPage(driver).clickOnSignup();
        new SignupAndLoginPage(driver).assertUserInSignupPage()
                                        .enterNameAndEmailInSignUpPage("Waleed Ahmed", "walid0@test.com");
        new RegistrationFormPage(driver).assertUserInAccountInformationPage()
                                        .enterAccountInformation("3EDARd@qxbnSrva" , "6" , "4" , "2000")
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

    @BeforeSuite
    public void beforeSuit(){
        PropertiesReader.loadProperties();
    }
}
