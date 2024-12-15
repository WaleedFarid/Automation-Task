package TestPage;
import AutomationExcercisePages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPOM {
    private WebDriver driver;
    private HomePage homePage;
    private SignupAndLoginPage signupAndLoginPage;
    private RegistrationFormPage registrationFormPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;
    private MenuPage menuPage;

    @BeforeClass
    public void openTheBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        signupAndLoginPage = new SignupAndLoginPage(driver);
        registrationFormPage = new RegistrationFormPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
        menuPage = new MenuPage(driver);
    }

    @Test
    public void registrationTestCase() {
        homePage.navigateToUrl();
        homePage.assertUserInHomePage();
        menuPage.clickOnSignup();
        signupAndLoginPage.assertUserInSignupPage();
        signupAndLoginPage.enterNameAndEmailInSignUpPage("Waleed Ahmed", "walid@test.com");
        registrationFormPage.assertUserInAccountInformationPage();
        registrationFormPage.enterAccountInformation("3EDARd@qxbnSrva" , "6" , "4" , "2000");
        registrationFormPage.enterAddressInformtion("Waleed", "Ahmed", "GizaSystems", "27streetnasrcity", "27streetnasrcity" , "India" , "Cairo" , "Cairooo" , "02" , "0100000000");
        accountCreatedPage.assertAccountCreatedMessageIsVisible();
        accountCreatedPage.clickContinueButtonAfterAccountCreation();
        menuPage.assertLoggedinAsUsernameIsVisible();
        menuPage.clickDeleteAccountButton();
        accountDeletedPage.assertAccountDeletedMessageIsVisible();
    }

    @AfterClass
    public void closeTheBrowser() {
        driver.quit();
    }

}
