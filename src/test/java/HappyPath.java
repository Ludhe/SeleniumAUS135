/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.*;

/**
 *
 * @author doratt
 */
public class HappyPath {

    private static ChromeDriverService service;
    private WebDriver driver;
    private final static String BASE_URL = "http://186.32.83.35";

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("./chromedriver"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void stopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        driver = new ChromeDriver();
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testAdminHappyPath() throws InterruptedException {
        List<WebElement> elementos;
        boolean creado;
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        Thread.sleep(2000);
        // INICIO DE SESION
        //cambio de logins
        driver.findElement(By.cssSelector("button.cambiarLogin")).click();
        Thread.sleep(2000);
        WebElement nombreUsuario = driver.findElement(By.name("username"));
        WebElement pass = driver.findElement(By.name("password"));
        nombreUsuario.sendKeys("administrador");
        pass.sendKeys("admin");
        Thread.sleep(2000);
        //click iniciar sesion
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div/form/button[1]/span")).click();
        Thread.sleep(2000);
        Assert.assertEquals(BASE_URL + "/", driver.getCurrentUrl());
   
        //GESTION DE ETIQUETAS
        //Click al boton etiquetas
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/a[4]/div")).click();
        Thread.sleep(2000);
        //Click a crear etiquetas
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/button/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("nombre")).sendKeys("Etiqueta Selenium");
        Thread.sleep(2000);
        //Confirmar crear etiqueta
        driver.findElement(By.xpath("//*[@id=\"pr_id_3\"]/div[2]/form/button[1]/span[2]")).click();
        Thread.sleep(2000);
        elementos = driver.findElements(By.tagName("td"));
        creado = false;
        for (WebElement elem : elementos) {
            if (elem.getText().equals("Etiqueta Selenium")) {
                creado = true;
            }
        }
        Assert.assertEquals(true, creado);
        //Eliminar etiqueta
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[1]/table/tbody/tr[5]/td[2]/div/button[2]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pr_id_4\"]/div[2]/button[1]/span[2]")).click();
        Thread.sleep(2000);

        ///GESTION EDITORIALES
        //volver a inicio
        driver.navigate().to(BASE_URL);
        Thread.sleep(2000);
        //Click al boton editoriales
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/a[3]/div")).click();
        Thread.sleep(3000);
        //Click a crear editoriales
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/button/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("nombre")).sendKeys("Editorial Selenium");
        Thread.sleep(3000);
        //Confirmar crear editorial
        driver.findElement(By.xpath("//*[@id=\"pr_id_3\"]/div[2]/form/button[1]/span[2]")).click();
        Thread.sleep(3000);
        elementos = driver.findElements(By.tagName("td"));
        creado = false;
        for (WebElement elem : elementos) {
            if (elem.getText().equals("Editorial Selenium")) {
                creado = true;
            }
        }
        Assert.assertEquals(true, creado);
        //Eliminar editorial
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[1]/table/tbody/tr[7]/td[2]/div/button[2]/span[1]")).click();
        Thread.sleep(3000);
        //confirmar borrar
        driver.findElement(By.xpath("//*[@id=\"pr_id_4\"]/div[2]/button[1]/span[2]")).click();
        Thread.sleep(3000);

        ///GESTION AUTORES
        //volver a inicio
        driver.navigate().to(BASE_URL);
        Thread.sleep(2000);
        //Click al boton autores
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/a[2]/div")).click();
        Thread.sleep(2000);
        //Click a crear autores
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/button/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("nombre")).sendKeys("Autor");
        driver.findElement(By.name("apellido")).sendKeys("Selenium");
        Thread.sleep(2000);
        //Confirmar crear autor
        driver.findElement(By.xpath("//*[@id=\"pr_id_3\"]/div[2]/form/button[1]/span[2]")).click();
        Thread.sleep(2000);
        //Eliminar autor
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[1]/table/tbody/tr[10]/td[3]/div/button[2]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pr_id_4\"]/div[2]/button[1]/span[2]")).click();
        Thread.sleep(2000);
         
        //GESTION DE LIBROS
        //volver a inicio
        driver.navigate().to(BASE_URL);
        Thread.sleep(2000);
        //click en libros
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div[1]/a[1]/div")).click();
        Thread.sleep(2000);
        //click en crear libros
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/form/button[3]/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pr_id_5\"]/div[2]/form/div[1]/input")).sendKeys("Libro Selenium");
        //Desplegar autores
        driver.findElement(By.xpath("//*[@id=\"pr_id_5\"]/div[2]/form/div[2]/div[1]/span/ul/li/input")).sendKeys("Gabriel");
        Thread.sleep(3000);
        //Seleccionar autor
        //driver.findElement(By.xpath("//*[@id=\"pr_id_3\"]/div[2]/form/div[2]/div[1]/span/div/ul/li")).click();
        driver.findElement(By.cssSelector("li.p-autocomplete-list-item")).click();
        Thread.sleep(2000);
        //Desplegar editoriales
        driver.findElement(By.xpath("//*[@id=\"pr_id_5\"]/div[2]/form/div[3]/div[1]/span/input")).sendKeys("Pear");
        Thread.sleep(2000);
        //Seleccionar editorial
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/form/div[3]/div[1]/span/div/ul/li")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("edicion")).sendKeys("10ma");
        //Desplegar categorias
        driver.findElement(By.xpath("//*[@id=\"pr_id_5\"]/div[2]/form/div[7]/div[1]/button/span")).click();
        Thread.sleep(3000);
        //Seleccionar categoria
        driver.findElement(By.xpath("//*[@id=\"pr_id_8\"]/div[2]/div/div/table/tbody/tr[1]/td[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("tejueloMayusculas")).sendKeys("GAR");
        driver.findElement(By.name("tejueloMinusculas")).sendKeys("lib");
        driver.findElement(By.name("estante")).sendKeys("4a");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/form/button[1]/span[2]")).click();
        Thread.sleep(2000);
    }
    
    @Test
    public void testNormalUserHappyPath() throws InterruptedException{
        driver.get(BASE_URL);
        Thread.sleep(2000);
        driver.findElement(By.name("nombre")).sendKeys("Selenium Automated");
        driver.findElement(By.name("apellido")).sendKeys("Test");
        Thread.sleep(1000);
        //Desplegar grados
        driver.findElement(By.xpath("//html/body/div/div/div[4]/div/div[2]/form/div[4]/div[1]/label")).click();
        Thread.sleep(2000);
        //Seleccionar grado
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/form/div[4]/div[1]/div[4]/div/ul/li[3]")).click();
        Thread.sleep(2000);
        //Iniciar sesion
        driver.findElement(By.xpath("/html/body/div/div/div[4]/div/div[2]/form/button[1]/span")).click();
        Thread.sleep(3000);
        //Click en usar libros
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("titulo")).sendKeys("Selenium");
        Thread.sleep(1000);
        //Click en buscar
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/form/button[1]/span[1]")).click();
        Thread.sleep(2000);
        //Click a usar en la tabla
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div[1]/div[1]/table/tbody/tr/td[5]/div/button/span[2]")).click();
        Thread.sleep(2000);
        //Click a usar
        driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[2]/div/div[2]/button")).click();
        Thread.sleep(2000);
    }   
}
