package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testChromeDriver {
    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor jse;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }


    @BeforeClass
    public void beforeClass() {

       // System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        baseUrl = "http://staging.amujamu.com";
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        jse = (JavascriptExecutor)driver;
        // Maximize the browser's window
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test (priority=1)
    public void test1_validLoginTest() throws Exception {

        WebElement loginLink = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a"));
        loginLink.click();



        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("admin@admin.com");


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("1234");


        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input"));
        loginButton.click();

    }
    @Test

    public void test7_rating() throws Exception {
        Thread.sleep(2000);
        String childurl="http://staging.amujamu.com/admin/tour/1/review";
        driver.get(childurl);
        //rating details button
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[7]")).click();

        //rating create
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/a")).sendKeys(Keys.ENTER);

        //user name
        driver.findElement(By.id("name")).sendKeys("Tasnia");

        //rating
        //driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/svg[4]/polygon")).click();

        //is publish
        driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[6]/div[2]/span/label/span")).click();

        //fake
        driver.findElement(By.xpath("//*[@id=\"rating_parent_id\"]/div[8]/div/span/label/span"));

        //submit
        driver.findElement(By.id("submit_btn")).click();
    }
/*
    public void test7_updateFeaturesTest() throws Exception {
        //tour management link
        String childurl = "http://staging.amujamu.com/admin/tour";
        driver.get(childurl);

        //Edit button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[7]/div/a[1]/i")).click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[3]")).click();

        //has insurence publish
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/div[2]/div/span/label/span")).click();

        //has food allownce publish

        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/div[4]/div/span/label/span")).click();

        //cash payment on
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/div[8]/div/span/label/span")).click();

        //is publish on
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/div[9]/div/span/label/span")).click();


        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/button")).click();
    }
/*
    @Test
    public void test6_AllPackage() throws Exception {
        //tour management link
        String childurl = "http://staging.amujamu.com/admin/tour";
        driver.get(childurl);

        //Edit button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[7]/div/a[1]/i")).click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[6]")).click();

        //Edit package
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/table/tbody/tr/td[10]/div/a[2]")).click();

        //driver.findElement(By.id("cke_1_path")).sendKeys("Hot Springs here not only hold the egg, boiled hot water immersion have online 234 Loei. There is a small waterfall and climbing into the rear, cold cave, can contact an officer escorting into caves. Each round no more than 7 people really knew our bodies, it should be more than fitness, this only takes half a day wandering 5555 walk up to the mouth of the crater caves 2 hours");

        //is publish on
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[1]/div[2]/div/div[6]/div[2]/span/label/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);

      if(driver.findElement(By.cssSelector("#cke_4_contents > iframe")).isEnabled())
        {
            WebElement iframe = driver.findElement(By.cssSelector("#cke_4_contents > iframe > iframe"));

            if(driver.findElement(By.xpath("//*[@id=\"cke_4_contents\"]/iframe")).isDisplayed())
            {
                driver.switchTo().frame(iframe);
                iframe.clear();
                iframe.click();
                iframe.sendKeys("Hello!!");
            }
        }
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[2]/button")).click();
    }

    @Test
    public void test7_createSchedule() throws Exception {
        //tour management link
        String childurl = "http://staging.amujamu.com/admin/tour/47/show-package/51";
        driver.get(childurl);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/a[3]")).click();

        //instant booking
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[4]/div[2]/span/label/span")).click();

        //is publish

        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[8]/div[2]/span/label/span")).click();

        //start date
        driver.findElement(By.id("start_date")).sendKeys("2019-10-21");

        //End date
        driver.findElement(By.id("end_date")).sendKeys("2019-12-12");

        //Except date
        driver.findElement(By.id("except_dates")).sendKeys("2019-11-11");

        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/button[1]")).click();

        //is publish on
        driver.findElement(By.id("seat_limit")).sendKeys("450");


        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[26]/div/div[2]/button")).click();
    }*/
}
