//Define el paquete de tests.
package tests;
//Imports necesarios para Selenium, TestNG y WebDriverManager.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import java.time.Duration;
//Clase de prueba que ejecutará el login.
public class LoginTest {
    //Instancias de WebDriver y de LoginPage para interactuar con la página.
    private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;
    //Metodo que se ejecuta antes de cada test.
    //Se configura el navegador aquí.
    @BeforeMethod
    public void setUp() {
        // WebDriverManager gestiona la versión correcta de ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Opciones de Chrome: evitar warnings y ocultar logs innecesarios.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // ayuda con ciertos warnings
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"}); // oculta logs

        // Se crea la instancia de ChromeDriver y se maximiza la ventana.
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Se abre la URL de OrangeHRM y se inicializa la página de login.
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //Test que ejecuta el login con credenciales validas.
    @Test(priority = 1)
    public void loginWithValidCredentialsShowsDashboard() {
        //Validar login
        loginPage.login("Admin", "admin123");

        //Validar que el dashboard se muestra
        // Espera hasta 10 segundos a que el elemento sea visible
        WebElement dashboardTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-header-breadcrumb"))
        );
        //Assert verificacion automatica
        Assert.assertTrue(dashboardTitle.isDisplayed(), "There is a problem showing Dashboard");
        System.out.println("Login Test Success: Dashboard page was found.");
    }
    @Test(priority = 2)
    public void loginWithInValidCredentialsShowsInvalidCredentials() {
        //Validar login
        loginPage.login("Best", "invalid123");

        //Validar que el dashboard se muestra
        // Espera hasta 5 segundos a que el elemento sea visible
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content-text"))
        );
        //Assert verificacion automatica
        Assert.assertTrue(errorMessage.isDisplayed(), "Invalid Credentials isn't displayed");
        System.out.println("Login Test Failure: Invalid Credentials is displayed.");
    }


    //Metodo que se ejecuta después de cada test.
    //Cierra el navegador y libera recursos.
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // cierra solo la ventana usada por el test
        }
    }
}
