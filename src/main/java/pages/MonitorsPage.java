package pages;

import blocks.MonitorsProductBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MonitorsPage extends BasePage {

    private final By wishListButton = By.xpath("//div[@id='top-links']//span[contains(text(),'Wish List')]");

    private final By monitorsContainer = By.xpath("//div[@class='product-thumb']");


    public List<MonitorsProductBlock> getAllProductsFromMonitorsPage() {
        List<MonitorsProductBlock> monitors = new ArrayList<>();
        List<WebElement> containers = getDriver().findElements(monitorsContainer);
        for (WebElement container : containers) {
            MonitorsProductBlock monitorsProductBlock = new MonitorsProductBlock(container);
            monitors.add(monitorsProductBlock);
        }
        return monitors;
    }

    public MonitorsPage clickAddToWishList() {
        List<MonitorsProductBlock> monitors = getAllProductsFromMonitorsPage();
        monitors.get(0).getAddToWishListButton().click();
        monitors.get(1).getAddToWishListButton().click();
        return this;
    }

    public MyWishListPage clickOnMyWishList() {
        getDriver().findElement(wishListButton).click();
        return new MyWishListPage();
    }

}