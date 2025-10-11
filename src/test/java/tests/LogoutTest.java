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
        loginHelper.logout();
        System.out.println("✅[STEP 1] Successful logout: Login page found");
    }
}

