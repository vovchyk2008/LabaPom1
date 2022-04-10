package pages;

import blocks.MonitorsProductBlock;
import blocks.WishListBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyWishListPage extends BasePage {

    private final By wishListTable = By.xpath("//table");

    public List<WishListBlock> getAllProductsFromWishList() {
        List<WishListBlock> wishProducts = new ArrayList<>();
        List<WebElement> containers = getDriver().findElements(wishListTable);
        for (WebElement container : containers) {
            WishListBlock wishListBlock = new WishListBlock(container);
            wishProducts.add(wishListBlock);
        }
        return wishProducts;
    }


}
