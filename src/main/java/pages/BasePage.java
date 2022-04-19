package pages;

import blocks.CurrencyBlock;
import blocks.MenuBlock;
import blocks.TopLinksBlock;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
@Setter
public abstract class BasePage {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    MenuBlock menuBlock = new MenuBlock(driver);

    public MenuBlock getMenuBlock() {
        return menuBlock;
    }

    CurrencyBlock currencyBlock = new CurrencyBlock(getDriver());

    public CurrencyBlock getCurrencyBlock() {
        return currencyBlock;
    }
    TopLinksBlock topLinksBlock = new TopLinksBlock(getDriver());

    public TopLinksBlock getTopLinksBlock() {
        return topLinksBlock;
    }

}
