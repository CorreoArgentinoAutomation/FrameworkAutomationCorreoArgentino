package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public Base(WebDriver driver){
        this.driver=driver;
    }

    public WebDriver getDriver(){
        return driver;
    }
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }

    //Buscar elemento web
    public WebElement sendWebElement(By locator){
        return driver.findElement(locator);
    }

    //Buscar una lista de elementos web
    public List<WebElement> sendWebElements(By locator){
        return driver.findElements(locator);
    }

    //Hacer click sobre elemento web
    public void click(WebElement element){
        element.click();
    }

    public void click(By locator){
        this.driver.findElement(locator).click();
    }

    //Agregar texto
    public void writeText(By locator, String text){
        this.driver.findElement(locator).sendKeys(text);
    }

    //Agregar combinaciones de teclas por ej: ctrl + shift
    public void agregarCombinacionTeclas(By locator, Keys key){
        this.driver.findElement(locator).sendKeys(key); // en lugar de key escribimos Keys.teclaQueQuerramosSeleccionar
    }

    //Obtener texto
    public String getText(By locator){
        return this.driver.findElement(locator).getText();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    //Cargar una pagina
    public void cargarPagina(String url){
        this.driver.get(url);
    }

    //Espera
    public static void esperarXsegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Espera Explicita por presencia de elemento
    public WebElement explicitWaitElement(By locator) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Espera explicita por elemento clickeable
    public WebElement explicitWaitClick(By locator) {
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Funcion para conectar el driver
    public WebDriver driverConnection(String rut, String property, String browser){
        switch (browser){
            case "Chrome":
                System.setProperty(property,rut);
                this.driver = new ChromeDriver();
                return driver;
            case "Firefox":
                System.setProperty(property,rut);
                this.driver = new FirefoxDriver();
                return driver;
            case "Iexplorer":
                System.setProperty(property,rut);
                this.driver = new InternetExplorerDriver();
                return driver;
            case "Edge":
                System.setProperty(property,rut);
                this.driver = new EdgeDriver();
                return driver;
            default:
                return driver;
        }
    }

    //Maximizar la ventana del navegador
    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }

    //Cerrar el navegador
    public void closeBrowser(){
        this.driver.close();
    }

    //Iframes
    public int contarIframes(By locator){//tag "iframe"
        List<WebElement> frames = this.driver.findElements(locator);
        return frames.size();

    }
}
