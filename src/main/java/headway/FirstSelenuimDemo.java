package headway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstSelenuimDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://automationexercise.com");
        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("WaleedFarid");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("waleed@test");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("name")).sendKeys("Waleed");
        driver.findElement(By.id("password")).sendKeys("3EDARd@qxbnSrva");
        //drop downlist
        WebElement daysDropDown = driver.findElement(By.id("days"));
        Select days = new Select(daysDropDown);
        days.selectByValue("6");

        WebElement monthDropDown = driver.findElement(By.id("months"));
        Select months = new Select(monthDropDown);
        months.selectByValue("4");

        WebElement yearsDropDown = driver.findElement(By.id("years"));
        Select years = new Select(yearsDropDown);
        years.selectByValue("2000");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Ahmed");
        driver.findElement(By.id("last_name")).sendKeys("Weloo");
        driver.findElement(By.id("company")).sendKeys("GizaSystems");
        driver.findElement(By.id("address1")).sendKeys("27streetnasrcity");
        driver.findElement(By.id("address2")).sendKeys("27streetnasrcityyy");
        //Country dropdown
        WebElement countryDropDown = driver.findElement(By.id("country"));
        Select country = new Select(countryDropDown);
        country.selectByValue("India");

        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Cairooo");
        driver.findElement(By.id("zipcode")).sendKeys("02");
        driver.findElement(By.id("mobile_number")).sendKeys("010000000000");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        String showCreatedMessage = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        System.out.println(showCreatedMessage);

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();




    }
}
