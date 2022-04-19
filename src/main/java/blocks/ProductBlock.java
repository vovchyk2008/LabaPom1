package blocks;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
@Setter
public class ProductBlock {

    private WebElement img;
    private WebElement nameAsWebElement;
    private String nameAsString;
    private String description;
    private String discountedPrice;
    private String price;
    private Double priceAsDouble;
    private String newPrice;
    private Double newPriceAsDouble;
    private String oldPrice;
    private Double oldPriceAsDouble;
    private String exTax;
    private Double exTaxAsDouble;
    private WebElement addToCartButton;
    private WebElement addToWishListButton;
    private WebElement compareWithProductButton;


    public ProductBlock(WebElement container) {
        try {
            this.img = container.findElement(By.xpath(".//div[@class='image']/a"));
        } catch (NoSuchElementException e) {
            this.img = null;
        }

        try {
            this.nameAsWebElement = container.findElement(By.xpath(".//div[@class='caption']//a"));
            this.nameAsString = nameAsWebElement.getText();
        } catch (NoSuchElementException e) {
            this.nameAsWebElement = null;
            this.nameAsString = null;
        }

        try {
            this.description = container.findElement(By.xpath(".//div[@class='caption']//p[1]")).getText();
        } catch (NoSuchElementException e) {
            this.description = null;
        }

        try {
            this.price = container.findElement(By.xpath(".//p[@class='price']")).getText().substring(0,6);
            this.priceAsDouble = Double.parseDouble(price.substring(1));
        } catch (NoSuchElementException e) {
            this.price = null;
            this.priceAsDouble = null;
        }

        try {
            this.newPrice = container.findElement(
                    By.xpath(".//p[@class='price']//span[@class='price-new']")).getText();
            this.newPriceAsDouble = Double.parseDouble(newPrice.substring(1));
        } catch (NoSuchElementException e) {
            this.newPrice = null;
            this.newPriceAsDouble = null;
        }

        try {
            this.oldPrice = container.findElement(
                    By.xpath(".//p[@class='price']//span[@class='price-old']")).getText();
            this.oldPriceAsDouble = Double.parseDouble(oldPrice.substring(1));
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
            this.oldPriceAsDouble = null;
        }

        try {
            this.exTax = container.findElement(
                    By.xpath(".//p[@class='price']//span[@class='price-tax']")).getText()
                    .replace("Ex Tax: ", "");
            this.exTaxAsDouble = Double.parseDouble(exTax.substring(1));
        } catch (NoSuchElementException e) {
            this.exTax = null;
            this.exTaxAsDouble = null;
        }

        try {
            this.addToCartButton = container.findElement(By.xpath(".//button[contains(@onclick,'cart')]"));
        } catch (NoSuchElementException e) {
            this.addToCartButton = null;
        }

        try {
            this.addToWishListButton = container.findElement(By.xpath(".//button[contains(@onclick,'wishlist')]"));
        } catch (NoSuchElementException e) {
            this.addToWishListButton = null;
        }

        try {
            this.compareWithProductButton = container.findElement(By.xpath(".//button[contains(@onclick, 'compare')]"));
        } catch (NoSuchElementException e) {
            this.compareWithProductButton = null;
        }
    }
}
