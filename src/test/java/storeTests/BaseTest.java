package storeTests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        BasePage.setDriver(driver);
    }

    Faker faker = new Faker();
    SoftAssertions softAssertions = new SoftAssertions();

    @AfterMethod
    public void quite() {
        BasePage.getDriver().quit();
    }
}

