package Pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{

    private final By firstNameField = By.xpath("//input[@id='input-firstname']");
    private final By lastNameField = By.xpath("//input[@id='input-lastname']");
    private final By emailField = By.xpath("//input[@id='input-email']");
    private final By telephoneField = By.xpath("//input[@id='input-telephone']");
    private final By passwordField = By.xpath("//input[@id='input-password']");
    private final By confirmPasswordField = By.xpath("//input[@id='input-confirm']");
    private final By notSubscribeRadioButton = By.xpath("//label[@class='radio-inline']//input[@value='0']");
    private final By agreeCheckBox = By.xpath("//input[@name='agree']");
    private final By continueButton = By.xpath("//input[@value='Continue']");
    private final By attentionText = By.xpath("//div[contains(text(),'First Name must be between')]");

    public RegisterPage enterFirstNameField(String firstName){
        getDriver().findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public RegisterPage enterLastNameField(String lastName){
        getDriver().findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public RegisterPage enterEmailField(String email){
        getDriver().findElement(emailField).sendKeys(email);
        return this;
    }

    public RegisterPage enterTelephoneField(String telephone){
        getDriver().findElement(telephoneField).sendKeys(telephone);
        return this;
    }

    public RegisterPage enterPasswordField(String password){
        getDriver().findElement(passwordField).sendKeys(password);
        return this;
    }

    public RegisterPage enterConfirmPasswordField(String confirmPassword){
        getDriver().findElement(confirmPasswordField).sendKeys(confirmPassword);
        return this;
    }

    public RegisterPage clickOnNotSubscribeRadioButton(){
        getDriver().findElement(notSubscribeRadioButton).click();
        return this;
    }

    public RegisterPage clickOnAgreeCheckBox(){
        getDriver().findElement(agreeCheckBox).click();
        return this;
    }

    public AccountHasBeenCreatedPage clickOnContinueButton(){
        getDriver().findElement(continueButton).click();
        return new AccountHasBeenCreatedPage();
    }

    public RegisterPage clickOnContinueAttentionButton(){
        getDriver().findElement(continueButton).click();
        return new RegisterPage();
    }

    public String getAttentionText(){
        String message = getDriver().findElement(attentionText).getText();
        return message;
    }





}
