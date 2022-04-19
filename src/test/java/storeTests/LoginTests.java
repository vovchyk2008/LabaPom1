package storeTests;

import blocks.ProductBlock;
import blocks.SingleProductBlock;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.CamerasPage;
import pages.MainPage;
import pages.SingleProductPage;

import java.util.List;

public class LoginTests extends BaseTest {


    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().phoneNumber();
    String password = faker.internet().password();


    @Test(priority = 1)
    public void checkThatMessageYourAccountHasBeenCreatedAppearsTest() {
        String expectedMessage = "Your Account Has Been Created!";
        MainPage mainPage = new MainPage();
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
        MainPage mainPage = new MainPage();

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
        MainPage mainPage = new MainPage();

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
        MainPage mainPage = new MainPage();

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
        MainPage mainPage = new MainPage();

        mainPage.getCurrencyBlock()
                .chooseDollarCurrency();
        List<ProductBlock> allProductsFromMainPage = mainPage.getAllProductsFromMainPage();
        SingleProductBlock iPhoneInfo = mainPage.clickOnProductWithName(allProductsFromMainPage, "iPhone")
                .getProductInfo();

        String expectedPriceInDollars = "$123.20";
        String actualPriceInDollar = iPhoneInfo.getPrice();

        Assertions.assertThat(actualPriceInDollar)
                .as("We expect on price: " + expectedPriceInDollars)
                .isEqualTo(expectedPriceInDollars);

        SingleProductPage singleProductPage = new SingleProductPage();
        singleProductPage.getCurrencyBlock().chooseEuroCurrency();
        iPhoneInfo = singleProductPage.getProductInfo();

        String expectedPriceInEuro = "106.04€";
        String actualPriceInEuro = iPhoneInfo.getPrice();

        Assertions.assertThat(actualPriceInEuro)
                .as("We expect on price: " + expectedPriceInEuro)
                .isEqualTo(expectedPriceInEuro);

        singleProductPage.getCurrencyBlock().chooseSterlingCurrency();
        iPhoneInfo = singleProductPage.getProductInfo();

        String expectedPriceInPoundSterling = "£95.32";
        String actualPriceInPoundSterling = iPhoneInfo.getPrice();

        Assertions.assertThat(actualPriceInPoundSterling)
                .as("We expect on price: " + expectedPriceInPoundSterling)
                .isEqualTo(expectedPriceInPoundSterling);

    }

    @Test(priority = 6)
    public void checkOldNewAndExRatePrices() {
        String canonProductName = "Canon EOS 5D";
        String nikonProductName = "Nikon D300";
        double expectedOldPriceProduct = 122.00;
        double expectedNewPriceProduct = 98.00;
        double expectedExPriceProduct = 80.00;

        MainPage mainPage = new MainPage();
        List<ProductBlock> productsFromCamerasCardPage = mainPage.getMenuBlock()
                .clickOnCameras().getProductsFromCamerasCardPage();

        CamerasPage camerasPage = new CamerasPage();
        ProductBlock canonProduct = camerasPage.getProductWithName(productsFromCamerasCardPage, canonProductName);
        ProductBlock nikonProduct = camerasPage.getProductWithName(productsFromCamerasCardPage, nikonProductName);


        softAssertions.assertThat(canonProduct.getOldPriceAsDouble())
                .as("Old price must be: " + expectedOldPriceProduct)
                .isEqualTo(expectedOldPriceProduct);

        softAssertions.assertThat(canonProduct.getNewPriceAsDouble())
                .as("New price must be: " + expectedNewPriceProduct)
                .isEqualTo(expectedNewPriceProduct);

        softAssertions.assertThat(nikonProduct.getExTaxAsDouble())
                .as("Ex tax price: " + expectedExPriceProduct)
                .isEqualTo(expectedExPriceProduct);

        softAssertions.assertAll();
    }
}
