package tests;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LoginHelper;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void loginWithValidCredentialsShowsDashboard() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("Admin", "admin123");
        System.out.println("✅[STEP 1] Login With Valid Credentials: Dashboard page found.");
    }

    @Test(priority = 2)
    public void loginWithInValidCredentialsShowsInvalidCredentials() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginAttempt("Best", "invalid123");
        System.out.println("✅[STEP 1] Login With Invalid Credentials: Invalid credentials validation found.");
    }
}

