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

    private final By userMenu = By.cssSelector(".oxd-brand");
    private final By adminOption = By.xpath("//li[1]//a[1]//span[1]");

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void goToAdminUserManagement() {
        try {
        WebElement adminOptionBtn = wait.until(ExpectedConditions.elementToBeClickable(adminOption));
        adminOptionBtn.click();
        } catch (Exception e) {
            Assert.fail("Admin menu option not found.");
        }
    }

}