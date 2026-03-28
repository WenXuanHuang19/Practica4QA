package Practica4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebFormTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void completarFormularioWeb() throws InterruptedException{
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        System.out.println("Paso 1: Abrir pagina correctamente");

        WebElement textInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("my-text-id")));
        textInput.sendKeys("Probando campo de texto 123");
        System.out.println("Paso 2: Campo de texto capturado.");
        Thread.sleep(2000);

        WebElement passwordInput = driver.findElement(By.name("my-password"));
        passwordInput.sendKeys("NoTieneId123");
        System.out.println("Paso 3: Password capturado.");
        Thread.sleep(2000);

        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.sendKeys("Universidad Autónoma de Baja California, Facultad de Ciencias Quimicas e Ingenieria. Aseguramiento de calidad de software, Practica 4");
        System.out.println("Paso 4: Textarea capturado.");
        Thread.sleep(2000);

        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText("Two");
        System.out.println("Paso 5: Opción del dropdown seleccionada.");
        Thread.sleep(2000);

        WebElement checkbox = driver.findElement(By.id("my-check-2"));
        checkbox.click();
        System.out.println("Paso 6: Checkbox activado.");
        Thread.sleep(2000);

        WebElement radioButton = driver.findElement(By.id("my-radio-2"));
        radioButton.click();
        System.out.println("Paso 7: Radio button seleccionado.");
        Thread.sleep(2000);

        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.sendKeys("09/11/2001");
        System.out.println("Paso 8: Fecha ingresada.");
        Thread.sleep(2000);

        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();
        System.out.println("Paso 9: Boton Submit presionado.");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Navegador cerrado.");
    }
}
