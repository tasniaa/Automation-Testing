package amujamuSiteTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class PopularDestinationDragAndDrop {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        baseUrl = "http://staging.amujamu.com";

        driver = new FirefoxDriver();

        System.setProperty("webdriver.gecko.driver", "D:\\selenium_java\\geckodriver");

        // Maximize the browser's window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.get(baseUrl);
    }

    @Test
    public void testDragAndDrop() throws Exception {
        driver.get(baseUrl);
        Thread.sleep(2000);

        WebElement loginLink = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a"));

        loginLink.click();

        //email textbox

        WebElement emailField = driver.findElement(By.id("email"));

        emailField.sendKeys("admin@admin.com");

        //password textbox

        WebElement passwordField = driver.findElement(By.id("password"));

        passwordField.sendKeys("1234");

        //loginbutton

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input"));

        loginButton.click();

        //loaction page link

        String childurl = "http://staging.amujamu.com/admin/popular-destination";

        driver.get(childurl);

        WebElement fromElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[3]/div/ul/li[4]"));

        //destination 8

        WebElement toElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[3]/div/ul/li[8]"));

        Actions action = new Actions(driver);

        // Click and hold, move to element, release, build and perform

        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();

        //update popular destination
        Thread.sleep(20000);

        //WebElement update = driver.findElement(By.id("updateOrder"));
        //update.click();
        //ok button
       // driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button"));
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit();
    }

}
