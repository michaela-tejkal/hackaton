package cz.czechitas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

import java.lang.*;
import java.lang.String;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

public class TemplateTest {

    private static final String shopURL = Settings.baseUrl + "/web/";
    private static WebDriver driver;

    @BeforeEach
    public void before() {
        driver = DriverHelper.openFirefox();
        driver.navigate().to(shopURL);

    }

    @AfterEach
    public void after() {
        driver.quit();

    }

    @Test
    @DisplayName("REQ-0034 – Authentication page")
    public void test() {

        WebElement searchButton = driver.findElement(className("hide_xs"));
        searchButton.click();
        WebElement searchField = driver.findElement(className("hide_xs"));
        System.out.println("SubmitCreate: " + searchField.isEnabled());
        WebElement searchField2 = driver.findElement(id("SubmitLogin"));
        System.out.println("SubmitLogin: " + searchField2.isEnabled());
        WebElement searchField3 = driver.findElement(xpath("/html/body/div/div[2]/div/div[2]/div/div/div[2]/form/div/p[1]/a"));
        System.out.println("ForgotPassword: " + searchField3.isEnabled());

    }

    @Test
    @DisplayName("REQ-0035 – Create account")
    public void test2() {
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[7]/ul/li/a/span"));
        searchButton.click();
        WebElement searchField = driver.findElement(id("email_create"));
        searchField.sendKeys("doma@test.cz");
        WebElement searchButton2 = driver.findElement(By.name("SubmitCreate"));
        searchButton2.click();

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));

        WebElement searchField3 = driver.findElement(By.id("customer_lastname"));
        searchField3.sendKeys("Nová");

        WebElement searchField4 = driver.findElement(By.id("email"));
        searchField4.sendKeys("neim@test.cz");

        WebElement searchField5 = driver.findElement(By.id("passwd"));
        searchField5.sendKeys("12345");

        WebElement searchButton3 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/form/div[2]/button/span"));
        searchButton3.click();

    }

    @Test
    @DisplayName("REQ-0021 – Login in header section")
    public void test3() {

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[7]/ul/li/a/span"));
        searchButton.click();
        WebElement searchField1 = driver.findElement(By.id("email"));
        searchField1.sendKeys("test@test.cz");
        WebElement searchField2 = driver.findElement(By.id("passwd"));
        searchField2.sendKeys("password");
        WebElement searchButton2 = driver.findElement(By.name("SubmitLogin"));
        searchButton2.click();

    }
    @Test
    @DisplayName("REQ-0001 – Main page room reservation")
    public void test4(){
        WebElement searchButton = driver.findElement(By.className("nav_toggle"));
        searchButton.click();
        WebElement searchButton2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[3]/div/div/div[2]/ul[1]/li[4]/a"));
        searchButton2.click();
        WebElement searchButton3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div[1]/div[1]/div/div[3]/a/span"));
        searchButton3.click();

        WebElement searchField = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/form/div[2]/div[1]/label"));
        System.out.println("Check-in: " + searchField.isEnabled());
        WebElement searchField2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/form/div[2]/div[2]/label"));
        System.out.println("check-out: " + searchField2.isEnabled());

    }

    @Test
    @DisplayName("REQ-0025 – Newsletter subscription")
    public void test5(){
        WebElement searchField = driver.findElement(By.id("newsletter-input"));
        searchField.sendKeys("test@test.cz");
        WebElement searchButton = driver.findElement(By.name("submitNewsletter"));
        searchButton.click();

    }

    
}
