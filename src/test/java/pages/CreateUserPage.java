package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.TestData;

import java.time.Duration;


public class CreateUserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By adminOption = By.xpath("//span[text()='Admin']");
    private final By userManagement = By.xpath("//span[normalize-space()='User Management']");
    private final By addUserBtn = By.xpath("//button[normalize-space()='Add']");
    private final By addNewUserPage = By.xpath("//h6[normalize-space()='Add User']");
    private final By userRole = By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]");
    private final By adminRole = By.xpath("//div[contains(@class,'oxd-select-dropdown')]//div[contains(normalize-space(.),'Admin')]");
    private final By userEmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By userStatus = By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]");
    private final By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By password = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private final By confirmPassword = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");


    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void goToAdminUserManagement() {
        try {
        WebElement adminOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(adminOption));
        adminOptionBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(userManagement));
        } catch (Exception e) {
            Assert.fail("❌Admin menu option not found.");
        }
    }
    public void goToAddNewUser() {
        try {
            WebElement addNewUser = wait.until(ExpectedConditions.elementToBeClickable(addUserBtn));
            addNewUser.click();
            wait.until(ExpectedConditions.elementToBeClickable(addNewUserPage));
        } catch (Exception e) {
            Assert.fail("❌Add User page not found.");
        }
    }
    public void createNewAdminUser() {
        try {
            // User Role: Admin
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userRole));
            dropdown.click();
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(adminRole));
            option.click();

            // Status: Enabled
            By statusDropdown = By.xpath("//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text-input')][1]");
            By enabledOption = By.xpath("//div[contains(@class,'oxd-select-dropdown')]//div[normalize-space()='Enabled']");
            wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(enabledOption)).click();

            // Employee Name (type-for-hints) — use full name to avoid matching multiple employees
            WebElement empName = wait.until(ExpectedConditions.visibilityOfElementLocated(userEmployeeName));
            empName.sendKeys(TestData.EMPLOYEE_FULL_NAME);
            By empSuggestion = By.xpath("//div[@role='option'][contains(normalize-space(.), '" + TestData.EMPLOYEE_FULL_NAME + "')]");
            wait.until(ExpectedConditions.elementToBeClickable(empSuggestion)).click();
            // Wait for the input to reflect the selected employee (not just the typed text)
            wait.until(ExpectedConditions.attributeToBeNotEmpty(empName, "value"));

            // Username
            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
            usernameInput.clear();
            usernameInput.sendKeys(TestData.USER_USERNAME);

            // Password
            wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(TestData.USER_PASSWORD);
            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(TestData.USER_PASSWORD);

            // Save
            By saveBtn = By.xpath("//button[normalize-space()='Save']");
            wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
            wait.until(ExpectedConditions.urlContains("viewSystemUsers"));
            System.out.println("✅ User saved, redirected to User List");

        } catch (Exception e) {
            Assert.fail("❌Failed to create admin user: " + e.getMessage());
        }
    }

    public void deleteUser(String username) {
        try {
            By usernameSearchField = By.xpath("//label[normalize-space()='Username']/following::input[1]");
            By searchBtn = By.xpath("//button[normalize-space()='Search']");
            // XPath scoped to the specific username row to avoid race condition with old rows
            By userRow = By.xpath("//div[@class='oxd-table-body']//div[@role='row'][.//div[normalize-space()='" + username + "']]");
            By deleteRowBtn = By.xpath("//div[@class='oxd-table-body']//div[@role='row'][.//div[normalize-space()='" + username + "']]//button[1]");
            By confirmDeleteBtn = By.xpath("//button[contains(., 'Yes, Delete')]");

            WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameSearchField));
            usernameInput.clear();
            usernameInput.sendKeys(username);

            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
            search.click();

            // Wait for the specific user row to appear before clicking delete
            wait.until(ExpectedConditions.presenceOfElementLocated(userRow));
            WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteRowBtn));
            deleteBtn.click();

            WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn));
            confirm.click();
            System.out.println("✅ User deleted: " + username);

        } catch (Exception e) {
            Assert.fail("❌Failed to delete user: " + e.getMessage());
        }
    }
}