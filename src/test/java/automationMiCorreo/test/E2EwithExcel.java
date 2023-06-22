package automationMiCorreo.test;

import automationMiCorreo.pages.PageWelcome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import framework.utils.ReadExcelFile;

import java.io.IOException;


public class E2EwithExcel {

    private WebDriver driver;
    private ReadExcelFile readFile;
    PageWelcome pageWelcome;

    private By ingresaBtn = By.xpath("//body/div[@id='div-barra-principal']/div[1]/div[1]/ul[1]/span[1]/li[1]");
    private By emailBtnLocator = By.xpath("//input[@id='email']");
    private By passwordBtnLocator = By.xpath("//input[@id='password']");
    private By enterBtn2 = By.xpath("//button[@class='btn btn-primary']");

    private By envioDPaqLocator = By.xpath("//a[normalize-space()='Envío de paquete']");
    //private By envioDPaqLocator = By.id("Envío de paquete");

    private By misEnviosLocator = By.xpath("//a[normalize-space()='Mis envíos']");
    //private By misEnviosLocator = By.id("Mis envíos");

    private By serviciosLocator = By.xpath("//a[normalize-space()='Servicios +']");

    private By saldoLocator = By.xpath("//a[contains(@class,'dropdown-toggle altolinea-30')]");

    private By usuarioBtnLocator = By.xpath("//*[@id='liusuariolink']/a");

    private By cerrarSesionLocator = By.xpath("//a[normalize-space()='Cerrar sesión']");

    private By aceptarInfoActualizacionLocator = By.xpath("//div[@id='mensajeModalFooterGen']//button[@type='button'][normalize-space()='Aceptar']");


    @BeforeMethod
    public void setUp()  {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        readFile = new ReadExcelFile();
        driver.get("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
        driver.manage().deleteAllCookies();

    }

   /* @AfterMethod
    public void tearDown()  {
        driver.close();
    }*/


    @Test(priority = 2)
    public void test() throws IOException, InterruptedException {
        String filepath = "C:\\Users\\maximiliano.nabarro\\IdeaProjects\\FrameworkAutomationCorreoArgentino\\Excel\\usuarios.xlsx";
        String emailText = readFile.getCellValue(filepath, "MiCorreo", 0, 0);
        driver.findElement(ingresaBtn).click();
        driver.findElement(emailBtnLocator).sendKeys(emailText);
        String passwordText = readFile.getCellValue(filepath, "MiCorreo", 0, 1);
        driver.findElement(passwordBtnLocator).sendKeys(passwordText);
        Thread.sleep(4000);
        driver.findElement(enterBtn2).click();
        pageWelcome = new PageWelcome(driver);
        pageWelcome.newShipment();
        pageWelcome.cotizadorCreditCard();
        pageWelcome.consult();
        pageWelcome.logOut();
    }

    @Test(priority = 1)
    public void test1() throws IOException, InterruptedException {
        String filepath = "C:/Users/maximiliano.nabarro/IdeaProjects/MiCorreoPageObjectBy/excel/usuarios.xlsx";
        String emailText = readFile.getCellValue(filepath, "MiCorreo", 2, 0);
        driver.findElement(ingresaBtn).click();
        driver.findElement(emailBtnLocator).sendKeys(emailText);
        String passwordText = readFile.getCellValue(filepath, "MiCorreo", 2, 1);
        driver.findElement(passwordBtnLocator).sendKeys(passwordText);
        Thread.sleep(3000);
        driver.findElement(enterBtn2).click();
        Thread.sleep(4000);
        pageWelcome = new PageWelcome(driver);
        pageWelcome.newShipment01();
        System.out.println("Pasó carga de envio");
        pageWelcome.cotizadorCreditCard();
        System.out.println("pasó cotizar y pagar con tarjeta");
        pageWelcome.consult();
        System.out.println("pasó la consulta del envio");
        pageWelcome.logOut();
    }


}