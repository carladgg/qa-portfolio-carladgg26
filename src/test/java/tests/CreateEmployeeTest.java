package tests;

import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.LoginHelper;
import utils.TestData;

@Listeners(TestListener.class)
public class CreateEmployeeTest extends BaseTest {

    @Test(priority = 1)
    public void createEmployee() {
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.login(TestData.ADMIN_USERNAME, TestData.ADMIN_PASSWORD);
        System.out.println("✅[STEP 1] Successful login: Dashboard page found.");

        employeePage.goToAddEmployee();
        System.out.println("✅[STEP 2] Navigated to PIM > Add Employee section successfully.");

        employeePage.createEmployee(TestData.EMPLOYEE_FIRST_NAME, TestData.EMPLOYEE_LAST_NAME);
        System.out.println("✅[STEP 3] Employee " + TestData.EMPLOYEE_FULL_NAME + " created successfully.");
    }
}
