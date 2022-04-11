package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MyWishListPage;


public class TopLinksBlock {

    private static WebDriver driver;

    public TopLinksBlock(WebDriver webDriver){
        driver = webDriver;
    }

    private final By wishListMenuButton = By.xpath("//a[@id='wishlist-total']");

    public MyWishListPage clickOnMyWishListButton() {
        driver.findElement(wishListMenuButton).click();
        return new MyWishListPage();
    }

}
