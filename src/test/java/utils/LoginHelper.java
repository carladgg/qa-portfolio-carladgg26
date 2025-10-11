package utils;

import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginHelper {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void login(String username, String password) {
        loginPage.login(username, password);
    }
    public void loginAttempt(String username, String password) {
        loginPage.loginAttempt(username, password);
    }

    public void logout() {
        loginPage.logout();
    }
}
