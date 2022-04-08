package storeTests;

import pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    MainPage mainPage = new MainPage();

    @Test(priority = 1)
    public void checkThatMessageYourAccountHasBeenCreatedAppearsTest(){
        String expectedMessage = "Your Account Has Been Created!";

        String successMessage = mainPage
                .clickOnMyAccountIcon()
                .clickOnRegistrationButton()
                .enterFirstNameField("Elton")
                .enterLastNameField("John")
                .enterEmailField("Elton@mail.com")
                .enterTelephoneField("1111")
                .enterPasswordField("1111")
                .enterConfirmPasswordField("1111")
                .clickOnNotSubscribeRadioButton()
                .clickOnAgreeCheckBox()
                .clickOnContinueButton()
                .getSuccessLabelText();

        Assertions.assertThat(successMessage)
                .as("Must be: " + expectedMessage + "and actual result is: " + successMessage)
                .isEqualTo(expectedMessage);


    }

    @Test(priority = 2)
    public void checkThatMessageFirstNameMustBeBetween1And32CharactersAppearsTest(){
        String expectedAttentionText = "First Name must be between 1 and 32 characters!";


        String attentionText = mainPage
                .clickOnMyAccountIcon()
                .clickOnRegistrationButton()
                .enterLastNameField("John")
                .enterEmailField("Elton@mail.com")
                .enterTelephoneField("1111")
                .enterPasswordField("1111")
                .enterConfirmPasswordField("1111")
                .clickOnNotSubscribeRadioButton()
                .clickOnAgreeCheckBox()
                .clickOnContinueAttentionButton()
                .getAttentionText();

        Assertions.assertThat(attentionText)
                .as("If you not enter first name Attention text must be:" + expectedAttentionText)
                .isEqualTo(expectedAttentionText);

    }

    @Test(priority = 3)
    public void checkThatMyAccountTitleAppearsOnTheLeftMenuTest(){
        String expectedTextLabel = "My Account";

        String textFromMyAccountLabel = mainPage.clickOnMyAccountIcon()
                .clickOnLoginButton()
                .enterEmailInput("Elton@mail.com")
                .enterPasswordInput("1111")
                .clickOnLoginButton()
                .getTextFromMyAccountLabel();

        Assertions.assertThat(textFromMyAccountLabel)
                .as("On the left menu must be appears title: " + expectedTextLabel)
                .isEqualTo(expectedTextLabel);

    }

    @Test
    public void checkThat2ItemsExistInYourWishList(){
        mainPage.clickOnMyAccountIcon()
                .clickOnLoginButton()
                .enterEmailInput("vovchyk20080@gmail.com")
                .enterPasswordInput("1234")
                .clickOnMonitors();
    }
}
