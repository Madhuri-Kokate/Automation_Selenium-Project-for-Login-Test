package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.*;

public class LoginDataDrivenTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        List<Object[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/test/resources/loginData.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            data.add(values);
        }
        br.close();
        return data.toArray(new Object[0][]);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expected) {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement message = driver.findElement(By.id("flash"));
        Assert.assertTrue(message.getText().contains(expected));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
