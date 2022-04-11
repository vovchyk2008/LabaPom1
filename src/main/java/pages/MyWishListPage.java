package pages;

import blocks.WishListBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyWishListPage extends BasePage {

    private final By wishProductsContainer = By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr");

    public List<WishListBlock> getAllProductsFromWishList() {
        List<WishListBlock> wishProducts = new ArrayList<>();
        List<WebElement> containers = getDriver().findElements(wishProductsContainer);
        for (WebElement container : containers) {
            WishListBlock wishListBlock = new WishListBlock(container);
            wishProducts.add(wishListBlock);
        }
        return wishProducts;
    }

    public List<String> getNamesFromWishList() {
        List<String> namesProducts = new ArrayList<>();
        List<WishListBlock> products = getAllProductsFromWishList();
        for (WishListBlock product : products) {
            namesProducts.add(product.getProductNameAsString());
        }
        return namesProducts;
    }
}
