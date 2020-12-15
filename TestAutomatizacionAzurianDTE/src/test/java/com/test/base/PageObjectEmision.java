package com.test.base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PageObjectEmision extends Base {

	
	private WebDriver driver;
	 
	By selectorTipoDocumento        =By.xpath("//div[h4[text()='Selección de Tipo de Documento a Emitir:']]/descendant::input[@placeholder='Seleccione...']");
	//------Datos Emisor--
	By selectorActeco               =By.xpath("//td[div/span[text()='EMPRESAS DE ASESORÍA Y CONSULTORÍA EN INVERSIÓN FINANCIERA; SOCIEDADES DE APOYO AL GIRO']]/./preceding-sibling::td/descendant::input");
	//-----Datos Receptor
	By selectorFechaEmision         =By.xpath("//tr[td/div/span[text()='Fecha Emisión']]/child::td[2]/descendant::input[1]");
	By selectorFechaVenc            =By.xpath("//tr[descendant::span[text()='Fecha Vencimiento']]/child::td[4]/descendant::input[1]");
	By selectorRazonSocialRecep     =By.xpath("//td[div/span[text()='Razón Social Receptor']]/following-sibling::td[1]/descendant::input");
	By selectorRutRecep             =By.xpath("//span[text()='RUT Receptor']/../../following-sibling::td[1]/descendant::input[1]");
	By selectorDigVer               =By.xpath("//span[text()='RUT Receptor']/../../following-sibling::td[1]/descendant::input[2]");
	By selectorDireccionRecep       =By.xpath("//td[div/span[text()='Dirección']]/following-sibling::td[1]/descendant::input[1]");
	By selectorComunaRecep          =By.xpath("//td[div/span[text()='Comuna']/..]/following-sibling::td/descendant::input[1]");
	By selectorCiudadRecep          =By.xpath("//td[div/span[text()='Ciudad']]/following-sibling::td[1]/descendant::input[1]");
    By selectorGiroRecep            =By.xpath("//td[div/span[text()='Giro']]/following-sibling::td[1]/descendant::input[1]");
    By selectorCmbFormaPagoRecep    =By.xpath("//td[div/span[text()='Forma Pago']]/following-sibling::td[1]/descendant::input[1]");
    By selectorFormaAceptacionAuto  =By.xpath("//label[text()='Automática']/../input");
    By selectorFormaAceptacionManu  =By.xpath("//label[text()='Manual']/../input");
    By selectorRetenedorChk         =By.xpath("//td[div/span[text()='Es Retenedor']]/following-sibling::td[1]/descendant::input");
    By selector65ContruChk          =By.xpath("//td[div/span[text()='Crédito 65% Constructoras']]/following-sibling::td[1]/descendant::input");
    By selectorAtencionA            =By.xpath("//td[div/span[contains(text(),'Atención A')]]/following-sibling::td/descendant::input");
    By selectorCmbTipoTras          =By.xpath("//td[div/span[text()='Indicador Tipo Traslado']]/following-sibling::td[1]/descendant::input[1]");
    By selectorCmbPaisDest          =By.xpath("//td[div/span[text()='País Destino']]/following-sibling::td[1]/descendant::input");
    By selectorCmbTans              =By.xpath("//td[div/span[text()='Transporte']]/following-sibling::td[1]/descendant::input");
    By selectorCmbPtoEmbarque       =By.xpath("//td[div/span[text()='Puerto Embarque']]/following-sibling::td[1]/descendant::input");
    By selectorCmbPtoDesembarque    =By.xpath("//td[div/span[text()='Puerto Desembarque']]/following-sibling::td[1]/descendant::input");
    By selectorNmbOPtoEmbarque      =By.xpath("//td[div/span[text()='Nombre o Identificacion Medio Transporte']]/following-sibling::td[1]/descendant::input");
    By selectorCmbTpoCtaPago        =By.xpath("//td[div/span[text()='Tipo Cuenta pago']]/following-sibling::td[1]/descendant::input");
    By selectorCtaPago              =By.xpath("//td[div/span[text()='Cuenta de Pago']]/following-sibling::td[1]/descendant::input");
    By selectorBncoPago             =By.xpath("//td[div/span[text()='Banco de Pago']]/following-sibling::td[1]/descendant::input");
    //----Datos Transacción
    By selectorCmbIndicadorServi    =By.xpath("//td[div/span[text()='Indicador de Servicios']]/following-sibling::td[1]/descendant::input");
    By selectorCmbModVenta          =By.xpath("//td[div/span[text()='Modalidas de Venta']]/following-sibling::td[1]/descendant::input");
    By selectorCmbFormPagoAduana    =By.xpath("//td[div/span[text()='Forma de Pago Aduana']]/following-sibling::td[1]/descendant::input");
    By selectorCmbClauVentaExport   =By.xpath("//td[div/span[text()='Clausula de Venta Exportacion']]/following-sibling::td[1]/descendant::input");
    By selectorTotalClauVenExport   =By.xpath("//td[div/span[text()='Total Clausula de Venta Exportacion']]/following-sibling::td[1]/descendant::input");
    By selectorCmbTipoMoneda        =By.xpath("//td[div/span[text()='Tipo Moneda']]/following-sibling::td[1]/descendant::input");
    By selectorCmbUnidadTara        =By.xpath("//td[div/span[text()='Unidad de Medida TARA']]/following-sibling::td[1]/descendant::input");
    By selectorTara                 =By.xpath("//td[div/span[text()='Tara']]/following-sibling::td[1]/descendant::input");
    By selectorTipoCambio           =By.xpath("//td[div/span[text()='Tipo de Cambio']]/following-sibling::td[1]/descendant::input");
    By selectorCmbUPesoBruto        =By.xpath("//td[div/span[text()='Unidad Peso Bruto']]/following-sibling::td[1]/descendant::input");
    By selectorTotalPesoBruto       =By.xpath("//td[div/span[text()='Total Peso Bruto']]/following-sibling::td[1]/descendant::input");
    By selectorCmbUPesoNeto         =By.xpath("//td[div/span[text()='Unidad Peso Neto']]/following-sibling::td[1]/descendant::input");
    By selectorTotalPesoNeto        =By.xpath("//td[div/span[text()='Total Peso Neto']]/following-sibling::td[1]/descendant::input");
    //----Datos Bulto
    By selectorBtnAgrgarBulto      =By.xpath("//a[@title='Agregar Bulto']");
    By selectorCmbTipoBulto        =By.xpath("//td[div/a[@title='Eliminar Bulto']]/preceding-sibling::td[6]/descendant::input");
    By selectorCantidadBulto       =By.xpath("//td[div/a[@title='Eliminar Bulto']]/preceding-sibling::td[5]/descendant::input");
    By selectorMarcaBulto          =By.xpath("//td[div/a[@title='Eliminar Bulto']]/preceding-sibling::td[4]/descendant::input");
    By selectorIdContainer         =By.xpath("//td[div/a[@title='Eliminar Bulto']]/preceding-sibling::td[3]/descendant::input");
    By selectorSelloBulto          =By.xpath("//td[div/a[@title='Eliminar Bulto']]/preceding-sibling::td[2]/descendant::input");
    By selectorEmisorSello         =By.xpath("//td[div/a[@title='Eliminar Bulto']]/preceding-sibling::td[1]/descendant::input");
    By selectorBtnEliminarBulto    =By.xpath("//a[@title='Eliminar Bulto']");
    //----Detalles
    By selectorBtnAgregarDetalleDte =By.xpath("//a[@title='Agregar Detalle']");
    By selectorNumOcDet             =By.xpath("//td[div/span[text()='Num OC']]/following-sibling::td[1]/descendant::input");
    By selectorNumItecOcDet         =By.xpath("//td[div/span[text()='Num Item OC']]/following-sibling::td[1]/descendant::input");
    By selectorCantidadDet          =By.xpath("//td[div/a[@title='Eliminar Detalle']]/preceding-sibling::td[5]/descendant::input"); 
    By selectorDetalleDet           =By.xpath("//td[div/a[@title='Eliminar Detalle']]/preceding-sibling::td[4]/descendant::input");
    By selectorDescripcionDet       =By.xpath("//td[div/a[@title='Eliminar Detalle']]/preceding-sibling::td/descendant::textarea");
    By selectorPrecioDet            =By.xpath("//td[div/a[@title='Eliminar Detalle']]/preceding-sibling::td[2]/descendant::input");
    By selectorCmbTipoDocDet        =By.xpath("//td[div/a[@title='Eliminar Detalle']]/preceding-sibling::td[3]/descendant::input"); 
    By selectorBtnEliminar          =By.xpath("//a[@title='Eliminar Detalle']");
    //-----Golsas
    By selectorSegun                =By.xpath("//td[div/span[text()='Según']]/following-sibling::td[1]/descendant::input");
    //----Descuentos y Recargos
    By selectorBtnAgregarRecargos   =By.xpath("//a[@title='Agregar Descuento/Recargo']");
    By selectorBtnElimDescRecar     =By.xpath("//a[@title='Eliminar Descuento/Recargo']");  
    By selectorCmbTipoMov           =By.xpath("//td[div/a[@title='Eliminar Descuento/Recargo']]/preceding-sibling::td[5]/descendant::input");
    By selectorGlosaDesc            =By.xpath("//td[div/a[@title='Eliminar Descuento/Recargo']]/preceding-sibling::td[4]/descendant::input");
    By selectorCmbTipoValor         =By.xpath("//td[div/a[@title='Eliminar Descuento/Recargo']]/preceding-sibling::td[3]/descendant::input");
    By selectorValorTipoMoneda      =By.xpath("//td[div/a[@title='Eliminar Descuento/Recargo']]/preceding-sibling::td[2]/descendant::input");
    //----Totales
    By selectorIvaTercero           =By.xpath("//td[div/span[text()='IVA Terceros']]/following-sibling::td[1]/descendant::input"); 
    By selectorSon                  =By.xpath("//td[div/span[text()='Son']]/following-sibling::td[1]/descendant::input");
    By selectorTotalBultos          =By.xpath("//td[div/span[text()='Total Bultos']]/following-sibling::td[1]/descendant::input");
    //---Referencias
    By selectorBtnAgregarRef        =By.xpath("//a[text()='Agregar Referencia']");
    By selectorBtnEliminarRef       =By.xpath("//a[@title='Eliminar Referencia']");
    By selectorFechaEmiRef          =By.xpath("//td[div/a[@title='Eliminar Referencia']]/preceding-sibling::td[1]/descendant::input[1]");
    By selectorTipoDocCmbReF        =By.xpath("//td[div/a[@title='Eliminar Referencia']]/preceding-sibling::td[2]/descendant::input[1]");
    By selectorFolioRef             =By.xpath("//td[div/a[@title='Eliminar Referencia']]/preceding-sibling::td[3]/descendant::input[1]");
    //----Comisiones
    By selectorBtnAgregarComi       =By.xpath("//a[text()='Agregar Comisión']");
    By selectorBtnElimiComi         =By.xpath("//a[@title='Eliminar Comisión']");
    By selectorExeComi              =By.xpath("//td[div/a[@title='Eliminar Comisión']]/preceding-sibling::td[1]/descendant::input");
    By selectorNetoComi             =By.xpath("//td[div/a[@title='Eliminar Comisión']]/preceding-sibling::td[3]/descendant::input");
    By selectorGlosaComi            =By.xpath("//td[div/a[@title='Eliminar Comisión']]/preceding-sibling::td[4]/descendant::input");
    By selectorCmbTipoMoviComi      =By.xpath("//td[div/a[@title='Eliminar Comisión']]/preceding-sibling::td[5]/descendant::input");
    //----Botones de accion
    By selectorBtnCrear             =By.xpath("//a[@title='Crear']");
    By selectorBtnLimpiar           =By.xpath("//a[@title='Limpiar']");
    
    
    public PageObjectEmision(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}

