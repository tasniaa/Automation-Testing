package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class locationCreate {
    WebDriver driver;
    String baseURL;
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }
    @Parameters({"browser"})
    @BeforeClass

    public void beforeClass() {
        baseURL = "http://staging.amujamu.com";

        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "D:\\selenium_java\\geckodriver");

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

        String childurl="http://staging.amujamu.com/admin/location";

        driver.get(childurl);

        //location create button

        WebElement createButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/a"));
        createButton.click();

        //country select

        driver.findElement(By.id("country_id")).click();

        //dropdown element select

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]/div/div[2]/div[2]/select/option[3]")).click();

        //location name

        WebElement location = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]/div/div[3]/div[2]/input"));
        location.sendKeys("Koh Samui");

        //parent location

        Select sel = new Select(driver.findElement(By.id("parent_location")));
        sel.selectByValue("14");

        //Location description
        driver.findElement(By.id("description")).sendKeys("Ko Samui  is an island and city  off the east coast of the Kra Isthmus Thailand. Geographically in the Chumphon Archipelago, it is part of Surat Thani Province.");

        //dropdown element select

        //driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Bangkok (Krung Thep Maha Nakhon)");

        //timezone

        driver.findElement(By.id("select2-timezone-container")).click();

        //dropdown element select

        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("-11:00 (Pacific/Midway)");

        //image upload

        //driver.findElement(By.id("media")).click();

        driver.findElement(By.id("media")).sendKeys("C:\\Users\\hp\\Downloads\\koh_samui.jpg");

        //latitude
        driver.findElement(By.id("latitude")).sendKeys("9.53567");

        //longitude
        driver.findElement(By.id("longitude")).sendKeys("99.93567");

        //is publish
        driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[12]/div[2]/span/label/span")).click();


        //create button

       driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[2]/div/div[2]/input")).click();



    }
    @AfterClass
    public void afterClass() {
        //driver.quit();

    }

}
