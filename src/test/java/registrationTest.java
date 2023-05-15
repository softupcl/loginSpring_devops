import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

@TestInstance(Lifecycle.PER_CLASS)
class RegistrationPageTest {

    private static final String URL = "http://localhost:8082/registration";
    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        // Configura la ubicación del driver de Chrome
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        // Inicializa el driver de Chrome
        driver = new ChromeDriver();
        // Navega a la página de registro
        driver.get(URL);
    }

    @AfterAll
    public void tearDown() throws InterruptedException {
        // Espera 5 segundos antes de cerrar la sesión del driver
        Thread.sleep(5000);
        // Cierra la sesión del driver
        driver.quit();
    }

    @Test
    public void testRegistration() {
        // Introduce los datos en el formulario de registro
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("email")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("password")).sendKeys("mypassword");
        driver.findElement(By.id("my-form")).submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("?success"));
        // Comprueba que se muestra un mensaje de éxito después de enviar el formulario
        String successMessage = driver.findElement(By.className("alert-info")).getText();
        assertEquals("You've successfully registered to our awesome app!", successMessage);
    }

}
