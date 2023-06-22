package automationSIE.pages;
import framework.utils.ReadExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.engine.selenium.SeleniumWrapper;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class PageSIE extends SeleniumWrapper {
    //Locators ingreso
    private By enterBtnLocator = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]");
    private By closeVideoLocator = By.xpath("//span[@class='closeVideo me-2 mt-2']");
    private By registerBtnLocator = By.xpath("//button[contains(@class,'fs-5 w-100 mb-3 btn btn-primary')][normalize-space()='Registrarme']");
    private By peopleBtnLocator = By.xpath("//label[@for='people']");
    private By acceptBtnLocator = By.xpath("//button[contains(text(),'Aceptar')]");

    //Locators login
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By enterBtn = By.xpath("//button[normalize-space()='Ingresar']");

    //Locators envio de carta
    private By cartaDocumentoLocator = By.xpath("//input[@type='radio' and @id='CARTA DOCUMENTO']");
    private By iframeCaptcha = By.xpath("(//*[@id=\"recaptcha-anchor\"]/div)[3]");
    private By misEnviosLocator = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[1]/div/div/h5");
    private By nuevoEnvio = By.xpath("//a[@href=\"/dashboard/shipments\"]/p[@class=\"font-secondary fw-bold\"]\n" + "\n");
    private By btnNext= By.xpath("//button[(text()='Siguiente')]");
    private By checkbox= By.xpath("//input[@type='checkbox' and @id='withDescription' and @name='withDescription']");
    private By textAreaDomicilio= By.xpath("//textarea[@id='residence']");

    private By textName= By.xpath("//input[@id='name' and @name='name' and @type='text']");
    private By selectProvincia= By.xpath("//input[@id='province']");
    private By laRiojaLocator= By.xpath("//*[@id=\"popover\"]/ul/li[12]");
    private By agregarDestinatario= By.xpath("//div[@class='d-inline-flex w-40px h-40px bg-secondary border rounded-circle']");
    private By textBoxLocator= By.xpath("//body[@role='textbox']");
    private By confirmaYpagaTuenvio= By.xpath("//button[@type='submit' and @class='border border-success ms-1 btn btn-success']");
    private By seleccionCheckBox= By.xpath("//input[@type='checkbox' and @id='selectAll']");
    private By realizarPago= By.xpath("//button[@type='button' and @class='w-100 btn btn-secondaryFilled']");
    private By misDestinatarios= By.xpath("//h5[normalize-space()='Mis destinatarios']");
    private By abmDestinatarios = By.xpath("//p[normalize-space()='Agregar, eliminar o editar mis destinatarios']");
    private By allChecklistDestinatario= By.xpath("//input[@type='checkbox' and @id='allChecked']");
    private By btnAgregar= By.xpath("//button[normalize-space()='Agregar']");
    private By btnEliminar= By.xpath("//button[normalize-space()='Eliminar']");
    private By btnGuardar = By.xpath("//button[normalize-space()='Guardar']");
    private By countryLocator= By.xpath("//input[@id='country']");

    public PageSIE(WebDriver driver) {
        super(driver);
    }
    public void ingresar(){
        //ingreso
        click(enterBtnLocator);
        esperarXsegundos(1000);
        click(closeVideoLocator);
        click(peopleBtnLocator);
        click(acceptBtnLocator);
        esperarXsegundos(4000);
    }

    public void login() {
        //login
        writeText(emailLocator,"zextldileo@gmail.com");
        writeText(passwordLocator,"Corasa23!!!");
        esperarXsegundos(20000);
        click(enterBtn);
        esperarXsegundos(4000);
    }
    //Envio de carta
    public void datosRemitente() throws InterruptedException{

        click(cartaDocumentoLocator);
        esperarXsegundos(2111);
        click(misEnviosLocator);
        esperarXsegundos(2000);
        click(nuevoEnvio);
        esperarXsegundos(5000);
        try{
            click(btnNext);
        }catch (Exception e){
            esperarXsegundos(2000);
            click(btnNext);
        }
        esperarXsegundos(3000);
        try {
            click(checkbox);
        }catch (Exception e){
            esperarXsegundos(2000);
            click(checkbox);
        }
        writeText(textAreaDomicilio, "Barrio Santa Rita - Manzana 9 - Casilla 123");
        esperarXsegundos(1000);
        try {
            click(checkbox);
        }catch (Exception e){
            esperarXsegundos(2000);
            click(checkbox);
        }
        esperarXsegundos(3000);
        try{
            click(btnNext);
        }catch (Exception e){
            esperarXsegundos(2000);
            click(btnNext);
        }
        esperarXsegundos(1000);
    }
    public void datosDestinatario(){
        //Destinatario
        try{
            click(textName);
        }catch (Exception e){
            esperarXsegundos(2000);
            writeText(textName,"Carlos Navarro");
        }
        esperarXsegundos(1000);
        click(selectProvincia);
        esperarXsegundos(3000);
        click(laRiojaLocator);
        esperarXsegundos(1500);
        write("//input[@id='city']","LA RIOJA");
        esperarXsegundos(1500);
        write("//input[@id='street']","LA TROYA");
        esperarXsegundos(1500);
        write("//input[@id='streetNumber']","110");
        esperarXsegundos(1500);
        write("//input[@id='zipCode']","5300");
        esperarXsegundos(1500);
        click(agregarDestinatario);
        esperarXsegundos(1000);
        click(btnNext);
        esperarXsegundos(3000);
    }

    public void writeTextBox(){
        WebElement iframe = findElement(By.tagName("iframe"));
        switchToFrame(iframe);
        writeText(textBoxLocator, "Esto es una prueba de envio de carta de documento minorista");
        esperarXsegundos(2000);
        switchToDefaultContent();
        esperarXsegundos(2000);
        click(confirmaYpagaTuenvio);
        esperarXsegundos(3000);
    }
    public void seleccionarYpagar() {
        // Seleccionar todos los checkbox
        click(seleccionCheckBox);
        esperarXsegundos(5000);

        String mainTab = getWindowHandles().toString();
        String newTap = "";

        // Hacer clic en el botón de pago
        click(realizarPago);
        esperarXsegundos(5000);

        Set<String> handles = getWindowHandles();
        for (String actual : handles){
            if(!actual.equals(mainTab)){
                switchToWindow(actual);
                esperarXsegundos(3000);
                newTap = actual;
            }
        }
        esperarXsegundos(3000);

        // Tareas en nueva pestaña
        click(By.xpath("//input[@type='radio' and @id='decidir' and @name='elegir']"));
        esperarXsegundos(2000);
        click(By.xpath("//option[@value='0: 1']"));
        esperarXsegundos(2000);
        writeText(By.xpath("//input[@name='card_holder_name']"), "Luciano Di Leo");
        esperarXsegundos(2000);
        writeText(By.xpath("//input[@type='text' and @name='number']"), "11111111");
        esperarXsegundos(2000);
        writeText(By.xpath("//input[@type='text' and @name='card_number']"), "4507990000004900");
        esperarXsegundos(2000);
        click(By.xpath("//option[@ngvalue='08']"));
        esperarXsegundos(2000);
        click(By.xpath("//option[@value='7: 30']"));
        esperarXsegundos(2000);
        writeText(By.xpath("//input[@name='security_code']"), "123");
        esperarXsegundos(2000);
        click(By.xpath("//button[normalize-space()='PAGAR']"));
        esperarXsegundos(2000);
        click(By.xpath("//button[@type='button' and @class='swal2-confirm swal2-styled swal2-default-outline']"));
        esperarXsegundos(5000);
        click(By.xpath("//button[normalize-space()='Volver']"));
        esperarXsegundos(4000);
    }

    public void comprobarPago(){
        click(misEnviosLocator);
        esperarXsegundos(2000);
        click(By.xpath("//p[normalize-space()='Historial']"));
        esperarXsegundos(2000);
        try {
            WebElement elemento = findElement(By.xpath("//div[normalize-space()='Pago confirmado']"));
            if (elemento != null) {
                String texto = elemento.getText();
                boolean textoVisible = elemento.isDisplayed();
                if (textoVisible) {
                    System.out.println("******---- PAGO CONFIRMADO ----******");
                } else {
                    System.out.println("--- EL PAGO NO ESTA CONFIRMADO ---");
                }
            } else {
                System.out.println("El elemento no se encuentra en la página");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error al buscar el elemento por XPath: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se produjo un error inesperado: " + e.getMessage());
        }
    }
    public void cerrarSesion(){
        esperarXsegundos(2000);
        click(By.xpath("//button[@type='submit' and @class='btn btn-link py-0 d-flex align-items-center']"));
        esperarXsegundos(5000);
    }
    public void misDestinatarios(){
        click(misDestinatarios);
        esperarXsegundos(1000);
        click(abmDestinatarios);
        esperarXsegundos(4000);
    }
    public void eliminarDestinatarios(){
        click(allChecklistDestinatario);
        esperarXsegundos(3000);
        try{
            click(btnEliminar);
        }catch (Exception e){
            click(btnEliminar);
        }
        esperarXsegundos(1000);
    }
    public void agregarDestinatarios() {
        click(btnAgregar);
        esperarXsegundos(4000);
        writeText(textName, "Carlos Navarro");
        esperarXsegundos(1000);
        click(selectProvincia);
        esperarXsegundos(3000);
        click(laRiojaLocator);
        esperarXsegundos(1500);
        write("//input[@id='city']", "LA RIOJA");
        esperarXsegundos(1500);
        write("//input[@id='street']", "LA TROYA");
        esperarXsegundos(1500);
        write("//input[@id='streetNumber']", "110");
        esperarXsegundos(1500);
        write("//input[@id='zipCode']", "5300");
        esperarXsegundos(2000);
        click(By.id("apartment"));
        esperarXsegundos(1000);
        try {
            click(btnGuardar);
        } catch (Exception e) {
            click(btnGuardar);
        }
    }
}


