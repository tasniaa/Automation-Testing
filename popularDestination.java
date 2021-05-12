package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class popularDestination {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor jse;

    @BeforeClass
    public void beforeClass() {
        baseURL = "http://staging.amujamu.com";

        driver = new FirefoxDriver();

        System.setProperty("webdriver.gecko.driver", "D:\\selenium_java\\geckodriver");

        jse = (JavascriptExecutor)driver;

        // Maximize the browser's window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        //login menu

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

        //Add/remove popular destination button

        WebElement createButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/a"));
        createButton.click();

        //scroll

        jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);

        //popular destination location textbox click

        WebElement location = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[1]/div[2]/span/span[1]/span/ul"));

        Actions action = new Actions(driver);
        action.moveToElement(location).perform();
        Thread.sleep(2000);

        //remove popular destination

        WebElement removeicon = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[1]/div[2]/span/span[1]/span/ul/li[2]/span"));
        action.moveToElement(removeicon).click().perform();

        Thread.sleep(2000);


        //Add popular destination

       // WebElement addElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[1]/div[2]/select/option[5]"));
        //action.moveToElement(addElement).click().perform();

        //Thread.sleep(2000);

       WebElement element = driver.findElement(By.id("location_id"));

       Select sel = new Select(element);

        //scroll
        //jse.executeScript("arguments[0].scrollIntoView(true);", element);
       // Thread.sleep(2000);
      //  jse.executeScript("window.scrollBy(0, -190);");
        //add Bangkok in popular destination
       sel.selectByValue("27");


      //  Thread.sleep(2000);
        //create button

      //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[2]/div/div[2]/input")).click();

        //cancel

        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[2]/div/div[1]/a")).click();

    }
}
