package blocks;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public class MenuBlock {

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
}
