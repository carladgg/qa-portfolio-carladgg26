package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void loginWithValidCredentialsShowsDashboard() {
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                loginPage.getDashboardTitle().isDisplayed(),
                "Dashboard page not found"
        );

        System.out.println("✅ Login Test Success: Dashboard page found.");
    }

    @Test(priority = 2)
    public void loginWithInValidCredentialsShowsInvalidCredentials() {
        loginPage.login("Best", "invalid123");

        String errorText = loginPage.getErrorMessage();

        Assert.assertTrue(
                errorText.toLowerCase().contains("invalid") || errorText.toLowerCase().contains("credentials"),
                "Invalid Credentials is not displayed"
        );

        System.out.println("❌ Login Test Failure: " + errorText);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
