package pages;

import blocks.ProductBlock;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MainPage extends BasePage {

    private final By myAccountIcon = By.xpath("//span[text()='My Account']");
    private final By registrationButton = By.xpath("//a[text()='Register']");
    private final By loginButton = By.xpath("//a[text()='Login']");
    private By productContainer = By.xpath("//div[contains(@class,'product-thumb')]");


    public MainPage clickOnMyAccountIcon() {
        getDriver().findElement(myAccountIcon).click();
        return this;
    }

    public RegisterPage clickOnRegistrationButton() {
        getDriver().findElement(registrationButton).click();
        return new RegisterPage();
    }

    public LoginPage clickOnLoginButton() {
        getDriver().findElement(loginButton).click();
        return new LoginPage();
    }

    public List<ProductBlock> getAllProductsFromMainPage() {
        List<ProductBlock> products = new ArrayList<>();
        List<WebElement> containers = getDriver().findElements(productContainer);
        for (WebElement container : containers) {
            ProductBlock productBlock = new ProductBlock(container);
            products.add(productBlock);
        }
        return products;
    }

    public SingleProductPage clickOnProductWithName(List<ProductBlock> products, String productName){
        ProductBlock product = products.stream()
                .filter(p -> p.getNameAsString().equals(productName))
                .findFirst().get();
        product.getImg().click();
        return new SingleProductPage();
    }
}
