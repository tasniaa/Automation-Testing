package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class tourFromExcel {
    private WebDriver driver;
    JavascriptExecutor jse;

    static {
        System.setProperty("webdriver.chrome.driver", "D:\\tutorial\\chromedriver.exe");
    }

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.URL);
        jse = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a")).click();
        Thread.sleep(2000);
        // Tell the code about the location of Excel file
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Admin");
        return testData;
    }

    @Test(priority = 2, dataProvider = "loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        // Click login button

        // Enter username
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(username);
        // Enter password
        driver.findElement(By.id("password")).sendKeys(password);
        // Click Login button
        driver.findElement(By.xpath("//*[@id=\"main-body\"]/div[3]/div[2]/div/div/div/div/form/a/input")).click();

        //Thread.sleep(2000);
        //Thread.sleep(20000);
        //driver.findElement(By.xpath("//*[@id=\"vue\"]/div[2]/div/div[4]/div[3]/a")).click();
        // Find if error messages exist
        //boolean result = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input")).size() != 0;
        //Assert.assertTrue(result);
    }

    @DataProvider(name = "Tour")
    public Object[][] dataProvider2() {
        Object[][] testData = ExcelUtility.getTestData("Tour");
        return testData;
    }

    @Test(priority = 3, dataProvider = "Tour")
    public void test2_tourcreateTest(String locatioName ,String locationxpath, String category_id, String activity_type_id,String title,String description,  String latitude ,String longitude) throws Exception {
        //tour management link
        String childUrl="http://staging.amujamu.com/admin/tour";
        driver.get(childUrl);
        //tour create button

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/a")).click();

        //tour location select

        jse.executeScript("window.scrollBy(0, 200)");
        Thread.sleep(2000);

        //driver.findElement(By.id("select2-location_id-container")).click();
        driver.findElement(By.id("select2-location_id-container")).click();
        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(locatioName);
        Thread.sleep(2000);
        driver.findElement(By.xpath(locationxpath)).click();
        Thread.sleep(2000);

        //tour Catagory

        WebElement catagory = driver.findElement(By.id("category_id"));
        Select cat = new Select(catagory);
        cat.selectByValue(category_id);

        //Activity type
        WebElement tourelement = driver.findElement(By.id("activity_type_id"));
        Select tour = new Select(tourelement);
        tour.selectByValue(activity_type_id);

        //tour title
        driver.findElement(By.id("title")).sendKeys(title);

        //tour description
        driver.findElement(By.id("short_description")).sendKeys(description);

        //latitude
        driver.findElement(By.id("latitude")).sendKeys(latitude);

        //longitude
        driver.findElement(By.id("longitude")).sendKeys(longitude);




        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[11]/div[2]/div/input")).sendKeys("zipline");

        //create button
        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/div[2]/div/a")).sendKeys(Keys.ENTER);
    }

    @AfterClass
    public void tearDown() throws Exception {
        // driver.q
    }
}
