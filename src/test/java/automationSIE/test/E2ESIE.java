package automationSIE.test;

import automationSIE.pages.PageSIE;
import framework.engine.selenium.SeleniumTestBase;
import org.testng.annotations.Test;

public class E2ESIE extends SeleniumTestBase {
    private PageSIE pageSIE;

    @Test
    public void E2E() throws InterruptedException {
        pageSIE = new PageSIE(driver);
        pageSIE.ingresar();
        pageSIE.login();
        pageSIE.datosRemitente();
        pageSIE.datosDestinatario();
        pageSIE.writeTextBox();
        pageSIE.seleccionarYpagar();
        pageSIE.comprobarPago();
        pageSIE.cerrarSesion();
    }
}
