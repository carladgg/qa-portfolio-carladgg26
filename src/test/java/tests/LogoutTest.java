package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.LoginHelper;

public class LogoutTest extends BaseTest {
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

        System.out.println("Logout Test Success: Login page found");
    }
}

