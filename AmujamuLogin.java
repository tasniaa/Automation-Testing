package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AmujamuLogin {
    private WebDriver driver;
    private String baseUrl;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        baseUrl = "http://staging.amujamu.com";
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void test1_validLoginTest() throws Exception {
        WebElement search = driver.findElement(By.id("search_input_txt"));
        search.click();

        WebElement loginLink = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a"));
        loginLink.click();



        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("admin@admin.com");


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("1234");


        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input"));
        loginButton.click();


    }

    @AfterClass
    public void afterClass() {
        //driver.quit();

    }
}
