package framework.engine.selenium;

import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SeleniumTestBase {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Properties properties;

    @BeforeMethod
    public void setUp() {
        loadConfigProperties();
        String browser = properties.getProperty("browser");
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
        driver.get(properties.getProperty("url"));
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            capturarPantalla();
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadConfigProperties() {
        properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Attachment(value = "Captura de Pantalla", type = "image/png")
    public byte[] capturarPantalla() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
