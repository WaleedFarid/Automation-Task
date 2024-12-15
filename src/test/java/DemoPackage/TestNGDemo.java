package DemoPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGDemo {
    WebDriver driver ;
@BeforeClass
    public void openTheBrowser() {
    driver =new ChromeDriver();
    driver.manage().window().maximize();
    driver.navigate().to("https://automationexercise.com");
}
    @Test
    public void validateUserInHomePage() {
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed(),"Image not appeared");
        System.out.println("User is in Home Page");
    }

    @Test(dependsOnMethods = {"validateUserInHomePage"})
    public void validateUserClickOnSignup () {
        driver.findElement(By.linkText("Signup / Login")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'New User Signup!')]")).isDisplayed(),"New User Signup!" );
        System.out.println("User is in Signup Page");
}

    @Test(dependsOnMethods = {"validateUserClickOnSignup"})
    public void enterValidNameAndEmailInSignUpPage(){
        driver.findElement(By.name("name")).sendKeys("WaleedFarid");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("waleeed@test.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        System.out.println("User signup successfully");
    }

    @Test(dependsOnMethods = {"enterValidNameAndEmailInSignUpPage"})
    public void verifyEnterAccountInformationIsVisible() {
    Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Enter Account Information')]")).isDisplayed(),"The Message is not displayed");
        System.out.println("Enter the account information");
    }


    @Test(dependsOnMethods = {"verifyEnterAccountInformationIsVisible"})
    public void fillingAccountInformationFields() {
        //Select gender , Name and Password
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("name")).sendKeys("Waleed");
        driver.findElement(By.id("password")).sendKeys("3EDARd@qxbnSrva");

        //Choose from Dropdown List
        new Select(driver.findElement(By.id("days"))).selectByValue("6");
        new Select(driver.findElement(By.id("months"))).selectByValue("4");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");

        //Click on the two Checkpoints below birthdate
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //Enter first , last names , company and address
        driver.findElement(By.id("first_name")).sendKeys("Ahmed");
        driver.findElement(By.id("last_name")).sendKeys("Weloo");
        driver.findElement(By.id("company")).sendKeys("GizaSystems");
        driver.findElement(By.id("address1")).sendKeys("27streetnasrcity");
        driver.findElement(By.id("address2")).sendKeys("27streetnasrcityyy");

        //Country dropdown
        new Select(driver.findElement(By.id("country"))).selectByValue("India");

        //Enter state , city , zipcode and mobile number
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Cairooo");
        driver.findElement(By.id("zipcode")).sendKeys("02");
        driver.findElement(By.id("mobile_number")).sendKeys("010000000000");

        //Click on create account button
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        System.out.println("Regestration form is filled Successfully");
    }

    @Test(dependsOnMethods = "fillingAccountInformationFields")
    public void verifyAccountCreatedIsVisible(){
    Assert.assertEquals(driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText(), "ACCOUNT CREATED!", "Message Is Not Displayed");
    //Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Account Created!')]")).isDisplayed(),"Message is not displayed");
    //Click on Continue Button
    driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    System.out.println("Account is Created Successfully");
    }

    @Test(dependsOnMethods = "verifyAccountCreatedIsVisible")
    public void verifyThatLoggedinAsUsernameIsVisible() {
    Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Waleed')]")).isDisplayed(),"Username is not visible");
        System.out.println("Username is visible");
    }

    @Test(dependsOnMethods = {"verifyThatLoggedinAsUsernameIsVisible"})
    public void deleteAccount() {
    driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        System.out.println("User Pressed on Delete Account");
    }

    @Test(dependsOnMethods = "deleteAccount")
    public void verifyThatAccountDeletedIsVisible() {
    Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]")).isDisplayed(),"Message is not appeared");
    //Assert.assertEquals(driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText(),"Account Deleted!","Message not appeared");
    driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    System.out.println("Account is deleted");
    }




    @AfterClass
    public void closeTheBrowser(){
        driver.quit();
    }



}

/*public void clickonCountineDeleteButton() {
    driver.findElement(countinueDeleteButton).click();
    System.out.println("Account is deleted");
}
//locator
private By countinueDeleteButton = By.xpath("//a[@data-qa='continue-button']");

 */