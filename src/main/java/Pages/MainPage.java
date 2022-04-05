package Pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage{

    private final By myAccountIcon = By.xpath("//span[text()='My Account']");
    private final By registrationButton = By.xpath("//a[text()='Register']");
    private final By loginButton = By.xpath("//a[text()='Login']");



    public MainPage clickOnMyAccountIcon(){
        getDriver().findElement(myAccountIcon).click();
        return this;
    }

    public RegisterPage clickOnRegistrationButton(){
        getDriver().findElement(registrationButton).click();
        return new RegisterPage();
    }

    public LoginPage clickOnLoginButton(){
        getDriver().findElement(loginButton).click();
        return new LoginPage();
    }




}
