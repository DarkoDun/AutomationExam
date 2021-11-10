package com.automationpractice.tests;

import com.automationpractice.pages.*;
import org.testng.annotations.Test;

public class ProductsManipulationTest extends BaseTest{

    @Test
    public void addToCartAllItemsFromSummerDressPage(){
        String expectedSum = "3 Products";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSummerDressFromDressSubMenu();
        homePage.assertIfCartEmpty();
        SummerDressPage summerDressPage = new SummerDressPage(driver);
        summerDressPage.addAllThreeSummerDressItemsDressesToCart();
        homePage.clickCartPageButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.assertSumOfProductsInCart(expectedSum);
        cartPage.assertActualAndExpectedItemsSKUForSummerDress();
    }

    @Test
    public void addItemToWishlist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePageURL();
        homePage.assertIfCartEmpty();
        homePage.movePointerToBlouseItemAndAddToWishlist();
        WishlistPage wishlistPage = new WishlistPage(driver);
        wishlistPage.goToWishlistURL();
        wishlistPage.clickOnViewButton();
        wishlistPage.waitAndAssertTitles();
    }

    @Test
    public void buyBlouse10pcsWhiteColorSizeL() throws InterruptedException {
        String expectedSum = "10 Products";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePageURL();
        homePage.movePointerToBlouseAdd10pcsSizeLWhiteColorAndProccedToCheckhout();
        CartPage cartPage = new CartPage(driver);
        cartPage.listActualInventoryItems();
        cartPage.assertActualAndExpectedItemsSKUForBlouseShopp();
        cartPage.assertSumOfProductsInCart(expectedSum);
        cartPage.assertBluseDescriptionWhiteL();
        cartPage.goThroughAllTheStepsAndConfirmOrderForBlouseWhiteL();
        cartPage.assertTitleOrderConfirmation();
    }
}




