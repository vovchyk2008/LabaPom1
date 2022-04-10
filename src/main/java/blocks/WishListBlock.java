package blocks;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Getter
@Setter
public class WishListBlock {

    private WebElement img;
    private String productName;
    private String model;
    private String stock;
    private String unitPrice;
    private WebElement addToCartButton;
    private WebElement removeButton;

    //table

    public WishListBlock(WebElement container) {

        this.img = container.findElement(By.xpath("//td[@class='text-center']/a"));
        this.productName = container.findElement(By.xpath("//td[@class='text-left']/a")).getText();
        this.unitPrice = container.findElement(By.xpath("//td[@class='text-right']//div[@class='price']")).getText();

//        this.model = container.findElement(By.xpath(""));
//        this.stock = container.findElement(By.xpath(""));
//        this.addToCartButton = container.findElement(By.xpath(""));
//        this.removeButton = container.findElement(By.xpath(""));

    }
}
