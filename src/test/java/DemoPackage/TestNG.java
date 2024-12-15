package DemoPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG {
    WebDriver driver;
    String userName = "Waleed" ;

    //Locators
    private By imageVisible = By.xpath("//img[@src='/static/images/home/logo.png']");
    //private By signupIsVisible = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By signupIsVisible = By.cssSelector("div.signup-form h2");
    private By loginAndSignupVisible = By.linkText("Signup / Login");
    private By nameOfSignup = By.name("name");
    private By emailOfSignup = By.xpath("//input[@data-qa='signup-email']");
    private By signupClickButton = By.xpath("//button[@data-qa='signup-button']");
    //private By accountInformationVisible = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private By accountInformationVisible = By.xpath("//h2[@class='title text-center']/b");
    private By genderAccountInformation = By.id("id_gender1");
    private By passwordAccountInformation = By.id("password");
    private By daysAccountInformation = By.id("days");
    private By monthsAccountInformation = By.id("months");
    private By yearsAccountInformation = By.id("years");
    private By newsLetterCheckBox = By.id("newsletter");
    private By optinCheckBox = By.id("optin");
    private By firstnameAccountInformation = By.id("first_name");
    private By lastnameAccountInformation = By.id("last_name");
    private By companyAccountInformation = By.id("company");
    private By address1AccountInformation = By.id("address1");
    private By address2nameAccountInformation = By.id("address2");
    private By countryAccountInformation = By.id("country");
    private By stateAccountInformation = By.id("state");
    private By cityAccountInformation = By.id("city");
    private By zipcodeAccountInformation = By.id("zipcode");
    private By mobilenumberAccountInformation = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedVisible = By.xpath("//h2[@data-qa='account-created']");
    private By countinueButton = By.xpath("//a[@data-qa='continue-button']");
    private By userLoggedVisible = By.xpath("//a/b");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedVisible = By.xpath("//b[contains(text(),'Account Deleted!')]");

    @BeforeClass
    public void openTheBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com");
    }

    @Test
    public void registrationTestCase() {
        assertUserInHomePage();
        clickOnSignupFromHomePage();
        assertUserInSignupPage();
        enterNameAndEmailInSignUpPage("Waleed Ahmed", "walid@test.com");
        assertUserInAccountInformationPage();
        enterAccountInformation("3EDARd@qxbnSrva" , "6" , "4" , "2000");
        enterAddressInformtion("Waleed", "Ahmed", "GizaSystems", "27streetnasrcity", "27streetnasrcity" , "India" , "Cairo" , "Cairooo" , "02" , "0100000000");
        assertAccountCreatedMessageIsVisible();
        clickContinueButtonAfterAccountCreation();
        assertLoggedinAsUsernameIsVisible();
        clickDeleteAccountButton();
        assertAccountDeletedMessageIsVisible();
    }

    @AfterClass
    public void closeTheBrowser() {
        driver.quit();
    }
    //Methods
    public void assertUserInHomePage() {
        Assert.assertTrue(driver.findElement(imageVisible).isDisplayed(), "Image not appeared");
        System.out.println("User is in Home Page");
    }

    public void assertUserInSignupPage() {
        Assert.assertTrue(driver.findElement(signupIsVisible).isDisplayed(), "New User Signup!");
    }

    public void clickOnSignupFromHomePage() {
        driver.findElement(loginAndSignupVisible).click();
        System.out.println("User is in Signup Page");
    }

    public void enterNameAndEmailInSignUpPage(String name, String email) {
        driver.findElement(nameOfSignup).sendKeys(name);
        driver.findElement(emailOfSignup).sendKeys(email);
        driver.findElement(signupClickButton).click();
        System.out.println("User signup successfully");
    }

    public void enterAccountInformation(String password , String day , String month , String year ) {
        //Enter gender and password
        driver.findElement(genderAccountInformation).click();
        driver.findElement(passwordAccountInformation).sendKeys(password);
        //Enter birthdate
        new Select(driver.findElement(daysAccountInformation)).selectByValue(day);
        new Select(driver.findElement(monthsAccountInformation)).selectByValue(month);
        new Select(driver.findElement(yearsAccountInformation)).selectByValue(year);
        //click on checkbox
        driver.findElement(newsLetterCheckBox).click();
        driver.findElement(optinCheckBox).click();
    }

    public void enterAddressInformtion(String firstname, String lastname, String company, String address1, String address2 , String country, String state, String city, String zipcode, String mobilenumber) {
        //Enter firstname , lastname , company , address1 , address2
        driver.findElement(firstnameAccountInformation).sendKeys(firstname);
        driver.findElement(lastnameAccountInformation).sendKeys(lastname);
        driver.findElement(companyAccountInformation).sendKeys(company);
        driver.findElement(address1AccountInformation).sendKeys(address1);
        driver.findElement(address2nameAccountInformation).sendKeys(address2);
        //Enter country , state , city , zipcode , mobile number
        new Select(driver.findElement(countryAccountInformation)).selectByValue(country);
        driver.findElement(stateAccountInformation).sendKeys(state);
        driver.findElement(cityAccountInformation).sendKeys(city);
        driver.findElement(zipcodeAccountInformation).sendKeys(zipcode);
        driver.findElement(mobilenumberAccountInformation).sendKeys(mobilenumber);
        driver.findElement(createAccountButton).click();
        System.out.println("Registration form is filled Successfully");
    }

    public void assertAccountCreatedMessageIsVisible() {
        Assert.assertEquals(driver.findElement(accountCreatedVisible).getText(), "ACCOUNT CREATED!", "Message Is Not Displayed");
    }

    public void assertUserInAccountInformationPage() {
        Assert.assertTrue(driver.findElement(accountInformationVisible).isDisplayed(), "The Message is not displayed");
        System.out.println("Enter the account information");
    }

    public void clickContinueButtonAfterAccountCreation() {
        driver.findElement(countinueButton).click();
        System.out.println("Account is Created Successfully");
    }

    public void assertLoggedinAsUsernameIsVisible() {
        Assert.assertEquals("Logged in as" + driver.findElement(userLoggedVisible).getText(), "Logged in asWaleed Ahmed", "Username is not visible");
        System.out.println("Username is visible");
    }

    public void clickDeleteAccountButton() {
        driver.findElement(deleteAccountButton).click();
        System.out.println("User Pressed on Delete Account");
    }

    public void assertAccountDeletedMessageIsVisible() {
        Assert.assertTrue(driver.findElement(accountDeletedVisible).isDisplayed(), "Message is not appeared");
    }

}
