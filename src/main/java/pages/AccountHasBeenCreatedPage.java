package pages;

import org.openqa.selenium.By;

public class AccountHasBeenCreatedPage extends BasePage{

    private final By successLabel = By.xpath("//div[@id='content']/h1");

    public String getSuccessLabelText(){
        String message = getDriver().findElement(successLabel).getText();
        return message;
    }
}
