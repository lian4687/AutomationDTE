package com.test.set;



import java.util.concurrent.TimeUnit;

//import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmisionGuiaDespacho {
 //Variables
		String user="QA";
	    String pass="QAzur2020#";
	    String tipoDoc="Guía de Despacho Electrónica";
		String nombreEmpresa="GPS Tecnología Limitada";
		String nomReceptor="Azurian Tecnologia";
		String rutRecep="96913280";
		String digitoVerRecep= "K";
		String direccionRecep="Los Militares 4777";
		String comunaRecep ="Las Condes";
		String ciudadRecep="Santiago";
		String giro="Tecnologia";
		String atencionA="SR";
		String formaPago="Contado";
		String fechaEmi="30-11-2020";
		String fechaVen="30-12-2020";
		String cantidad="1";
		String descripcion="Descripcion";
		String detalle="Consultoria";
		String precio="2500";
		String rutEmisor;
		String numeroFolio;
		String typeDoc;
		String tipoTraslado="Entrega Gratuita";
		
		private WebDriver driver;
		//LocalizadorLogin
		By LocalizadorUser = By.xpath("//input[@tabindex='1']");
		By LocalizadorPass = By.xpath("//input[@tabindex='2']");
		By localizadorEntar = By.xpath("//a[@tabindex='3']");
		By localizarSesionOk = By.xpath("//span[text()='Cerrar Sesión ']");
		//Selectores de Empresa y ambiente
		By Localizadorempresa = By.xpath("//input[@class='z-combobox-input' and @tabindex='95']");
		By Localizadorambiente= By.xpath("//input[@class='z-combobox-input' and @tabindex='96']");
		//Modulo
		By LocalizadormoduloEmision= By.partialLinkText("Emisión");
		By LocalizadorsubModuloEmisionDTE = By.partialLinkText("Emisor DTE");
		By Localizadortitulo = By.xpath("//h3[@class='titulotable']");
		By LocalizadorcomboSelectDocumentoEmi = By.xpath("//input[@class='z-combobox-input' and @tabindex='1' ]");
		By LocalizadorsubTituloModulo = By.xpath("//h4[@class='titulotable'][text()='Datos Emisor']");
		By LocalizadoriconoActeco = By.xpath("//i[@class='z-bandbox-icon z-icon-search']");
		//

		//
		By LocalizadorselectorActeco = By.xpath("//input[@type='checkbox']");
		By LocalizadorModEmpresaRecep=By.xpath("//input[@class='z-textbox' and @tabindex='3']");
		By LocalizardorModRutRecep=By.xpath("//input[@class='z-intbox' and @tabindex='4']");
		By LocalizadorModDig=By.xpath("//input[@class='z-textbox' and @tabindex='5']");
		By LocalizadorModDireccionRecep = By.xpath("//input[@class='z-textbox' and @tabindex='6']");
		By LocalizadorModComunaRecep = By.xpath("//input[@class='z-textbox' and @tabindex='7']");
		By LocalizadorModCiudad= By.xpath("//input[@class='z-textbox' and @tabindex='8']");
		By LocalizadorModGiro = By.xpath("//input[@class='z-textbox' and @tabindex='9']");
		By LocalizadorAtenciónA = By.xpath("//input[@class='z-textbox' and @tabindex='15']");
		By LocalizadorModFormaPago = By.xpath("//input[@class='z-combobox-input' and  @tabindex='10']");
		By LocalizadorModForAceptacion =By.xpath("//input[@type='radio' and @value='A']");
		By LocalizadorModBotonDetalle= By.xpath("//a[@title='Agregar Detalle']");
		By LocalizadorModCalendarEmi = By.xpath("//input[@class='z-datebox-input' and @tabindex='1']");
		By LocalizadorModCalendarVen = By.xpath("//input[@class='z-datebox-input' and @tabindex='2']");
		
		By LocalizadorModCalendarVenInvalid =  By.xpath("//input[@class='z-datebox-input z-datebox-invalid' and @tabindex='2']");
		By LocalizadorModCalendarEmiInvalid= By.xpath("//input[@class='z-datebox-input z-datebox-invalid' and @tabindex='1']");
		
		//
		By LocalizadorModCantidadDetalle =By.xpath("//div/input[@class='z-decimalbox' and @maxlength='18' and @value!=0]");
		By LocalizadorModDescripDetalle = By.xpath("//textarea[@class='z-textbox']");	
		By LocalizadorModDetalle =By.xpath("//td[2]/div[@class='z-row-content']/input[@class='z-textbox' and @maxlength='80' ]");
		By LocalizadorModPrecioDetalle =By.xpath("//input[@class='z-decimalbox' and @size='11' and @maxlength='12']");
		
		By LocalizadorModBotonCrear =By.xpath ("//a[@title='Crear']");
		By LocalizadorBuscMod = By.xpath("//h4[@class='titulotable']");
		By LocalizadorTipoTraslado= By.xpath("//span/input[@class='z-combobox-input' and @tabindex=12]");
		
		
		By LocalizadorBuscModRecep = By.xpath("//h4[@class='titulotable'][text()='Datos Receptor']");

		
		//
		
		
		

		
		
		
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver_76.0.3809.126.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.6.75:8080/dte-web/portada.zul");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testEmisionGuia() throws InterruptedException {
		//Login
		driver.findElement(LocalizadorUser).sendKeys(user);
		driver.findElement(LocalizadorPass).sendKeys(pass);
		driver.findElement(localizadorEntar).click();
		//LoginFin
		
		//Seleccion de Empresa
		driver.findElement(Localizadorempresa).clear();
		driver.findElement(Localizadorempresa).sendKeys(nombreEmpresa);
		driver.findElement(Localizadorempresa).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(Localizadorempresa).sendKeys(Keys.ENTER);
		//Seleccion de EmpresaFin
		driver.findElement(LocalizadormoduloEmision).click();
		driver.findElement(LocalizadorsubModuloEmisionDTE).click();
		// Si el modulo de Emision esta desplegadp
		if(driver.findElement(Localizadortitulo).isDisplayed()) {
			driver.findElement(LocalizadorcomboSelectDocumentoEmi).clear();
			driver.findElement(LocalizadorcomboSelectDocumentoEmi).sendKeys(tipoDoc);
			driver.findElement(LocalizadorcomboSelectDocumentoEmi).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(LocalizadorcomboSelectDocumentoEmi).sendKeys(Keys.ENTER);
			// Si el Formulario del modulo fue desplegado 
			if(driver.findElement(LocalizadorsubTituloModulo).isDisplayed()) {
				//Llenado FormularioEmision
				driver.findElement(LocalizadoriconoActeco).click();
				//Localizador acteco
				java.util.List<WebElement> check = driver.findElements(By.xpath("//span[@class='z-checkbox']/input[@type='checkbox']"));
				check.get(3).click();
				//
				driver.findElement(LocalizadoriconoActeco).click();
				driver.findElement(LocalizadorModEmpresaRecep).sendKeys(nomReceptor);
				driver.findElement(LocalizardorModRutRecep).sendKeys(rutRecep);
				driver.findElement(LocalizadorModDig).sendKeys(digitoVerRecep);
				driver.findElement(LocalizadorModDireccionRecep).sendKeys(direccionRecep);
				driver.findElement(LocalizadorModComunaRecep).sendKeys(comunaRecep);
				driver.findElement(LocalizadorModCiudad).sendKeys(ciudadRecep);
				driver.findElement(LocalizadorAtenciónA).sendKeys(atencionA);
				driver.findElement(LocalizadorModGiro).sendKeys(giro);
				driver.findElement(LocalizadorModFormaPago).sendKeys(formaPago);
				//driver.findElement(LocalizadorModFormaPago).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(LocalizadorModFormaPago).sendKeys(Keys.ENTER);
				driver.findElement(LocalizadorTipoTraslado).sendKeys(tipoTraslado);
				driver.findElement(LocalizadorTipoTraslado).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(LocalizadorTipoTraslado).sendKeys(Keys.ENTER);
				
				//Obtengo Rut Emisor
				java.util.List<WebElement> Lista1 = driver.findElements(By.xpath("//span[@class='z-label']"));  
				rutEmisor= Lista1.get(5).getText();
				
				if(driver.findElement(LocalizadorBuscModRecep).isDisplayed()) {
					
				//Deshabilitar Propiedad ReadOnly de las fechas 
				EmisionFacturaExenta.changeReadonly(driver);
				//Ingreso de fechas de emision y vencimiento
				if(driver.findElement(LocalizadorModCalendarEmi).isDisplayed()) {
					driver.findElement(LocalizadorModCalendarEmi).sendKeys(fechaEmi);
				}else {
					driver.findElement(LocalizadorModCalendarEmiInvalid).click();
					driver.findElement(LocalizadorModCalendarEmiInvalid).sendKeys(fechaEmi);
					
				}
				if(driver.findElement(LocalizadorModCalendarVen).isDisplayed()) {
					driver.findElement(LocalizadorModCalendarVen).clear();
					driver.findElement(LocalizadorModCalendarVen).click();
					driver.findElement(LocalizadorModCalendarVen).sendKeys(fechaVen);	
					
				}else{					
					driver.findElement(LocalizadorModCalendarVenInvalid).click();
					driver.findElement(LocalizadorModCalendarVenInvalid).sendKeys(fechaVen);
				}
				//Fin de Ingreso de Fechas
				}else {
					System.out.println("Elemento datos receptor no cargado");
				}
				
				//
				driver.findElement(LocalizadorModBotonDetalle).click();
				driver.findElement(LocalizadorModCantidadDetalle).sendKeys(cantidad);
				driver.findElement(LocalizadorModDetalle).click();
				Thread.sleep(2000);
				driver.findElement(LocalizadorModDetalle).clear();
				driver.findElement(LocalizadorModDetalle).sendKeys(detalle);
				driver.findElement(LocalizadorModPrecioDetalle).sendKeys(precio);
				driver.findElement(LocalizadorModDescripDetalle).click();
				Thread.sleep(2000);
				driver.findElement(LocalizadorModDescripDetalle).clear();
				driver.findElement(LocalizadorModDescripDetalle).sendKeys(descripcion);
				Thread.sleep(3000);
				driver.findElement(LocalizadorModForAceptacion).click();
				driver.findElement(LocalizadorModBotonCrear).click();
				Thread.sleep(5000);
				if (driver.findElement(LocalizadorBuscMod).isDisplayed()) {
				//Verificaicon de Folio
				
				numeroFolio = driver.findElement(By.xpath(
						"//div[@class='dataTables_wrapper form-inline z-div']/div[@class='az-grid paginacion z-grid']/div[@class='z-grid-body']/table/tbody/tr[1]/td[5]/div/span"))
						.getText();
				
			
                java.util.List<WebElement> Lista2 = driver.findElements(By.xpath("//td/div/span[@class='z-label']"));  
				
				String L = Lista2.get(64).getText();
				
				switch(L) {
				case "Factura No Afecta o Exenta":
					typeDoc = "34";
					break;
				case "Factura":
					typeDoc = "33";
					break;
				case "Guía de Despacho":
					typeDoc = "52";
					break;
				case "Nota de Crédito Electrónica":
					typeDoc = "61";
					break;
				default :
					System.out.println("no encontre el tipo de doc, la varible es L es " + L );

				}
				//Fin Verificacion Folio
				
				//JOptionPane.showMessageDialog(null, "En el output de la consola se encutra la Query para buscar en BD el docuemtno emitido");
				System.out.println("select * from public.dte_documento where rut_empresa=" + rutEmisor + " and id_tipo_documento="+ typeDoc +" and numero_folio=" + numeroFolio);
				}else {
					System.out.println("Busqueda de Documentos no desplegada");
				}
			}else {
				System.out.println("Formulario Emision Manual no desplegado");
			}
		
		}else {
			System.out.println("Modulo Emision Manual no desplegado");					
		}
		
	
		
	}
	
	//Eliminacion de la propiedad Solo lectura de las fechas
	public static void changeReadonly(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("var cls = document.getElementsByClassName('z-datebox-input');\r\n" + "\r\n"
				+ "for(var i = 0; i < cls.length; i++) {\r\n" + "   cls[i].removeAttribute('readonly');\r\n" + "}");

	}
		
	}


