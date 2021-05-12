package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class booking {
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
        jse = (JavascriptExecutor)driver;
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
        emailField.sendKeys("tasnia123@gmail.com");


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("123456");


        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input"));
        loginButton.click();

    }

    @Test
    public void test2booking() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"vue\"]/div/div[3]/div/div/div[1]/div[1]/div/a")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"navbarDropdownMenuUser\"]")).click();
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//*[@id=\"currency-list-ul\"]/li[4]/a")).click();

        driver.findElement(By.id("search_input_txt")).sendKeys("Best Ocean Golf Club");

        driver.findElement(By.id("search_input_txt_button")).click();
        Thread.sleep(2000);
        String parentWinHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"search_results\"]/li[1]/div/div[2]/div/div[1]/a/p")).click();
        Set<String> winHandles = driver.getWindowHandles();
        // Loop through all handles
        for(String handle: winHandles) {
            if (!handle.equals(parentWinHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(1000);

            }
        }


        //String childURL="http://staging.amujamu.com/activity/jungle-trek";
        // driver.get(childURL);
        jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"package\"]/div[1]/div[3]/div/div/button")).click();
        jse.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"package\"]/div[1]/div[3]/div/div/div/div[2]/div/span[38]")).click();

        driver.findElement(By.xpath("//*[@id=\"package\"]/div[2]/div/div/div[2]/div/button")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"package\"]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]")).click();
        WebElement element= driver.findElement(By.xpath("//*[@id=\"package\"]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/input[3]"));
        element.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"package\"]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/input[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"package\"]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/input[3]")).click();
        //driver.findElement(By.xpath("//*[@id=\"package\"]/div[2]/div/div/div[3]/div[2]/div[2]/div/div/div[2]/input[3]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tour-side-content\"]/div[2]/div/div/div[4]"))).click();
        Thread.sleep(2000);
        //contact No
        driver.findElement(By.id("contact-number")).sendKeys("0832424232");
        //customer Country
        WebElement country = driver.findElement(By.id("country"));
        Select selcon = new Select(country);
        selcon.selectByValue("AFG");

        //messagebox
        driver.findElement(By.xpath("//*[@id=\"message_to_seller\"]")).sendKeys("Book best tour");
        driver.findElement(By.id("coupon")).sendKeys("G10");
        driver.findElement(By.xpath("//*[@id=\"booking-info\"]/div[2]/div/div[7]/div/div[1]/div[2]/button[1]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"booking-info\"]/div[2]/div/div[7]/div/div[2]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"booking-info\"]/div[3]/div/button")).click();
        jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);
        //zero pay
       // driver.findElement(By.xpath("//*[@id=\"zero_payment_block\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tab\"]/div/label[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment\"]/div[3]/div[2]/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("amujamu-buyer@gmail.com");
        driver.findElement(By.id("btnNext")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"button\"]/button")).click();
        Thread.sleep(20000);
        driver.findElement(By.id("confirmButtonTop")).click();
        //Thread.sleep(20000);
        //driver.findElement(By.xpath("//*[@id=\"vue\"]/div[2]/div/div[4]/div[3]/a")).click();

    }
}
