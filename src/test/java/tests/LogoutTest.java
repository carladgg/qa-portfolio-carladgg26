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
import utils.LoginHelper;

public class LogoutTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private LoginHelper loginHelper;

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
        loginHelper = new LoginHelper(driver);
    }

    @Test(priority = 1)
    public void logoutAfterSuccessfulLogin() {

        loginHelper.login("Admin", "admin123");
        Assert.assertTrue(loginPage.getDashboardTitle().isDisplayed(), "Dashboard not found");


        loginHelper.logout();
        Assert.assertTrue(
                loginPage.getUsernameField().isDisplayed() ||
                        driver.getCurrentUrl().contains("login"),
                "Login page not found"
        );

        System.out.println("✅ Logout Test Success: Login page found");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

