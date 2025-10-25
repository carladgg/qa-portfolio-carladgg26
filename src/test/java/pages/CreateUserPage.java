package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userRole));
            dropdown.click();

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(adminRole));
            option.click();
            System.out.println("✅ Admin role selected successfully");

        } catch (Exception e) {
            Assert.fail("❌Admin option not found.");
        }

    }
}