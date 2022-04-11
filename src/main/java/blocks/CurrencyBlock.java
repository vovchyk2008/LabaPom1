package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class CurrencyBlock {

    private final By currencyButton = By.xpath("//form[@id='form-currency']");
    private final By dollar = By.xpath("//button[@name='USD']");
    private final By euro = By.xpath("//button[@name='EUR']");
    private final By sterling = By.xpath("//button[@name='GBP']");

    private static WebDriver driver;


    public CurrencyBlock(WebDriver webDriver) {
        driver = webDriver;
    }

    public void chooseDollarCurrency(){
        driver.findElement(currencyButton).click();
        driver.findElement(dollar).click();
    }

    public void chooseEuroCurrency(){
        driver.findElement(currencyButton).click();
        driver.findElement(euro).click();
    }

    public void chooseSterlingCurrency(){
        driver.findElement(currencyButton).click();
        driver.findElement(sterling).click();
    }

}
