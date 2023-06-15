package framework.engine.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class SeleniumWrapper {
    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement sendWebElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> sendWebElements(By locator) {
        return driver.findElements(locator);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void writeText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void agregarCombinacionTeclas(By locator, Keys key) {
        driver.findElement(locator).sendKeys(key);
    }

    public WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public void cargarPagina(String url) {
        driver.get(url);
    }

    public static void esperarXsegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement explicitWaitElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement explicitWaitClick(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebDriver driverConnection(String rut, String property, String browser) {
        switch (browser) {
            case "Chrome":
                System.setProperty(property, rut);
                this.driver = new ChromeDriver();
                return driver;
            case "Firefox":
                System.setProperty(property, rut);
                this.driver = new FirefoxDriver();
                return driver;
            case "Iexplorer":
                System.setProperty(property, rut);
                this.driver = new InternetExplorerDriver();
                return driver;
            case "Edge":
                System.setProperty(property, rut);
                this.driver = new EdgeDriver();
                return driver;
            default:
                return driver;
        }
    }

    public void maximizarVentana() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.close();
    }

    public int contarIframes(By locator) {
        List<WebElement> frames = driver.findElements(locator);
        return frames.size();
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void takeScreenshot(String filePath) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), Path.of(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadPDFFromPreview() {
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pdfFilePath = "C:\\ruta\\archivo.pdf";
        try {
            Files.copy(tempFile.toPath(), Path.of(pdfFilePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.switchTo().window(parentWindowHandle);
    }

    public void verificarTexto(By locator, String textoEsperado) {
        WebElement cuadroTexto = explicitWaitElement(locator);

        // Escribe el texto en el cuadro de texto
        cuadroTexto.sendKeys(textoEsperado);

        // Obtiene el valor actual del cuadro de texto
        String textoActual = cuadroTexto.getAttribute("value");

        // Verifica si el texto escrito coincide con el texto esperado utilizando una aserción
        assert textoActual.equals(textoEsperado) : "El texto no se ha escrito correctamente en el cuadro de texto";
    }
}
