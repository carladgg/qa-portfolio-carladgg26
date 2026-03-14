package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateUserPage;
import utils.DriverFactory;
import pages.LoginPage;
import utils.LoginHelper;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected LoginHelper loginHelper;
    protected CreateUserPage createUserPage;

    @BeforeMethod
    public void setUp() {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, java.nio.charset.StandardCharsets.UTF_8));
        driver = DriverFactory.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        loginHelper = new LoginHelper(driver);
        createUserPage = new CreateUserPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
