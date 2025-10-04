package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateUserPage;
import pages.LoginPage;


public class CreateUserTest extends BaseTest {
    @Test(priority = 1)
    public void createAdminUser() {
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                loginPage.getDashboardTitle().isDisplayed(),
                "Dashboard page not found"
        );
        System.out.println("Login Test Success: Dashboard page found.");

        createUserPage.goToAdminUserManagement();
        System.out.println("User Management Success: User Management page found.");
    }
}
