package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});
            options.addArguments("--lang=es");

            // Lee el flag headless desde Maven/IntelliJ
            String headless = System.getProperty("headless", "false");
            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("window-size=1920,1080");
                System.out.println(">>> Running in HEADLESS mode <<<");
            }
            else {
                System.out.println(">>> Running with UI <<<");
            }

            driver = new ChromeDriver(options);
            if (!headless.equalsIgnoreCase("true")) {
                driver.manage().window().maximize();
            }

        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
