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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class tourCreate {
    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor jse;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }

    @BeforeClass
    public void beforeClass() {
        baseUrl = "http://staging.amujamu.com";
        driver = new ChromeDriver();
       // System.setProperty("webdriver.gecko.driver", "D:\\selenium_java\\geckodriver");
        jse = (JavascriptExecutor)driver;
        // Maximize the browser's window
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void test1_validLoginTest() throws Exception {
       driver.findElement(By.id("search_input_txt")).click();

        driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a")).click();

        driver.findElement(By.id("email")).sendKeys("admin@admin.com");


        driver.findElement(By.id("password")).sendKeys("1234");


        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input")).click();

        //tour management link
        String childurl="http://staging.amujamu.com/admin/tour";
        driver.get(childurl);

        /*
        //tour create button

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/a")).click();

        //tour location select

        jse.executeScript("window.scrollBy(0, 200)");
        //Thread.sleep(2000);

        driver.findElement(By.id("select2-location_id-container")).click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Sakhon Nakhon");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"location_id\"]/option[32]")).click();
        Thread.sleep(2000);

        //tour Catagory

        WebElement catagory = driver.findElement(By.id("category_id"));
        Select cat = new Select(catagory);
        cat.selectByValue("1");

        //Activity type
        WebElement tourelement = driver.findElement(By.id("activity_type_id"));
        Select tour = new Select(tourelement);
        tour.selectByValue("1");

        //tour title
        driver.findElement(By.id("title")).sendKeys("Phu Phan National Park");

        //tour description
        driver.findElement(By.id("short_description")).sendKeys("ust 25km outside of the city, this lush national park sprawls for 664 km2 covering limestone mountains, savannahs and fresh waterfalls. ");

        //latitude
        driver.findElement(By.id("latitude")).sendKeys("17.345");

        //longitude
        driver.findElement(By.id("longitude")).sendKeys("103.5822");

        driver.findElement(By.id("address")).sendKeys("Unnamed Rd, 47180, Huai Yang, Mueang Sakon Nakhon District, Sakon Nakhon, Thailand");


        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[11]/div[2]/div/input")).sendKeys("zipline");

        //create button
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/button")).click();
*/
    }

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
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("Sakhon Nakhon");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"location_id\"]/option[32]")).click();
        Thread.sleep(2000);

        //tour Catagory

        WebElement catagory = driver.findElement(By.id("category_id"));
        Select cat = new Select(catagory);
        cat.selectByValue("1");

        //Activity type
        WebElement tourelement = driver.findElement(By.id("activity_type_id"));
        Select tour = new Select(tourelement);
        tour.selectByValue("1");

        //tour title
        driver.findElement(By.id("title")).sendKeys("Wat Phra That Choeng Chum");

        //tour description
        driver.findElement(By.id("short_description")).sendKeys("ust 25km outside of the city, this lush national park sprawls for 664 km2 covering limestone mountains, savannahs and fresh waterfalls. ");

        //latitude
        driver.findElement(By.id("latitude")).sendKeys("173.45");

        //longitude
        driver.findElement(By.id("longitude")).sendKeys("103.5822");




        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[11]/div[2]/div/input")).sendKeys("zipline");

        //create button
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);
    }


    @AfterClass
    public void afterClass() {
        //driver.quit();

    }
}
