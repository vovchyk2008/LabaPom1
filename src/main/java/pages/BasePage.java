package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    Actions actions = new Actions(driver);

    //Menu locators
    private final By desktopMenuButton = By.xpath("//li[@class='dropdown']/a[contains(text(),'Desktops')]");
    private final By laptopsAndNotebooksMenuButton = By.xpath("//li[@class='dropdown']/a[contains(text(),'Laptops & Notebooks')]");

    //componentsMenuButton
    private final By componentsMenuButton = By.xpath("//li[@class='dropdown']/a[contains(text(),'Components')]");
    private final By monitorsButton = By.xpath("//div[@class='dropdown-inner']//a[contains(text(),'Monitors')]");


    private final By tabletsMenuButton = By.xpath("//li/a[contains(text(),'Tablets')]");
    private final By softwareMenuButton = By.xpath("//li/a[contains(text(),'Software')]");
    private final By camerasMenuButton = By.xpath("//li/a[text()='Cameras']");
    private final By mp3PlayersMenuButton = By.xpath("//li[@class='dropdown']/a[text()='MP3 Players']");

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public MonitorsPage clickOnMonitors(){
        actions.moveToElement(find(componentsMenuButton)).build().perform();
        getDriver().findElement(monitorsButton).click();
        return new MonitorsPage();
    }



}
