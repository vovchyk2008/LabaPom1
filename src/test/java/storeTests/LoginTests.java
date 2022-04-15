package storeTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.CamerasPage;
import pages.MainPage;

import java.util.List;

public class LoginTests extends BaseTest {
    MainPage mainPage = new MainPage();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().phoneNumber();
    String password = faker.internet().password();


    @Test(priority = 1)
    public void checkThatMessageYourAccountHasBeenCreatedAppearsTest() {
        String expectedMessage = "Your Account Has Been Created!";

        String successMessage = mainPage
                .clickOnMyAccountIcon()
                .clickOnRegistrationButton()
                .enterFirstNameField(firstName)
                .enterLastNameField(lastName)
                .enterEmailField(email)
                .enterTelephoneField(phone)
                .enterPasswordField(password)
                .enterConfirmPasswordField(password)
                .clickOnNotSubscribeRadioButton()
                .clickOnAgreeCheckBox()
                .clickOnContinueButton()
                .getSuccessLabelText();

        Assertions.assertThat(successMessage)
                .as("Must be: " + expectedMessage + "and actual result is: " + successMessage)
                .isEqualTo(expectedMessage);
    }

    @Test(priority = 2)
    public void checkThatMessageFirstNameMustBeBetween1And32CharactersAppearsTest() {
        String expectedAttentionText = "First Name must be between 1 and 32 characters!";


        String attentionText = mainPage
                .clickOnMyAccountIcon()
                .clickOnRegistrationButton()
                .enterLastNameField(lastName)
                .enterEmailField(email)
                .enterTelephoneField(phone)
                .enterPasswordField(password)
                .enterConfirmPasswordField(password)
                .clickOnNotSubscribeRadioButton()
                .clickOnAgreeCheckBox()
                .clickOnContinueAttentionButton()
                .getAttentionText();

        Assertions.assertThat(attentionText)
                .as("If you not enter first name Attention text must be:" + expectedAttentionText)
                .isEqualTo(expectedAttentionText);
    }

    @Test(priority = 3)
    public void checkThatMyAccountTitleAppearsOnTheLeftMenuTest() {
        String expectedTextLabel = "My Account";

        String textFromMyAccountLabel = mainPage.clickOnMyAccountIcon()
                .clickOnLoginButton()
                .enterEmailInput(email)
                .enterPasswordInput(password)
                .clickOnLoginButton()
                .getTextFromMyAccountLabel();

        Assertions.assertThat(textFromMyAccountLabel)
                .as("On the left menu must be appears title: " + expectedTextLabel)
                .isEqualTo(expectedTextLabel);

    }

    @Test(priority = 4)
    public void checkThat2ItemsExistInYourWishList() {
        String expectedProduct1 = "Apple Cinema 30";
        String expectedProduct2 = "Samsung SyncMaster 941BW";

        List<String> namesFromWishList = mainPage.clickOnMyAccountIcon()
                .clickOnLoginButton()
                .enterEmailInput(email)
                .enterPasswordInput(password)
                .getMenuBlock()
                .clickOnMonitors()
                .clickAddToWishList()
                .getTopLinksBlock()
                .clickOnMyWishListButton()
                .getNamesFromWishList();

        Assertions.assertThat(namesFromWishList)
                .as("Products names must be: " + expectedProduct1 + ", " + expectedProduct2)
                .containsExactlyInAnyOrder(expectedProduct1, expectedProduct2);
    }

    @Test(priority = 5)
    public void checkCurrencyPrices() {

        mainPage.getCurrencyBlock()
                .chooseDollarCurrency();
        mainPage.



    }

    @Test(priority = 6)
    public void checkOldNewAndExRatePrices() {

        String firstProduct = "Canon EOS 5D";
        String secondProduct = "Nikon D300";
        double expectedOldPriceProduct = 122.00;
        double expectedNewPriceProduct = 98.00;
        double expectedExPriceProduct = 80.00;

        mainPage.getMenuBlock()
                .clickOnCameras();

        CamerasPage camerasPage = new CamerasPage();
        double actualOldPriceProduct = camerasPage.getOldPriceProduct(firstProduct);
        double actualNewPriceProduct = camerasPage.getNewPriceProduct(firstProduct);
        double actualExPriceProduct = camerasPage.getExPriceProduct(secondProduct);

        softAssertions.assertThat(actualOldPriceProduct)
                .as("Old price must be: " + expectedOldPriceProduct)
                .isEqualTo(expectedOldPriceProduct);

        softAssertions.assertThat(actualNewPriceProduct)
                .as("New price must be: " + expectedNewPriceProduct)
                .isEqualTo(expectedNewPriceProduct);

        softAssertions.assertThat(actualExPriceProduct)
                .as("Ex tax price: " + expectedExPriceProduct)
                .isEqualTo(expectedExPriceProduct);

        softAssertions.assertAll();
    }
}
