package pages;

import utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageWelcome {
	private WebDriver driver;
	//NUEVO ENVIO
	private By accessButton;
	private By profileButton;
	/*private By logOutButton;*/
	//SALDO
	private By balanceLabel;
	private By balanceChargeOption; //SELEC. RECARGA DE SALDO
	//MOVIMIENTOS
	private By movementsOption;  //SELEC. VER MOVIMIENTOS

	//NUEVO ENVIO
	private By sendPackageOption = By.xpath("(//a[@class='dropdown-toggle  altolinea-30' and @data-toggle='dropdown'])[1]");
	private By newShipmentLocator = By.xpath("(//a[normalize-space()='Nuevo envío'])[1]");

	private By newSendOption = By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[2]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]");
	private By nextBtnn = By.xpath("//button[@id='btn-siguiente-envios']");
	private By nameBtnn = By.xpath("//input[@id='envio-destino-nombre']");
	private By provinciaBtnn = By.xpath("//select[@id='envio-destino-provincia']");
	private By optionB = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/select[1]/option[3]");
	private By optionK = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/select[1]/option[4]");
	private By sucursalLocator = By.xpath("//select[@id='envio-destino-sucursal']");
	private By optionBelen = By.xpath("//*[@id='envio-destino-sucursal']/option[5]");
	private By localidad = By.xpath("//input[@id='envio-destino-localidad']");
	private By calle = By.xpath("//input[@id='envio-destino-calle']");
	private By altura = By.xpath("//input[@id='envio-destino-altura']");
	private By postalCode = By.xpath("//input[@id='envio-destino-cp']");
	private By mailBox = By.xpath("//input[@id='envio-destino-mail']");
	private By nextBtnn2 = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/button[2]");
	private By nextBtnn3 = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/button[2]/i[1]");
	private By productType = By.xpath("//select[@id='tipo_producto']");
	private By optionClasic = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/select[1]/option[2]");
	private By weight = By.xpath("//input[@id='envio-peso']"); 
	private By large = By.xpath("//input[@id='envio-largo']");
	private By width = By.xpath("//input[@id='envio-ancho']");
	private By height = By.xpath("//input[@id='envio-espesor']");
	private By price = By.xpath("//input[@id='envio-valor']");
	private By addBtn = By.xpath("//button[@id='btnagregar']");
	private By panel = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[1]/a[1]");
	//COTIZADO
	private By labelBtn = By.xpath("//thead/tr[1]/td[1]/div[1]/label[1]");
	private By quoteBtn = By.xpath("//button[@id='btnpedido']");
	private By balance = By.xpath("//input[@id='radioSaldo']"); 
	private By payBtn = By.xpath("//body/div[@id='page-wrapper']/div[2]/form[1]/div[1]/div[3]/div[1]/div[2]/button[3]"); 
	private By payBtn2 = By.xpath("//button[@id='pagar']"); 
	//ROTULADO
	//(//a[normalize-space()='Mis envíos'])[1]
	private By myShipmentsBtns = By.xpath("(//*[@id='limisenvioslink']/a/i)[1]");
	private By shipingManagementBtn = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]/font[1]/font[1]");
	private By labelBtn2 = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]"); 
	private By generateLabelBtn = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]");
	//CREACION CUENTA HIJA
	private By userBtn = By.xpath("//li[@id='liusuariolink']"); 
	private By addUserBtn = By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[2]/div[2]/ul[1]/li[6]/ul[1]/li[2]"); 
	private Select rolBtn;
	private By nombreBtn2 = By.xpath("//input[@id='nombre']");
	private By apellidoBtn2 = By.xpath("//input[@id='apellido']");
	private By emailBtn2 = By.xpath("//input[@id='email']");
	private By saveUser = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/button[1]"); 
	//TOMA DE CONTROL DE ENVIOS EN CUENTA PADRE 
	private By sendUsersBtn = By.xpath("//a[contains(text(),'Envíos de usuarios')]");
	private By labelBtn3 = By.xpath("//thead/tr[1]/th[1]/label[1]"); 
	private By takeControlBtn = By.xpath("//button[contains(text(),'Tomar control de los seleccionados')]");
	private By aceptarBtn = By.xpath("//body/div[@id='page-wrapper']/div[@id='myModalGenerico']/div[1]/div[1]/div[3]/button[1]");
	private By myShipmentsBtns2 = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[3]/a[1]");
	private By branchDeliveryLocator = By.xpath("//input[@id='sucursal']");
	private By consultLocator = By.xpath("//a[normalize-space()='Consulta']");
	private By destinatarioLocator = By.xpath("//input[@id='destino_nombre']");
	private By consultBtnLocator = By.xpath("//button[@id='btnConsulta']");
	private By backBtnLocator= By.xpath("(//button[normalize-space()='Volver'])[1]");
														//("//button[@id='btnGoBack']")
	//Botón para seleccionar envios o paquetes
	private By selectSend = By.xpath("//tbody/tr/td/div/label[1]");
	private By creditCardLocator = By.xpath("//div[@id='radios_checked']//label[@id='tarjeta']//input[@id='radioTarjeta']");
	private By visaLocator = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[3]/div[1]/form[5]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/label[1]");
	private By cardNumberLocator = By.id("card_number");
	private By securityCodeLocator = By.id("security_code");
	private By cardExpMonthLocator = By.id("card_expiration_month");
	private By cardExpYearLocator = By.id("card_expiration_year");
	private By cardHolderNameLocator = By.id("card_holder_name");
	private By dniLocator = By.id("card_holder_doc_number");
	private By initBtnLocator = By.xpath("//body/div[@id='page-wrapper']/div[3]/form[1]/a[1]");





	public PageWelcome(WebDriver driver) {
		this.driver = driver;
		//NUEVO ENVIO
		accessButton = By.id("lidashboardlink");
		//sendPackageOption = By.className("dropdown-toggle");
		//newSendOption = By.linkText("Nuevo env�o");
		//SALDO
		balanceLabel = By.xpath("//a[@class='dropdown-toggle altolinea-30']");
		balanceChargeOption = By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[5]/ul/li[2]/a/span");
		//MOVIMIENTOS
		movementsOption= By.xpath("//*[@id=\"lisaldolink\"]/ul/li[3]/a/span");
		//LOGOUT
		profileButton=By.id("liusuariolink");
		//SE DESACTIVA EL BOTON LOGOFF PARA REDIRECCIONAR A UNA URL QUE DESLOGUEA
		/*logOutButton = By.xpath("//*[@id=\"ul-menu-usuario\"]/li[8]/a");*/
	}



	public void selectUserPanel() {
		driver.findElement(accessButton).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(1);
	}

	public void newSend() {
		Helpers helper = new Helpers();
		driver.findElement(sendPackageOption).click();
		helper.sleepSeconds(2);
		driver.findElement(newSendOption).click();
	}


	public void balanceChargePanel() {
		Helpers helper = new Helpers();
		driver.findElement(balanceLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(balanceChargeOption).click();
		helper.sleepSeconds(1);
	}
	
	public void selectUserMovements() {
		Helpers helper = new Helpers();
		driver.findElement(balanceLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(movementsOption).click();
		helper.sleepSeconds(1);	
	}
		
	
	public void logOut() {
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);
		driver.findElement(profileButton).click();
		helper.sleepSeconds(3);
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/logout");
		helper.sleepSeconds(2);
		driver.close();
	}

	public void consult() throws InterruptedException {
		driver.findElement(myShipmentsBtns).click();
		Thread.sleep(5550);
		driver.findElement(consultLocator).click();
		driver.findElement(destinatarioLocator).sendKeys("Hector Lavalle");
		driver.findElement(consultBtnLocator).click();
		Thread.sleep(5800);
		driver.findElement(backBtnLocator).click();
		Thread.sleep(4500);

	}
	public void newShipment() throws InterruptedException { 
		
		//NUEVO ENVIO 1 
		driver.findElement(sendPackageOption).click();
		Thread.sleep(3000);
		driver.findElement(newSendOption).click();
		Thread.sleep(3000);
		driver.findElement(nextBtnn).click();
		Thread.sleep(3000);
		driver.findElement(nameBtnn).sendKeys("Joaquin Hernandez");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av. Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		Thread.sleep(4000);
		driver.findElement(nextBtnn3).click();
		Thread.sleep(2000);
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("1000");
		driver.findElement(addBtn).click();
		Thread.sleep(5000);
	}


	public void newShipment01() throws InterruptedException {

		//NUEVO ENVIO 01
		driver.findElement(sendPackageOption).click();
		Thread.sleep(299);
		driver.findElement(newSendOption).click();
		Thread.sleep(399);
		driver.findElement(nextBtnn).click();
		Thread.sleep(299);
		driver.findElement(branchDeliveryLocator).click();
		Thread.sleep(299);
		driver.findElement(nameBtnn).sendKeys("Hector Lavalle");
		Thread.sleep(299);
		driver.findElement(provinciaBtnn).click();
		Thread.sleep(299);
		driver.findElement(optionK).click();
		Thread.sleep(499);
		driver.findElement(sucursalLocator).click();
		Thread.sleep(399);
		driver.findElement(optionBelen).click();
		driver.findElement(mailBox).sendKeys("pablo123@yopmail.com");
		Thread.sleep(500);
		driver.findElement(nextBtnn2).click();
		Thread.sleep(900);
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("3");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("12");
		driver.findElement(height).sendKeys("20");
		driver.findElement(price).sendKeys("15000");
		driver.findElement(addBtn).click();
		Thread.sleep(5000);
	}
	public void newShipment2() throws InterruptedException {
		//NUEVO ENVIO 2 
		driver.findElement(sendPackageOption).click();
		Thread.sleep(1000);
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
	}
	public void newShipment3() throws InterruptedException {
		//NUEVO ENVIO 3 
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
	}
	public void newShipment4() throws InterruptedException {
		//NUEVO ENVIO 4
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
	}
	public void newShipment5() throws InterruptedException {
		//NUEVO ENVIO 5
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
	}

	public void cotizadorCreditCard() throws InterruptedException {
		driver.findElement(selectSend).click();
		Thread.sleep(6000);
		driver.findElement(quoteBtn).click();
		Thread.sleep(6000);
		driver.findElement(creditCardLocator).click();
		Thread.sleep(4000);
		driver.findElement(payBtn).click();
		Thread.sleep(5000);
		driver.findElement(visaLocator).click();
		driver.findElement(cardNumberLocator).sendKeys("4507990000004905");
		driver.findElement(securityCodeLocator).sendKeys("775");
		driver.findElement(cardExpMonthLocator).sendKeys("08");
		driver.findElement(cardExpYearLocator).sendKeys("25");
		driver.findElement(cardHolderNameLocator).sendKeys("TARJETA VISA");
		driver.findElement(dniLocator).sendKeys("11111111");
		Thread.sleep(5000);
		driver.findElement(payBtn2).click();
		Thread.sleep(6000);
		driver.findElement(initBtnLocator).click();
		Thread.sleep(3000);
	}
	public void cotizacionMasiva() throws InterruptedException { 
		driver.findElement(labelBtn).click();
		driver.findElement(quoteBtn).click();
		driver.findElement(balance).click(); 
		driver.findElement(payBtn).click();
		driver.findElement(payBtn2).click();
	}

	public void rotuladoMasivo() throws InterruptedException { 
		driver.findElement(myShipmentsBtns).click();
		driver.findElement(shipingManagementBtn).click();
		driver.findElement(labelBtn2).click();
		driver.findElement(generateLabelBtn).click();
		Thread.sleep(5000);
	}
	public void creacionCuentaHija() throws InterruptedException {
		driver.findElement(userBtn).click();
		driver.findElement(addUserBtn).click();
		rolBtn = new Select(driver.findElement(By.xpath("//select[@id='rol']")));
		Thread.sleep(5000);
		rolBtn.selectByValue("5");
		driver.findElement(nombreBtn2).sendKeys("Usuario");
		driver.findElement(apellidoBtn2).sendKeys("Uno");
		driver.findElement(emailBtn2).sendKeys("cuentahijouno@yopmail.com");
		driver.findElement(saveUser).click();
	}
	public void cuentaPadreTakeControl() throws InterruptedException { 
		driver.findElement(myShipmentsBtns2).click();
		driver.findElement(sendUsersBtn).click();
		driver.findElement(labelBtn3).click();
		driver.findElement(takeControlBtn).click();
		driver.findElement(aceptarBtn).click();
	
	}

	public void cotizacionMasiva2() throws InterruptedException { 
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(labelBtn).click();
		driver.findElement(quoteBtn).click();
		driver.findElement(balance).click(); 
		driver.findElement(payBtn).click();
		driver.findElement(payBtn2).click();
	}
	public void clickNuevoEnvio() {
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
	}

	/*
	selector de mes calendario
	(//th[@colspan='5' and @class='datepicker-switch'])[1]
	*/

	/*

	public void seleccionFechaIda(int diai, int mesi, int anhoi, int diav, int mesv, int anhov, By locator) {
        if (anhoi == (2022)) {
            if (mesi == 11) {
                click((By.xpath(("(//button[@type='button'][normalize-space()='" + diai + "'])[1]"))));
            } else if (mesi == 12) {
                click(locator);
                click((By.xpath(("(//button[@type='button'][normalize-space()='" + diai + "'])[2]"))));
            }
        } else if (anhoi == 2023) {
            int NumeroMes = mesi - 1;
            click(locator);
            for (int i = 0; i < 12; i++) {
                if (NumeroMes == i) {
                    click((By.xpath(("(//button[@type='button'][normalize-space()='" + diai + "'])[2]"))));
                    break;
                } else {
                    click(locator);
                }
            }
        }
        if (mesv == 11 && anhoi == 2022) {
            click((By.xpath(("(//button[@type='button'][normalize-space()='" + diav + "'])[1]"))));
        } else if (mesv == 12 && anhov == 2022) {
            click((By.xpath(("(//button[@type='button'][normalize-space()='" + diav + "'])[2]"))));
        } else if (mesi == mesv) {
            click((By.xpath(("(//button[@type='button'][normalize-space()='" + diav + "'])[2]"))));
        } else {
            click(locator);
            click((By.xpath(("(//button[@type='button'][normalize-space()='" + diav + "'])[2]"))));

        }

    }



	*/
}