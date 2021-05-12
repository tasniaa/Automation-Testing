package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class searchElement {

    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor jse;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {

        //System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        baseUrl = "http://staging.amujamu.com";
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        jse = (JavascriptExecutor) driver;
        // Maximize the browser's window
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void test1_validLoginTest() throws Exception {

        WebElement loginLink = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a"));
        loginLink.click();


        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("mahajabintorosha@gmail.com");


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("123456");


        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input"));
        loginButton.click();

    }

    @Test
    public void test2booking() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"vue\"]/div/div[3]/div/div/div[1]/div[1]/div/a")).sendKeys(Keys.ENTER);
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"feature_tour_div\"]"));
        Assert.assertTrue(list.size() > 0, "Text not found!");

        driver.findElement(By.id("search_input_txt")).sendKeys("Jungle trek");

        driver.findElement(By.id("search_input_txt_button")).click();
        Thread.sleep(2000);
        String parentWinHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"search_results\"]/li[1]/div/div[2]/div/div[1]/a/p")).click();
    }
}
