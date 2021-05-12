package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class booking_search {
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
    public void test7_createSchedule() throws Exception {
        Thread.sleep(2000);
        //tour management link
        String childurl = "http://staging.amujamu.com/admin/all-booking-list";
        driver.get(childurl);

        // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/a[3]")).click();

        //start date
        driver.findElement(By.id("start_date")).sendKeys("2019-10-21");

        //End date
        driver.findElement(By.id("end_date")).sendKeys("2019-10-30");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[4]/button")).click();


        /*//Except date
        driver.findElement(By.id("except_dates")).sendKeys("2019-11-11");

        //seat
        driver.findElement(By.id("seat_limit")).sendKeys("450");
        //jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[26]/div/div[2]/button")).click();

         */
    }

}
