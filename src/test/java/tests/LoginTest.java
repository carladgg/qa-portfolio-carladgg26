package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LoginHelper;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void loginWithValidCredentialsShowsDashboard() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("Admin", "admin123");

        Assert.assertTrue(
                loginPage.getDashboardTitle().isDisplayed(),
                "❌Dashboard page not found"
        );

        System.out.println("✅Login Test Valid Credentials: Dashboard page found.");
    }

    @Test(priority = 2)
    public void loginWithInValidCredentialsShowsInvalidCredentials() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("Best", "invalid123");
        String errorText = loginPage.getErrorMessage();

        Assert.assertTrue(
                errorText.toLowerCase().contains("invalid") || errorText.toLowerCase().contains("credentials"),
                "❌Invalid Credentials is not displayed"
        );

        System.out.println("✅Login Test Invalid Credentials: " + errorText);
    }
}

