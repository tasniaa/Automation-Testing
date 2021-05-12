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

public class tourCatagory {
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
/*
        String chilUrl= "http://staging.amujamu.com/admin/category";
        driver.get(chilUrl);

        //Create tour catagory button

        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/a/i"));
        createButton.click();


        driver.findElement(By.id("name")).sendKeys("Food");

        Select sel = new Select(driver.findElement(By.id("icon")));
        sel.selectByValue("coffee");

        driver.findElement(By.id("media")).sendKeys("D:\\food.png");

        //create
        driver.findElement(By.xpath("//*[@id=\"form_id\"]/div/div/div[2]/div/div[5]/div[2]/button")).click();

 */
    }

    @Test
    public void test2_categoryRelationManagementtest() throws Exception {


        String chilUrl= "http://staging.amujamu.com/admin/category-relation";
        driver.get(chilUrl);

        //Create tour catagory button

        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/a/i"));
        createButton.click();

        //parent catagory
        Select sel = new Select(driver.findElement(By.id("parent_id")));
        sel.selectByValue("6");

        //child catagory
        Select child = new Select(driver.findElement(By.id("category_id")));
        child.selectByValue("3");

        //ok button
        driver.findElement(By.xpath("//*[@id=\"categoryRelation_form\"]/div[2]/div/div[2]/button")).click();
    }


}
