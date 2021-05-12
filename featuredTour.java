package amujamuSiteTest;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class featuredTour {

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

    @Test
    public void test1_validLoginTest() throws Exception {

        WebElement loginLink = driver.findElement(By.xpath("/html/body/div[2]/nav[2]/nav[1]/div/div[2]/ul/li[3]/a"));
        loginLink.click();



        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("admin@admin.com");


        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("1234");


        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div/div/div/form/a/input"));
        loginButton.click();

        String chilUrl= "http://staging.amujamu.com/admin/featured-tour";
        driver.get(chilUrl);

        //Add/remove popular destination button

        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/a"));
        createButton.click();

        //scroll

        jse.executeScript("window.scrollBy(0, 100)");
        Thread.sleep(2000);

        //popular destination location textbox click

        WebElement location = driver.findElement(By.id("tour_id"));
        Select sel = new Select(location);
        //remove tour
        sel.deselectByValue("38");
        //add tour
        sel.selectByValue("43");

        Thread.sleep(2000);

        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[2]/input")).click();


        //drang and drop

        WebElement fromElement = driver.findElement(By.xpath("//*[@id=\"featuredTourList\"]/li[5]/span"));

        //destination 8

        WebElement toElement = driver.findElement(By.xpath("//*[@id=\"featuredTourList\"]/li[8]/span"));

        Actions action = new Actions(driver);

        // Click and hold, move to element, release, build and perform

        action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();

        //update popular destination
        jse.executeScript("window.scrollBy(0, -100)");
        Thread.sleep(2000);


        driver.findElement(By.id("updateOrder")).click();
        //ok button
        driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div/button")).click();
    }

}
