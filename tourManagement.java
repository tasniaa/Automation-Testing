package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.Key;


public class tourManagement {

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
    /*
    @Test (priority=2)
    public void test2_tourcreateTest() throws Exception {
        //tour management link
        String childurl="http://staging.amujamu.com/admin/tour";
        driver.get(childurl);

        //tour create button

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/a")).click();

        //tour location select

        jse.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(2000);

        //driver.findElement(By.id("select2-location_id-container")).click();
        driver.findElement(By.id("select2-location_id-container")).click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Koh Samui");

        driver.findElement(By.xpath("//*[@id=\"location_id\"]/option[28]")).click();

        //tour Catagory
        WebElement catagory = driver.findElement(By.id("category_id"));
        Select cat = new Select(catagory);
        cat.selectByValue("1");

        //Activity type
        WebElement tourelement = driver.findElement(By.id("activity_type_id"));
        Select tour = new Select(tourelement);
        tour.selectByValue("1");

        //tour title
        driver.findElement(By.id("title")).sendKeys("Jungle Trek");

        //tour description
        driver.findElement(By.id("short_description")).sendKeys("25km outside of the city, this lush national park sprawls for 664 km2 covering limestone mountains.");

        //latitude
        driver.findElement(By.id("latitude")).sendKeys("173.45");

        //longitude
        driver.findElement(By.id("longitude")).sendKeys("103.5822");


        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[11]/div[2]/div/input")).sendKeys("zipline");

        //create button
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);
    }

    @Test (priority = 3)
    public void test3_updateBasicInfoTest() throws Exception {
        //tour management link
        String childurl="http://staging.amujamu.com/admin/tour/34";
        driver.get(childurl);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[1]")).click();
        driver.findElement(By.id("address")).sendKeys("41/1 Mae Raem, Mae Rim District, Koh chang, Thailand");
        driver.findElement(By.id("submit")).click();
    }

    @Test(priority = 4)
    public void test2_updateFInfo() throws Exception {
        Thread.sleep(2000);

        //update details button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[2]")).click();

        jse.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        WebElement ckeditor_frame = driver.findElement(By.cssSelector("#cke_4_contents > iframe"));
        driver.switchTo().frame(ckeditor_frame);
        WebElement editor_body = driver.findElement(By.tagName("body"));
        editor_body.sendKeys("Jungle Trek!");
        driver.switchTo().defaultContent();

        WebElement iframe = driver.findElement(By.cssSelector("#cke_1_contents > iframe"));

        driver.switchTo().frame(iframe);
        WebElement description_body = driver.findElement(By.tagName("body"));
        description_body.sendKeys("Jungle Trek!");
        driver.switchTo().defaultContent();

        jse.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(2000);

        WebElement iframe2 = driver.findElement(By.cssSelector("#cke_2_contents > iframe"));
        driver.switchTo().frame(iframe2);
        WebElement tour_iterary = driver.findElement(By.tagName("body"));
        tour_iterary.sendKeys("You'll get picked up!");
        driver.switchTo().defaultContent();

        jse.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(2000);

        WebElement iframe3 = driver.findElement(By.cssSelector("#cke_3_contents > iframe"));
        driver.switchTo().frame(iframe3);
        WebElement cancel = driver.findElement(By.tagName("body"));
        cancel.sendKeys("Cancellation must be made 72 hours before arrival date; last-minute cancellations will incur a full rate charge of the price.");
        driver.switchTo().defaultContent();


        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/div[11]/div/div[2]/button")).click();
    }


    @Test (priority = 5)

    public void test4_uploadmediaTest() throws Exception {
        Thread.sleep(2000);
        //uploadmedia
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[4]")).click();

        //video link upload
        driver.findElement(By.id("featured_video_link")).sendKeys("https://www.youtube.com/watch?v=bnDatiFabNk");

        //media upload

        driver.findElement(By.id("media")).sendKeys("C:\\Users\\hp\\Downloads\\jungle-trek.jpg");

        //upload button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/div[4]/div/div/div/table/tbody/tr/td[2]/div[5]/div/span[2]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/button[2]"));
        //cancel button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/a")).click();
    }



    @Test(priority = 7)
    public void test6_AllpackageQuantity() throws Exception {
        Thread.sleep(2000);
        //tour management link
        String childurl = "http://staging.amujamu.com/admin/tour/34/package-quantity-list/36";
        driver.get(childurl);

        //package Quantity create
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/a")).click();

        //title

        driver.findElement(By.id("title")).sendKeys("Full Day Package with Transportation");

        //Market Price
        driver.findElement(By.id("market_price")).sendKeys("200");

        //Operator Price
        driver.findElement(By.id("operator_price")).sendKeys("120");

        //Amujamu Price
        driver.findElement(By.id("amujamu_price")).sendKeys("150");

        //listing order
        driver.findElement(By.id("listing_order")).sendKeys("1");


        //feature publish
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[1]/div[2]/div/div[10]/div[2]/span/label/span")).click();

        //Grade
        Select cur= new Select(driver.findElement(By.id("grading_id")));
        cur.selectByValue("1");

        // publish package quantity on
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[1]/div[2]/div/div[12]/div[2]/span/label/span")).click();

        //create button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[2]/button")).click();


    }

    @Test(priority=8)
    public void test7_createSchedule() throws Exception {
        Thread.sleep(2000);
        //tour management link
        String childurl = "http://staging.amujamu.com/admin/tour/34/create-schedule/36";
        driver.get(childurl);

        // driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/a[3]")).click();

        //instant booking
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[4]/div[2]/span/label/span")).click();

        //is publish

        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[8]/div[2]/span/label/span")).click();

        //start date
        driver.findElement(By.id("start_date")).sendKeys("2019-10-21");

        //End date
        driver.findElement(By.id("end_date")).sendKeys("2019-12-12");

        driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/button[1]")).click();


        //Except date
        driver.findElement(By.id("except_dates")).sendKeys("2019-11-11");

        //seat
        driver.findElement(By.id("seat_limit")).sendKeys("450");
        //jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);


       driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[2]/div/div/div[1]/div[26]/div/div[2]/button")).click();
    }

    @Test(priority = 6)
    public void test5_packageManageTest() throws Exception {
        Thread.sleep(2000);
        //tour management link
        String childurl="http://staging.amujamu.com/admin/tour/34";
        driver.get(childurl);


        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[6]")).click();

        //create package
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/a")).click();


        //package title
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[1]/div[2]/div/div[3]/div[2]/input")).sendKeys("Full Day package");
        //operator button
        Select sel= new Select(driver.findElement(By.id("operator_id")));
        sel.selectByValue("1");

        //is publish on
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[1]/div[2]/div/div[6]/div[2]/span/label/span")).click();

        //currency
        Select cur= new Select(driver.findElement(By.id("currency")));
        cur.selectByValue("THB");

        //listing order
        driver.findElement(By.id("listing_order")).sendKeys("1");


        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[2]/button")).click();
    }

    @Test(priority = 10)
    public void test7_rating() throws Exception {
       for (int i = 0; i < 10; i++) {
           Thread.sleep(2000);
           String childurl = "http://staging.amujamu.com/admin/tour/34";
           driver.get(childurl);
           //rating details button
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[7]")).click();

           //rating create
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/a")).click();

           //user name
           driver.findElement(By.id("name")).sendKeys("Torosha");

           //rating
           //driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/svg[4]/polygon")).click();

           //is publish
           driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[6]/div[2]/span/label/span")).click();

           //fake
           driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[8]/div/span/label/span")).click();

           //submit
           driver.findElement(By.id("submit_btn")).click();
       }

    @Test(priority = 9)
    public void test8_updateFeaturesTest() throws Exception {
        Thread.sleep(2000);
        String childurl="http://staging.amujamu.com/admin/tour/34";
        driver.get(childurl);

        //Edit button
        //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/table/tbody/tr[1]/td[7]/div/a[1]/i")).click();

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
    }*/


    @Test(priority = 10)
    public void test7_rating() throws Exception {

        String reviewedit="";
        for (int i = 0; i < 1; i++) {
            Thread.sleep(2000);
            String childurl = "http://staging.amujamu.com/admin/tour/1";
            driver.get(childurl);
            //rating details button
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/a[7]")).click();

            //rating create
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[10]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[11]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[12]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[13]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[14]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[15]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[16]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[17]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();

            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[18]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/table/tbody/tr[19]/td[10]/div/a[1]/i")).click();
            driver.findElement(By.id("comments")).sendKeys("good trip");

            //submit
            driver.findElement(By.id("submit_btn")).click();



        }


    }

    @AfterClass
    public void afterClass() {
        //driver.quit();

    }

}
