//Paquete de utilidades para manejar drivers de Selenium.
package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//Clase para controlar una única instancia de WebDriver (singleton).
public class DriverFactory {

    private static WebDriver driver;

    //Si no hay driver inicializado, se crea uno nuevo.
    //Siempre devuelve la misma instancia para todo el proyecto.
    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    //Metodo para cerrar y limpiar el driver.
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
