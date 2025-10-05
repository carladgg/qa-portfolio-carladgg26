package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LogoutTest extends BaseTest {
    @Test(priority = 1)
    public void logoutAfterSuccessfulLogin() {

        loginHelper.login("Admin", "admin123");
        Assert.assertTrue(loginPage.getDashboardTitle().isDisplayed(), "❌Dashboard not found");


        loginHelper.logout();
        Assert.assertTrue(
                loginPage.getUsernameField().isDisplayed() ||
                        driver.getCurrentUrl().contains("login"),
                "❌Login page not found"
        );

        System.out.println("✅Logout Test Success: Login page found");
    }
}

