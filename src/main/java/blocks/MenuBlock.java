package blocks;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CamerasPage;
import pages.MonitorsPage;

@Getter
@Setter
public class MenuBlock {

    private static WebDriver driver;
    private static Actions actions;

    public MenuBlock(WebDriver webDriver) {
        driver = webDriver;
        actions = new Actions(driver);
    }

    private final By componentsMenuButton = By.xpath("//li[@class='dropdown']/a[contains(text(),'Components')]");
    private final By monitorsButton = By.xpath("//div[@class='dropdown-inner']//a[contains(text(),'Monitors')]");
    private final By camerasMenuButton = By.xpath("//li/a[text()='Cameras']");

    public MonitorsPage clickOnMonitors() {
        actions.moveToElement(driver.findElement(componentsMenuButton)).build().perform();
        driver.findElement(monitorsButton).click();
        return new MonitorsPage();
    }

    public CamerasPage clickOnCameras() {
        driver.findElement(camerasMenuButton).click();
        return new CamerasPage();
    }
}


//Menu locators
//    private final By desktopMenuButton = By.xpath("//li[@class='dropdown']/a[contains(text(),'Desktops')]");
//    private final By laptopsAndNotebooksMenuButton = By.xpath("//li[@class='dropdown']/a[contains(text(),'Laptops & Notebooks')]");
//    private final By tabletsMenuButton = By.xpath("//li/a[contains(text(),'Tablets')]");
//    private final By softwareMenuButton = By.xpath("//li/a[contains(text(),'Software')]");
//    private final By mp3PlayersMenuButton = By.xpath("//li[@class='dropdown']/a[text()='MP3 Players']");

