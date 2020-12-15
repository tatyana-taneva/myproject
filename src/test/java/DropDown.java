import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

    public class DropDown {
        private static WebDriver driver;

        @BeforeMethod
        public void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://shop.pragmatic.bg/admin");
        }


    @Test

    public void dropDownTest() {
        driver.findElement(By.id("input-username")).sendKeys("admin");
        driver.findElement(By.id("input-password")).sendKeys("parola123!");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        driver.findElement(By.cssSelector("#menu-sale >a")).click();
        driver.findElement(By.xpath("//a[text()='Orders']")).click();


        WebElement orderStatus = driver.findElement(By.id("input-order-status"));
        Select orderStatusDropDown = new Select(driver.findElement(By.id("input-order-status")));

        List<String> expectedValues = Arrays.asList(
                "",
                "Missing Orders",
                "Canceled",
                "Canceled Reversal",
                "Chargeback",
                "Complete",
                "Denied",
                "Expired",
                "Failed",
                "Pending",
                "Processed",
                "Processing",
                "Refunded",
                "Reversed",
                "Shipped",
                "Voided"
        );

        List<String> actualValues = new ArrayList<>();

        List<WebElement> allDropdownElements = orderStatusDropDown.getOptions();

        for (WebElement curDropdownElements : allDropdownElements) {
            actualValues.add(curDropdownElements.getText());
        }

        Assert.assertEquals(expectedValues, actualValues);
    }

        @AfterMethod
        public void closeBrowser() {
            driver.quit();
        }

    }




