package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateUserPage;
import pages.LoginPage;

public class CreateUserTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private CreateUserPage createUserPage;


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
        createUserPage = new CreateUserPage(driver);
    }

    @Test(priority = 1)
    public void createAdminUser() {
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                loginPage.getDashboardTitle().isDisplayed(),
                "Dashboard page not found"
        );
        System.out.println("✅ Login Test Success: Dashboard page found.");

        createUserPage.goToAdminUserManagement();
        System.out.println("✅ User Management Success: User Management page found.");
    }
}
