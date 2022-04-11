package pages;

import blocks.MenuBlock;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private final By emailInput = By.xpath("//input[@id='input-email']");
    private final By passwordInput = By.xpath("//input[@id='input-password']");
    private final By loginButton = By.xpath("//input[@value='Login']");


    public LoginPage enterEmailInput(String email){
        getDriver().findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage enterPasswordInput(String password){
        getDriver().findElement(passwordInput).sendKeys(password);
        return this;
    }

    public MyAccountPage clickOnLoginButton(){
        getDriver().findElement(loginButton).click();
        return new MyAccountPage();
    }
}
