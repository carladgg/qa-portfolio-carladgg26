//Define el paquete de tests.
package tests;
//Imports necesarios para Selenium, TestNG y WebDriverManager.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
//Clase de prueba que ejecutará el login.
public class LoginTest {
    //Instancias de WebDriver y de LoginPage para interactuar con la página.
    private WebDriver driver;
    private LoginPage loginPage;
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
    }
    //Test que ejecuta el login con credenciales de demo.
    @Test
    public void testLogin() {
        loginPage.login("Admin", "admin123");
        System.out.println("Login ejecutado correctamente");
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
