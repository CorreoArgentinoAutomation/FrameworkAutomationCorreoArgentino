package framework.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.action = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement sendWebElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> sendWebElements(By locator){
        return driver.findElements(locator);
    }

    public void click(WebElement element){
        element.click();
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void writeText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void agregarCombinacionTeclas(By locator, Keys key){
        driver.findElement(locator).sendKeys(key);
    }

    public WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public void cargarPagina(String url){
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

    public WebDriver driverConnection(String rut, String property, String browser){
        switch (browser){
            case "Chrome":
                System.setProperty(property,rut);
                driver = new ChromeDriver();
                return driver;
            case "Firefox":
                System.setProperty(property,rut);
                driver = new FirefoxDriver();
                return driver;
            case "Iexplorer":
                System.setProperty(property,rut);
                driver = new InternetExplorerDriver();
                return driver;
            case "Edge":
                System.setProperty(property,rut);
                driver = new EdgeDriver();
                return driver;
            default:
                return driver;
        }
    }

    public void maximizarVentana(){
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.close();
    }

    public int contarIframes(By locator){
        List<WebElement> frames = driver.findElements(locator);
        return frames.size();
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void selectNthElementFromList(String locator, int index){
        List<WebElement> list = driver.findElements(By.className(locator));
        list.get(index).click();
    }

    public void dragAndDrop(String locator, String locator2){
        WebElement element = Find(locator);
        WebElement element2 = Find(locator2);
        action.dragAndDrop(element, element2).build().perform();
    }

    public void selectCriteriaFromList(String locator, String criteria){
        List<WebElement> list = driver.findElements(By.className(locator));
        for(WebElement element : list){
            if(element.getText().equals(criteria)){
                element.click();
                break;
            }
        }
    }
}


