package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmployeePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Navigation
    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By addEmployeeTab = By.xpath("//a[normalize-space()='Add Employee']");
    private final By employeeListTab = By.xpath("//a[normalize-space()='Employee List']");

    // Add Employee form
    private final By firstNameField = By.xpath("//input[@name='firstName']");
    private final By lastNameField = By.xpath("//input[@name='lastName']");
    private final By employeeIdField = By.xpath("//label[normalize-space()='Employee Id']/following::input[1]");
    private final By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private final By personalDetailsHeader = By.xpath("//h6[normalize-space()='Personal Details']");

    // Employee List search
    private final By searchEmployeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private final By deleteRowBtn = By.xpath("//div[@class='oxd-table-body']//div[@role='row'][1]//button[2]");
    private final By confirmDeleteBtn = By.xpath("//button[contains(., 'Yes, Delete')]");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToAddEmployee() {
        try {
            WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
            pim.click();
            WebElement addEmployee = wait.until(ExpectedConditions.elementToBeClickable(addEmployeeTab));
            addEmployee.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        } catch (Exception e) {
            Assert.fail("❌Add Employee page not found: " + e.getMessage());
        }
    }

    public void createEmployee(String firstName, String lastName) {
        try {
            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);

            WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);

            // Override auto-generated ID to avoid conflicts on shared demo site
            WebElement empIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField));
            empIdInput.clear();
            empIdInput.sendKeys(String.valueOf(System.currentTimeMillis() % 100000));

            WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
            save.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader));
            System.out.println("✅ Employee saved, Personal Details page loaded");

        } catch (Exception e) {
            Assert.fail("❌Failed to create employee: " + e.getMessage());
        }
    }

    public void goToEmployeeList() {
        try {
            WebElement pim = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
            pim.click();
            WebElement employeeList = wait.until(ExpectedConditions.elementToBeClickable(employeeListTab));
            employeeList.click();
        } catch (Exception e) {
            Assert.fail("❌Employee List page not found: " + e.getMessage());
        }
    }

    public void deleteEmployee(String firstName, String lastName) {
        try {
            String fullName = firstName + " " + lastName;

            WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeNameField));
            searchInput.clear();
            searchInput.sendKeys(firstName);

            By firstSuggestion = By.xpath("//div[@role='option'][1]");
            WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(firstSuggestion));
            suggestion.click();
            System.out.println("✅ Employee selected in search: " + fullName);

            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
            search.click();

            WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteRowBtn));
            deleteBtn.click();

            WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn));
            confirm.click();
            System.out.println("✅ Employee deleted: " + fullName);

        } catch (Exception e) {
            Assert.fail("❌Failed to delete employee: " + e.getMessage());
        }
    }
}
