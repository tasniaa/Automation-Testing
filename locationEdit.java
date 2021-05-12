package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class locationEdit {
    WebDriver driver;
    String baseURL;
    JavascriptExecutor jse;
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }
    @Parameters({"browser"})
    @BeforeClass

    public void beforeClass() {
        baseURL = "http://staging.amujamu.com";

        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "D:\\selenium_java\\geckodriver");

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

        //location page link

        String childurl="http://staging.amujamu.com/admin/location";
        driver.get(childurl);

        //location create button

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[8]/div/a[1]/i")).click();


        //publish on

        //WebElement publish = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[1]/div[3]/div/div[12]/div[2]/span/label/span"));
        //publish.click();

        //media upload

        driver.findElement(By.id("media")).sendKeys("D:\\Sakhon_Nakhon.jpg");

        //update button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[2]/div/div[2]/button")).click();

        //cancel button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[2]/div/div[1]/a")).click();

        //check after unpublish show destination in popupal destination or not

      // String childurl2 = "http://staging.amujamu.com/admin/popular-destination";

      //  driver.get(childurl2);




    }
    @AfterClass
    public void afterClass() {
        //driver.quit();

    }
}
