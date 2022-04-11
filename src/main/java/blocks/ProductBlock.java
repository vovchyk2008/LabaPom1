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
    private String newPrice;
    private String oldPrice;
    private String exTax;
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
            this.price = StringUtils.substringBefore(
                    container.findElement(By.xpath(".//p[@class='price']")).getText().trim(), " ");
        } catch (NoSuchElementException e) {
            this.price = null;
        }

        try {
            this.newPrice = container.findElement(By.xpath(".//p[@class='price']//span[@class='price-new']")).getText();
        } catch (NoSuchElementException e) {
            this.newPrice = null;
        }

        try {
            this.oldPrice = container.findElement(By.xpath(".//p[@class='price']//span[@class='price-old']")).getText();
        } catch (NoSuchElementException e) {
            this.oldPrice = null;
        }

        try {
            this.exTax = container.findElement(By.xpath(".//p[@class='price']//span[@class='price-tax']")).getText();
        } catch (NoSuchElementException e) {
            this.exTax = null;
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
