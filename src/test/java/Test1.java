import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {


    @Test
    public void searchGoogle(){

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement inputBusqueda = driver.findElement(By.name("q")); //inspecciono y busco el name la caja de busqueda
        inputBusqueda.sendKeys("selenium"); //aca lo que hago es escribir dentro del cuadro

        inputBusqueda.submit();

       //|

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebDriverWait esperar = new WebDriverWait(driver,5); // le digo que espere 5 segundos

        // id="resultStats"  inspecciono y chequeo el id de "cerca de 4545.545.544 de resultados (0,33 segu)

        esperar.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));

        //inspeccion, ctrl+f y busco title

        Assert.assertEquals(driver.getTitle(),"selenium - Buscar con Google");  //comparo el titulo
        //Assert.assertEquals(driver.getTitle(),"selenium - Buscar con Google","el titulo no coincide con el esperado");



        List<WebElement> resultados = driver.findElements(By.className("rc")); //inspecciono y busco el primer elemento
        Assert.assertTrue(resultados.size() > 0, "falla porque no devuelve resultados la busqueda"); //testeo que me devuelve al menos un resultado

        driver.quit();

    }



    @Test
    public void searchonFirefox(){

        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        WebElement inputBusqueda = driver.findElement(By.name("q")); //inspecciono y busco el name la caja de busqueda
        inputBusqueda.sendKeys("selenium"); //aca lo que hago es escribir dentro del cuadro

        inputBusqueda.submit();

        // WebElement btnBuscar = driver.findElement(By.name("btnK")); //inspecciono y busco el name del boton buscar
        // btnBuscar.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //inspeccion, ctrl+f y busco title

        WebDriverWait esperar = new WebDriverWait(driver,5); // le digo que espere 5 segundos

        // id="resultStats"  inspecciono y chequeo el id de "cerca de 4545.545.544 de resultados (0,33 segu)

        esperar.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));

        Assert.assertEquals(driver.getTitle(),"selenium - Buscar con Google");  //comparo el titulo
        //Assert.assertEquals(driver.getTitle(),"selenium - Buscar con Google","el titulo no coincide con el esperado");



        List<WebElement> resultados = driver.findElements(By.className("rc")); //inspecciono y busco el primer elemento
        Assert.assertTrue(resultados.size() > 0, "falla porque no devuelve resultados la busqueda"); //testeo que me devuelve al menos un resultado

        driver.quit();

    }





    }
