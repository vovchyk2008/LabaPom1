package pages;

import blocks.SingleProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IPhonePage extends BasePage{


    private final By singleProductContainer = By.xpath("//div[@class='btn-group']/parent::div");


    public IPhonePage clickOnIPhone(){
        List<WebElement> fieldOfProduct = getDriver().findElements(singleProductContainer);
       

}
