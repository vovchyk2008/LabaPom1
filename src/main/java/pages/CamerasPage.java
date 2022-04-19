package pages;

import blocks.ProductBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CamerasPage extends BasePage {

    private By productContainer = By.xpath("//div[contains(@class,'product-thumb')]");

    public List<ProductBlock> getProductsFromCamerasCardPage() {
        List<ProductBlock> products = new ArrayList<>();
        List<WebElement> containers = getDriver().findElements(productContainer);
        for (WebElement container : containers) {
            ProductBlock productBlock = new ProductBlock(container);
            products.add(productBlock);
        }
        return products;
    }

    public ProductBlock getProductWithName(List<ProductBlock> products, String productName) {
        for (ProductBlock product : products) {
            if (product.getNameAsString().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException("Cannot find product with name: " + productName);
    }
}