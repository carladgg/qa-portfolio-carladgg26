//Define el paquete donde se encuetra la clase, sirve para organizar el proyecto en módulos
package pages;
//Imports necesarios para Selenium: localizar elementos, interacturar con ellos y esperar condiciones específicas
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//Clase pública que representa la página de login de OrangeHRM.
public class LoginPage {

    //driver: instancia de Selenium WebDriver que controla el navegador.
    //wait: instancia de WebDriverWait, para esperar ciertos estados de los elementos (visibles, clickeables, etc.).
    private WebDriver driver;
    private WebDriverWait wait;


    //Selectores que identifican los elementos del formulario de login.
    //By.name y By.cssSelector son estrategias de localización de elementos.
    private By usernameField = By.name("username"); // Ajusta si cambia el atributo
    private By passwordField = By.name("password"); // Ajusta si cambia el atributo
    private By loginButton = By.cssSelector(".orangehrm-login-button"); // CSS Selector seguro

    //Constructor que recibe el driver y lo asocia a la página.
    //Inicializa wait con 5 segundos de timeout.
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Metodo para hacer login con usuario y contraseña.
    public void login(String username, String password) {

        //Espera a que el campo de usuario sea visible.
        //Limpia cualquier texto previo (clear()) y escribe el username.
        WebElement usernameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(usernameField)
        );
        usernameInput.clear();
        usernameInput.sendKeys(username);

        //Espera a que el campo de password sea visible.
        //Limpia cualquier texto previo (clear()) y escribe el password.
        WebElement passwordInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField)
        );
        passwordInput.clear();
        passwordInput.sendKeys(password);

        //Espera a que el botón de login sea clickeable y luego hace click.
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );
        loginBtn.click();

        // Si hiciste switch a un iframe y necesitas volver al main content:
        // driver.switchTo().defaultContent();
    }
    // Selector para el mensaje de error
    private By errorMessage = By.cssSelector("p.oxd-alert-content-text");

    // Metodo que devuelve el texto del error
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
