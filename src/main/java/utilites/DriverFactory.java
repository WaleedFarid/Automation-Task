package utilites;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    static WebDriver driver;

    @Step("open browser {browserName}")
    public static WebDriver initiateDriver(String browserName, boolean maximize , String headless) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if(headless.equalsIgnoreCase("headless")){
                System.out.println("Running in headless mode");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless", "--disable-gpu");
                driver = new ChromeDriver(options);
            }
            else  {
                driver = new ChromeDriver();
            }
            System.out.println("intializing Chrome Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (headless.equalsIgnoreCase("headless")){
                System.out.println("Running in headless mode");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless", "--disable-gpu");
                driver = new FirefoxDriver(options);
            }
            else {
                driver = new FirefoxDriver();
            }
            System.out.println("intializing firefox Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
        } else if (browserName.equalsIgnoreCase("edge")) {
            if (headless.equalsIgnoreCase("headless")){
                System.out.println("Running in headless mode");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless", "--disable-gpu");
                driver = new EdgeDriver(options);
            }
            else {
                driver = new EdgeDriver();
            }
            System.out.println("intializing Edge Browser on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
        }
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("window is maximized , and the window size is " + driver.manage().window().getSize());
        }
        return driver;
    }
}