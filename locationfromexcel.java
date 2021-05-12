package amujamuSiteTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import amujamuSiteTest.Constants;
import amujamuSiteTest.ExcelUtility;


public class locationfromexcel {

    private WebDriver driver;
    JavascriptExecutor jse;
    ExtentReports report;
    ExtentTest test;

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
        report = new ExtentReports("D:\\trending destination\\amujamulogin.html");
        test = report.startTest("Verify Welcome Text");
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

    @Test(priority = 1, dataProvider = "loginData")
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
/*
    @DataProvider(name = "Location")
    public Object[][] dataProvider2() {
        Object[][] testData = ExcelUtility.getTestData("Location");
        return testData;
    }

    @Test(priority = 2, dataProvider = "Location")
    public void test2booking(String location,String parentId,String description, String image , String latitude ,String longitude ) throws Exception {
        String childurl="http://staging.amujamu.com/admin/location";

        driver.get(childurl);

        //location create button

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/a")).click();

        //country select

        driver.findElement(By.id("country_id")).click();

        //dropdown element select

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]/div/div[2]/div[2]/select/option[3]")).click();

        //location name

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[1]/div[2]/div/div[3]/div[2]/input")).sendKeys(location);

        //parent location

        Select sel = new Select(driver.findElement(By.id("parent_location")));
        sel.selectByValue(parentId);

        //Location description
        driver.findElement(By.id("description")).sendKeys(description);

        //timezone

        driver.findElement(By.id("select2-timezone-container")).click();

        //dropdown element select

        driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("-11:00 (Pacific/Midway)");
        driver.findElement(By.xpath("//*[@id=\"timezone\"]/option[4]"));

        //image upload

        //driver.findElement(By.id("media")).click();

        driver.findElement(By.id("media")).sendKeys(image);

        //latitude
        driver.findElement(By.id("latitude")).sendKeys(latitude);

        //longitude
        driver.findElement(By.id("longitude")).sendKeys(longitude);
        Thread.sleep(2000);

        //is publish
        //driver.findElement(By.xpath("//*[@id=\"location\"]/div[1]/div[2]/div/div[12]/div[2]/span/label/span")).click();


        //create button

       // driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div[2]/div/div[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"location\"]/div[2]/div/div[1]/a")).click();

    }

    @DataProvider(name = "LocationEdit")
    public Object[][] dataProvider3() {
        Object[][] testData = ExcelUtility.getTestData("LocationEdit");
        return testData;
    }

    @Test(priority = 3, dataProvider = "LocationEdit")
    public void locationEdit(String locationlink ) throws Exception {
        String childurl=locationlink;
        driver.get(childurl);

        //location create button



        //publish on

        driver.findElement(By.xpath("//*[@id=\"location\"]/div/div[12]/div[2]/span/label/span")).click();

        //update button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[2]/button")).click();

        //cancel button
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div[2]/div/div[1]/a")).click();

    }

 */

    @DataProvider(name = "AddRemove")
    public Object[][] dataProvider3() {
        Object[][] testData = ExcelUtility.getTestData("AddRemove");
        return testData;
    }

    @Test(priority = 4, dataProvider = "AddRemove")
    public void addRemove(String removelocation, String addlocation ) throws Exception {
        String childurl = "http://staging.amujamu.com/admin/popular-destination";

        driver.get(childurl);

        //Add/remove popular destination button

        WebElement createButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div/a"));
        createButton.click();

        //scroll

        jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);

        //popular destination location textbox click

        WebElement location = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[1]/div[2]/span/span[1]/span/ul"));

        Actions action = new Actions(driver);
        action.moveToElement(location).perform();
        Thread.sleep(2000);

        //remove popular destination

        WebElement removeicon = driver.findElement(By.xpath(removelocation));
        action.moveToElement(removeicon).click().perform();
        test.log(LogStatus.INFO, "Location removed");

        Thread.sleep(2000);


        //Add popular destination

        // WebElement addElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[1]/div[2]/select/option[5]"));
        //action.moveToElement(addElement).click().perform();

        //Thread.sleep(2000);

        WebElement element = driver.findElement(By.id("location_id"));

        Select sel = new Select(element);
        sel.selectByValue(addlocation);
        test.log(LogStatus.INFO, "Location added");



        //  Thread.sleep(2000);
        //create button

        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[2]/div/div[2]/input")).click();

        //cancel

        //driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div/div/div[2]/div/div[2]/div/div[1]/a")).click();

    }

    @AfterClass
    public void tearDown() throws Exception {
        // driver.q
    }
}