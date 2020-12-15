import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class TestRegister {
    private WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/");
    }

    @Test
    public void register() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();

        assertEquals(driver.getTitle(), "Register Account");

        driver.findElement(By.id("input-firstname")).sendKeys("Tatyana");
        driver.findElement(By.id("input-lastname")).sendKeys("Taneva");
        driver.findElement(By.id("input-email")).sendKeys("tatqna_97@abv.bg");
        driver.findElement(By.id("input-telephone")).sendKeys("0888888888");
        driver.findElement(By.id("input-password")).sendKeys("123258");
        driver.findElement(By.id("input-confirm")).sendKeys("123258");

        WebElement buttonYes = driver.findElement(By.cssSelector("label.radio-inline input[value='1']"));

        if (!buttonYes.isSelected()) {
            buttonYes.click();
        }
        Assert.assertTrue(buttonYes.isSelected());

        WebElement privacyPolicy = driver.findElement(By.name("agree"));

        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
        Assert.assertTrue(privacyPolicy.isSelected());
    }

    @AfterMethod
    public  void closeBrowser() {
        driver.close();
    }

}


