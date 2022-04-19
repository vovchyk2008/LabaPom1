package pages;

import blocks.SingleProductBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SingleProductPage extends BasePage {

    private final By singleProductContainer = By.xpath("//div[@class='btn-group']/parent::div");

    public SingleProductBlock getProductInfo(){
        WebElement container = getDriver().findElement(singleProductContainer);
        return new SingleProductBlock(container);
    }
}