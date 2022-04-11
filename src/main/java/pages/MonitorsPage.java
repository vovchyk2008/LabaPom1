package pages;

import blocks.ProductBlock;
import blocks.TopLinksBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MonitorsPage extends BasePage {


    private final By productContainer = By.xpath("//div[@class='product-thumb']");

    TopLinksBlock topLinksBlock = new TopLinksBlock(getDriver());

    public TopLinksBlock getTopLinksBlock() {
        return topLinksBlock;
    }

    public List<ProductBlock> getAllProductsFromMonitorsPage() {
        List<ProductBlock> monitors = new ArrayList<>();
        List<WebElement> containers = getDriver().findElements(productContainer);
        for (WebElement container : containers) {
            ProductBlock monitorsProductBlock = new ProductBlock(container);
            monitors.add(monitorsProductBlock);
        }
        return monitors;
    }

    public MonitorsPage clickAddToWishList() {
        List<ProductBlock> monitors = getAllProductsFromMonitorsPage();
        monitors.get(0).getAddToWishListButton().click();
        monitors.get(1).getAddToWishListButton().click();
        return this;
    }



}