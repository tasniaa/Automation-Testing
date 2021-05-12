package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class manualBookingCreate {
    WebDriver driver;
    String baseURL;
    JavascriptExecutor jse;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
        baseURL = "http://staging.amujamu.com";

        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "D:\\selenium_java\\geckodriver");

        jse = (JavascriptExecutor) driver;

        // Maximize the browser's window
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        //login menu

        driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a")).click();

        //email textbox

        driver.findElement(By.id("email")).sendKeys("admin@admin.com");

        //password textbox

        driver.findElement(By.id("password")).sendKeys("1234");

        //loginbutton
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input")).click();

        //manual booking
        String childurl = "http://staging.amujamu.com/admin/manual-booking/create";
        driver.get(childurl);

        //click select country

        driver.findElement(By.id("select2-country_id-container")).click();

        //click search button
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).click();

        //select
        driver.findElement(By.xpath("//*[@id=\"country_id\"]/option[3]")).click();

        //click select location
        WebElement element = driver.findElement(By.id("location_id"));
        Select sel = new Select(element);
        sel.selectByValue("31");

        //click select tour type
        WebElement tour = driver.findElement(By.id("tour_type_id"));
        Select seltour = new Select(tour);

        seltour.selectByValue("1");

        //click select tour
        WebElement element2 = driver.findElement(By.id("tour_id"));
        Select sel2 = new Select(element2);
        sel2.selectByValue("34");

        //package
        driver.findElement(By.xpath("//*[@id=\"card_0\"]/div[1]/a")).click();

        //package details
        //select booking date
        driver.findElement(By.id("pick_date_0")).click();
        driver.findElement(By.xpath("//*[@id=\"card_0\"]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[5]/a")).click();
        //customer time
        driver.findElement(By.xpath("//*[@id=\"collapse0\"]/div/div[3]/span[2]/label/span")).click();
        //increase button
        for (int i=0 ; i<3;i++)
        {
            driver.findElement(By.xpath("//*[@id=\"package_quantity_div_0\"]/tbody/tr[3]/td[1]/div/span[2]/button")).click();
        }



        //customer info
        driver.findElement(By.id("firstName")).sendKeys("Toma");

        driver.findElement(By.id("lastName")).sendKeys("Jahan");

        driver.findElement(By.id("email")).sendKeys("mahajabintorosha@gmail.com");

        //customer Country
        WebElement country = driver.findElement(By.id("nationality"));
        Select selcon = new Select(country);
        selcon.selectByValue("ATG");

        //contact No
        driver.findElement(By.id("contactNumber")).sendKeys("2013450123");

        //customer Currency
        WebElement Currency = driver.findElement(By.id("customer_currency"));
        Select selcur = new Select(Currency);
        selcur.selectByValue("KGS");

        //customer payment method
        driver.findElement(By.xpath("//*[@id=\"select_manual_booking_div\"]/tbody/tr/td/div[17]/div[2]/div/div/input[1]")).sendKeys(Keys.ENTER);

        //click select tour
        WebElement paymentstatus = driver.findElement(By.id("payment_status"));
        Select selpay = new Select(paymentstatus);

        Thread.sleep(2000);
        selpay.selectByValue("paid");
        driver.findElement(By.id("message_to_seller")).sendKeys("Hello");
        //customer info
       // jse.executeScript("window scrollBy -300 :" );

        Thread.sleep(2000);

        //cupon

        driver.findElement(By.id("coupon")).sendKeys("G10");
        driver.findElement(By.id("apply_coupon")).sendKeys(Keys.ENTER);

        //special discount

        driver.findElement(By.id("special_discount")).sendKeys("10");
        driver.findElement(By.id("apply-special_discount")).sendKeys(Keys.ENTER);

        //jse.executeScript("window.scrollBy(0, 300)");
        Thread.sleep(2000);
       // driver.findElement(By.id("manual_booking_submit")).click();

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div/button[3]")).click();

        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div/button[2]")).click();



        //*[@id="root"]/div/div[2]/div/div[3]/div/button[2]
    }




}

