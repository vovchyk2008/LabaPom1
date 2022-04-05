package Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
