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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amujamuSiteTest.Constants;
import amujamuSiteTest.ExcelUtility;

public class ExcelRead {
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
        jse = (JavascriptExecutor)driver;
        driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a")).click();
        Thread.sleep(2000);
        // Tell the code about the location of Excel file
        ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1");
    }

    @DataProvider(name = "loginData")
    public Object[][] dataProvider() {
        Object[][] testData = ExcelUtility.getTestData("Test_Case");
        return testData;
    }

    @Test(priority =2 ,dataProvider="loginData")
    public void testUsingExcel(String username, String password) throws Exception {
        // Click login button

        // Enter username
        WebElement email= driver.findElement(By.id("email"));
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

    @DataProvider(name = "BookingData")
    public Object[][] dataProvider2() {
        Object[][] testData = ExcelUtility.getTestData("Booking");
        return testData;
    }
    @Test(priority =3 , dataProvider ="BookingData" )
    public void test2booking(String tour) throws Exception {
        driver.findElement(By.xpath("//*[@id=\"vue\"]/div/div[3]/div/div/div[1]/div[1]/div/a")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"navbarDropdownMenuUser\"]")).click();
        Thread.sleep(2000);
        // driver.findElement(By.xpath("//*[@id=\"currency-list-ul\"]/li[4]/a")).click();

        driver.findElement(By.id("search_input_txt")).sendKeys(tour);

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
        jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"package\"]/div[1]/div[3]/div/div/button")).click();
        jse.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"package\"]/div[1]/div[3]/div/div/div/div[2]/div/span[36]")).click();

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
        driver.findElement(By.xpath("//*[@id=\"tab\"]/div/label[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment\"]/div[3]/div[2]/div/button")).click();
        /*Thread.sleep(2000);
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

         */
        Thread.sleep(20000);
        String child2 = "http://staging.amujamu.com/dashboard";
        driver.get(child2);

    }

    @AfterClass
    public void tearDown() throws Exception {
       // driver.quit();
    }
}
