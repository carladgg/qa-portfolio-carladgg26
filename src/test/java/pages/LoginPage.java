package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector(".orangehrm-login-button");
    private By dashboardTitle = By.className("oxd-topbar-header-breadcrumb");
    private By errorMessage = By.cssSelector("p.oxd-alert-content-text");
    private By userDropdown = By.cssSelector("p.oxd-userdropdown-name");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void login(String username, String password) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameInput.clear();
        usernameInput.sendKeys(username);

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    public WebElement getDashboardTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle));
    }

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
        } catch (Exception e) {
            return "Invalid Credentials is not displayed.";
        }
    }
    public void logout() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userDropdown));
        dropdown.click();

        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutBtn.click();
    }
    public WebElement getUsernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }
}
