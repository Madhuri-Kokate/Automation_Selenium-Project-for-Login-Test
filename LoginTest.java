package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(priority = 1)
    public void validLogin() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement successMsg = driver.findElement(By.id("flash"));
        Assert.assertTrue(successMsg.getText().contains("You logged into a secure area!"));
    }

    @Test(priority = 2)
    public void invalidLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("wrongusername");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement errorMsg = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMsg.getText().contains("Your username is invalid!"));
    }

    @Test(priority = 3)
    public void emptyFields() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement errorMsg = driver.findElement(By.id("flash"));
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
