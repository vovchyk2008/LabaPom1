package pages;

import blocks.MenuBlock;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    MenuBlock menuBlock = new MenuBlock();


    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public MonitorsPage clickOnMonitors(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(menuBlock.getComponentsMenuButton())).build().perform();
        getDriver().findElement(menuBlock.getMonitorsButton()).click();
        return new MonitorsPage();
    }


}
