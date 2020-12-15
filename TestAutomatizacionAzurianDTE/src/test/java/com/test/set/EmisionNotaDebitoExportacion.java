package com.test.set;

//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmisionNotaDebitoExportacion {
	//Varibles
    String user="QA";
    String pass="QAzur2020#";
    String tipoDoc="Nota de Débito Electrónica de Exportación";
	String nombreEmpresa="GPS Tecnología Limitada";
	String nomReceptor="Aserradora palitos pal puente";
	String direccionRecep="Los Militares 4777";
	String comunaRecep ="Las Condes";
	String ciudadRecep="Santiago";
	String giro="Tecnologia";
	String atencionA="SR";
	String formaPago="Contado";
	String fechaEmi="26-10-2020";
	String fechaVen="30-11-2020";
	String cantidad="1";
	String descripcion="Consultoria";
	String detalle="Planificación de Pruebas Automatizadas";
	String precio="2500";
	String rutEmisor;
	String numeroFolio;
	String typeDoc;
	
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
	
	By LocalizadorselectorActeco = By.xpath("//input[@type='checkbox']");
	By LocalizadorModEmpresaRecep=By.xpath("//input[@class='z-textbox' and @maxlength='100']");
	
	By LocalizadorModDireccionRecep = By.xpath("//input[@class='z-textbox' and @maxlength='60']");
	By LocalizadorModCiudad= By.xpath("//input[@class='z-textbox' and @maxlength='15']");
	By LocalizadorAtenciónA = By.xpath("//input[@class='z-textbox' and @maxlength='80']");
	By LocalizadorModForAceptacion =By.xpath("//input[@type='radio' and @value='A']");
	By LocalizadorModBotonDetalle= By.xpath("//a[@title='Agregar Detalle']");

	//
	By LocalizadorModCantidadDetalle =By.xpath("//td[1]/div/input[@class='z-decimalbox' and @maxlength='19']");
	By LocalizadorModDescripDetalle = By.xpath("//textarea[@class='z-textbox']");	
	By LocalizadorModDetalle =By.xpath("//tr[1]/td[2]/div[@class='z-row-content']/input[@class='z-textbox' and @maxlength='80']");
	By LocalizadorModPrecioDetalle =By.xpath("//input[@class='z-decimalbox' and @size='11' and @maxlength='12']");
	
	By LocalizadorModBotonCrear =By.xpath ("//a[@title='Crear']");
	By LocalizadorBuscMod = By.xpath("//h4[@class='titulotable']");
	
	
	
	 By LocalizadorTotalClausuladeVentaExportacion= By.xpath("//input[@class='z-decimalbox' and @maxlength='19' ]");
	 By LocalizadorTara = By.xpath("//input[@class='z-decimalbox' and @maxlength='7' ]");



	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/ChromeDriver 86.0.4240.22.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.6.75:8080/dte-web/portada.zul");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testEmisionNotaDebitoExportacion() throws InterruptedException {
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
						java.util.List<WebElement> acteco = driver.findElements(By.xpath("//span[@class='z-checkbox']/input[@type='checkbox']"));
						acteco.get(1).click();
						//
						driver.findElement(LocalizadoriconoActeco).click();
						driver.findElement(LocalizadorModEmpresaRecep).sendKeys(nomReceptor);
						driver.findElement(LocalizadorModDireccionRecep).sendKeys(direccionRecep);
						
						java.util.List<WebElement> ListaRecep = driver.findElements(By.xpath("//input[@class='z-textbox' and @maxlength='20']")); 
						ListaRecep.get(0).sendKeys(comunaRecep);
						ListaRecep.get(1).sendKeys("1234567890");
						ListaRecep.get(2).sendKeys("Banco de Chile");
						driver.findElement(LocalizadorModCiudad).sendKeys(ciudadRecep);
						driver.findElement(LocalizadorAtenciónA).sendKeys(atencionA);
						java.util.List<WebElement> ListaRecep2 = driver.findElements(By.xpath("//input[@class='z-textbox' and @maxlength='40']"));
						ListaRecep2.get(0).sendKeys(giro);
						ListaRecep2.get(1).sendKeys("Medio Transporte");
						java.util.List<WebElement> Lista1 = driver.findElements(By.xpath("//span[@class='z-label']"));  
						rutEmisor= Lista1.get(5).getText();
						driver.findElement(LocalizadorModForAceptacion).click();
						//Deshabilitar Propiedad ReadOnly de las fechas 
						EmisionFacturaExenta.changeReadonly(driver);
						//Ingreso de fechas de emision y vencimiento
						java.util.List<WebElement> ListaFecha = driver.findElements(By.xpath("//input[@class='z-datebox-input' ]"));
						ListaFecha.get(0);
						
						if(ListaFecha.get(0).isDisplayed()) {
							ListaFecha.get(0).clear();
							ListaFecha.get(0).click();
							ListaFecha.get(0).sendKeys(fechaEmi);
						}else {
							System.out.println("Localizador no encontrado en Fecha Emision");
						}
						if(ListaFecha.get(1).isDisplayed()) {
							ListaFecha.get(1).clear();
							ListaFecha.get(1).click();
							ListaFecha.get(1).sendKeys(fechaVen);					
						}else{					
							System.out.println("Localizador no encontrado en Fecha Vencimiento");	
						}
						
						java.util.List<WebElement> ListaCombo = driver.findElements(By.xpath("//div/span/input[@class='z-combobox-input']"));
						ListaCombo.get(1).sendKeys(Keys.ENTER);
						ListaCombo.get(1).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(2).sendKeys(Keys.ENTER);
						ListaCombo.get(2).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(3).sendKeys(Keys.ENTER);
						ListaCombo.get(3).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(4).sendKeys(Keys.ENTER);
						ListaCombo.get(4).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(5).sendKeys(Keys.ENTER);
						ListaCombo.get(5).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(5).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(6).sendKeys(Keys.ENTER);
						ListaCombo.get(6).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(6).sendKeys(Keys.ARROW_DOWN);
						//Fin de Ingreso de Fechas
						
						//LLenado  de datos de Transaccion
						ListaCombo.get(7).sendKeys(Keys.ENTER);
						ListaCombo.get(7).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(8).sendKeys(Keys.ENTER);
						ListaCombo.get(8).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(9).sendKeys(Keys.ENTER);
						ListaCombo.get(9).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(10).sendKeys(Keys.ENTER);
						ListaCombo.get(10).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(11).sendKeys(Keys.ENTER);
						ListaCombo.get(11).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(12).sendKeys(Keys.ENTER);
						ListaCombo.get(12).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(13).sendKeys(Keys.ENTER);
						ListaCombo.get(13).sendKeys(Keys.ARROW_DOWN);
						ListaCombo.get(14).sendKeys(Keys.ENTER);
						ListaCombo.get(14).sendKeys(Keys.ARROW_DOWN);
						
						java.util.List<WebElement> ListaTransaccion = driver.findElements(By.xpath("//input[@class='z-decimalbox' and @maxlength='11' ]"));
						driver.findElement(LocalizadorTotalClausuladeVentaExportacion).sendKeys("10");
						driver.findElement(LocalizadorTara).sendKeys("10");
						ListaTransaccion.get(0).sendKeys("750"); //TipoCambio
						ListaTransaccion.get(1).sendKeys("10");//PesoBruto
						ListaTransaccion.get(2).sendKeys("10");//PesoNeto
						
						
						
						
						
						
						//Fin Llenado de datos de Transaccion
						driver.findElement(LocalizadorModBotonDetalle).click();
						driver.findElement(LocalizadorModCantidadDetalle).sendKeys(cantidad);
						driver.findElement(LocalizadorModDescripDetalle).sendKeys(descripcion);
						driver.findElement(LocalizadorModDetalle).sendKeys(detalle);
						
						if(driver.findElement(By.xpath("//td/div/input[@class='z-decimalbox z-decimalbox-invalid' and @maxlength='19']")).isDisplayed()){
							driver.findElement(By.xpath("//td/div/input[@class='z-decimalbox z-decimalbox-invalid' and @maxlength='19']")).click();
							driver.findElement(By.xpath("//td/div/input[@class='z-decimalbox z-decimalbox-invalid' and @maxlength='19']")).sendKeys(precio);
							
							
						}else {
							driver.findElement(LocalizadorModPrecioDetalle).click();
							driver.findElement(LocalizadorModPrecioDetalle).sendKeys(precio);
						}
						
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
						case "Liquidación - Factura":
							typeDoc = "43";
							break;
						case "Guia Despacho":
							typeDoc = "52";
							break;
						case "Boleta":
							typeDoc="39";
							break;
						case "Factura de Exportación":
							typeDoc="110";
							break;
						case "Nota de Débito de Exportación":
							typeDoc="111";
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
