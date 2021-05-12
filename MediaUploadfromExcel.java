package amujamuSiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MediaUploadfromExcel {
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

    /*@DataProvider(name = "MediaUpload")
    public Object[][] dataProvider2() {
        Object[][] testData = ExcelUtility.getTestData("MediaUpload");
        return testData;
    }

    @Test(priority = 3, dataProvider = "MediaUpload")
    public void test4_uploadmediaTest(String toururl,String image) throws Exception {

        //uploadmedia
        String childurl= toururl;
        driver.get(childurl);
        //video link upload
        //  driver.findElement(By.id("featured_video_link")).sendKeys("https://www.youtube.com/watch?v=bnDatiFabNk");

        //media upload

        driver.findElement(By.id("media")).sendKeys(image);

        //upload button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[2]/button")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"22\"]/td[2]/div[3]/div/span[2]/label/span")).click();

        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[1]/button")).click();
        Thread.sleep(2000);

        //cancel button
        //driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/a")).click();
    }

     */
    @DataProvider(name = "tourImage")
    public Object[][] dataProvider3() {
        Object[][] testData = ExcelUtility.getTestData("tourImage");
        return testData;
    }
    @Test(priority = 4, dataProvider = "tourImage")
    public void test4_uploadmediaTest(String tourmedia,String image) throws Exception {


        //uploadmedia
        String childurl= tourmedia;
        driver.get(childurl);
        //video link upload
        //  driver.findElement(By.id("featured_video_link")).sendKeys("https://www.youtube.com/watch?v=bnDatiFabNk");

        //media upload

        driver.findElement(By.id("media")).sendKeys(image);

        //upload button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/div[4]/div/div/div/table/tbody/tr/td[2]/div[5]/div/span[2]/label/span")).click();

        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/button[2]")).click();

        //cancel button
        //driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/a")).click();
    }


}
