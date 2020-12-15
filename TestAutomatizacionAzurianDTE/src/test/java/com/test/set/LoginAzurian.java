package com.test.set;



import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAzurian {
	
	
	private WebDriver driver;
	By LocalizadorUser = By.xpath("//input[@tabindex=\"1\"]");
	By LocalizadorPass = By.xpath("//input[@tabindex=\"2\"]");
	By localizadorEntar = By.xpath("//a[@tabindex=\"3\"]");
	By localizarSesionOk = By.xpath("//span[text()='Cerrar Sesión ']");


	@Before
	public void setUp() throws Exception {
	
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/ChromeDriver 86.0.4240.22.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.6.75:8080/dte-web/login.zul;jsessionid=93BB5CF44E0658814837F2CA6B04176C");
	}
	

	@After
	public void tearDown() throws Exception {
	
	driver.quit();
	}
	
	

	@Test
	public void LoginTest() throws Exception {
		
	

		driver.findElement(LocalizadorUser).sendKeys("QA");
		driver.findElement(LocalizadorPass).sendKeys("QAzur2020#");
		driver.findElement(localizadorEntar).click();
		Thread.sleep(3000);
		assertTrue(driver.findElement(localizarSesionOk).isDisplayed());
	}
	
	

}
