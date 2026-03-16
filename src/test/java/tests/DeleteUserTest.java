package tests;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LoginHelper;
import utils.TestData;

@Listeners(TestListener.class)
public class DeleteUserTest extends BaseTest {

    @Test(priority = 1)
    public void deleteAdminUser() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login(TestData.ADMIN_USERNAME, TestData.ADMIN_PASSWORD);
        System.out.println("✅[STEP 1] Successful login: Dashboard page found.");

        createUserPage.goToAdminUserManagement();
        System.out.println("✅[STEP 2] Navigated to Admin > User Management section successfully.");

        createUserPage.deleteUser(TestData.USER_USERNAME);
        System.out.println("✅[STEP 3] User " + TestData.USER_USERNAME + " deleted successfully.");
    }
}
