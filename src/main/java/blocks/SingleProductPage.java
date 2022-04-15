package blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
@Getter
public class SingleProductPage {


//div[@class='btn-group']/parent::div


    private String productName;
    private String brandName;
    private String price;
    private Double priceAsDouble;


    public SingleProductPage(WebElement container) {

        try {
            this.productName = container.findElement(By.xpath("//h1")).getText();
        } catch (NoSuchElementException e) {
            this.productName = null;
        }

        try {
            this.brandName = container.findElement(By.xpath("//li[contains(text(),'Brand')]/a")).getText();
        } catch (NoSuchElementException e) {
            this.brandName = null;
        }

        try {
            this.price = container.findElement(By.xpath("//h2")).getText();
            this.priceAsDouble = Double.parseDouble(price.substring(1));
        } catch (NoSuchElementException e) {
            this.price = null;
            this.priceAsDouble = null;
        }
    }
}
