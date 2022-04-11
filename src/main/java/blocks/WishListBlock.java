package blocks;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Getter
@Setter
public class WishListBlock {

    private WebElement img;
    private WebElement productName;
    private String productNameAsString;
    private String model;
    private String stock;
    private String unitPrice;


    public WishListBlock(WebElement container) {

        try {
            this.img = container.findElement(By.xpath("//td[1]"));
        }catch (NoSuchElementException e) {
            this.img = null;
        }

        try {
            this.productName = container.findElement(By.xpath("//td[2]"));
            this.productNameAsString = productName.getText();
        }catch (NoSuchElementException e) {
            this.img = null;
        }

        try {
            this.model = container.findElement(By.xpath("//td[3]")).getText();
        }catch (NoSuchElementException e) {
            this.img = null;
        }

        try {
            this.stock = container.findElement(By.xpath("//td[4]")).getText();
        }catch (NoSuchElementException e) {
            this.img = null;
        }

        try {
            this.unitPrice = StringUtils.substringBefore(container.findElement(By.xpath("//td[5]")).getText().trim(), " ");
        }catch (NoSuchElementException e) {
            this.unitPrice = null;
        }
    }
}
