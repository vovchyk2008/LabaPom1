package pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage{

private final By myAccountLabel = By.xpath("//div[@id='content']/h2");

    public String getTextFromMyAccountLabel(){
        return getDriver().findElement(myAccountLabel).getText();

    }

}

