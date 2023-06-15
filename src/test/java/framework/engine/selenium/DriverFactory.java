package framework.engine.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> hiloLocal = new ThreadLocal<>();
    /**
     * Inicializa el WebDriver según la selección del navegador
     *
     * @param browser: chrome | firefox | edge
     * @return WebDriver
     */
      public WebDriver inicializarDriver(String browser) {
        System.out.println("El valor del navegador es: " + browser);
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                hiloLocal.set(new ChromeDriver());
                getDriver().manage().deleteAllCookies();
                getDriver().manage().window().maximize();
                getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
                return getDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                hiloLocal.set(new FirefoxDriver());
                getDriver().manage().deleteAllCookies();
                getDriver().manage().window().maximize();
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                return getDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                hiloLocal.set(new EdgeDriver());
                getDriver().manage().deleteAllCookies();
                getDriver().manage().window().maximize();
                getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
                return getDriver();
            default:
                throw new RuntimeException("Navegador no configurado: " + browser);
        }
    }

    public WebDriver createWebDriver() {
        String webDriver = System.getProperty("browser", "chrome");
        switch (webDriver) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new RuntimeException("Error en el WebDriver: " + webDriver);
        }
    }

    /**
     * Retorna el WebDriver desde el ThreadLocal
     *
     * @return WebDriver
     */
     public static WebDriver getDriver() {
        return hiloLocal.get();
    }
}



