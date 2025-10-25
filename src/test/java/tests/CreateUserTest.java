package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LoginHelper;

@Listeners(TestListener.class)
public class CreateUserTest extends BaseTest {
    @Test(priority = 1)
    public void createAdminUser() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login("Admin", "admin123");
        System.out.println("✅[STEP 1] Successful login: Dashboard page found.");

        createUserPage.goToAdminUserManagement();
        System.out.println("✅[STEP 2] Navigated to Admin > User Management section successfully.");

        createUserPage.goToAddNewUser();
        System.out.println("✅[STEP 3] Navigated to Admin > User Management > Add User section successfully.");

        createUserPage.createNewAdminUser();
        System.out.println("✅[STEP 4] Admin new user was created successfully.");
    }
    /*@Test(priority = 2)
    public void testFallaIntencional() {
        loginPage.login("Admin", "wrongpassword"); // contraseña incorrecta
        // Esto fallará porque debería mostrar el dashboard y no lo hará
        Assert.assertTrue(loginPage.getDashboardTitle().isDisplayed(), "Dashboard page no encontrada");
    }
    */

}
