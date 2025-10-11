package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

}