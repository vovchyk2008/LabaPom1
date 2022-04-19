package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CurrencyBlock {

    private final By currencyButton = By.xpath("//form[@id='form-currency']");
    private final By dollar = By.xpath("//button[@name='USD']");
    private final By euro = By.xpath("//button[@name='EUR']");
    private final By sterling = By.xpath("//button[@name='GBP']");
    private final By currencyMark = By.xpath("//button[@class='btn btn-link dropdown-toggle']/strong");


    private static WebDriver driver;
    private static WebDriverWait wait;

    public CurrencyBlock(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void chooseDollarCurrency() {
        if (!driver.findElement(currencyMark).getText().equals("$")) {
            driver.findElement(currencyButton).click();
            driver.findElement(dollar).click();
        }
    }

    public void chooseEuroCurrency() {
        driver.findElement(currencyButton).click();
        driver.findElement(euro).click();
    }

    public void chooseSterlingCurrency() {
        driver.findElement(currencyButton).click();
        driver.findElement(sterling).click();
    }

}
