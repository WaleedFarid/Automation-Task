package AutomationExcercisePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationFormPage {
    private WebDriver driver;

    //Locators
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

    //----------Constructor-----------\\
    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
    }

    //------------Methods-------------\\
    @Step("filling the account information")
    public RegistrationFormPage enterAccountInformation(String password , String day , String month , String year ) {
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
        return this;
    }

    @Step("filling the address information")
    public RegistrationFormPage enterAddressInformtion(String firstname, String lastname, String company, String address1, String address2 , String country, String state, String city, String zipcode, String mobilenumber) {
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
        return this;
    }
    //-----------Validations-----------\\
    @Step("validate that user in account information page")
    public RegistrationFormPage assertUserInAccountInformationPage() {
        Assert.assertTrue(driver.findElement(accountInformationVisible).isDisplayed(), "The Message is not displayed");
        System.out.println("Enter the account information");
        return this;
    }

}
