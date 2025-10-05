package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CreateUserTest extends BaseTest {
    @Test(priority = 1)
    public void createAdminUser() {
        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                loginPage.getDashboardTitle().isDisplayed(),
                "❌Dashboard page not found"
        );
        System.out.println("✅Login Test Success: Dashboard page found.");

        createUserPage.goToAdminUserManagement();
        System.out.println("✅User Management Success: User Management page found.");
    }
    /*@Test(priority = 2)
    public void testFallaIntencional() {
        loginPage.login("Admin", "wrongpassword"); // contraseña incorrecta
        // Esto fallará porque debería mostrar el dashboard y no lo hará
        Assert.assertTrue(loginPage.getDashboardTitle().isDisplayed(), "Dashboard page no encontrada");
    }
    */

}
