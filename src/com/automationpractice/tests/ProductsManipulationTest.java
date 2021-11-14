package com.automationpractice.tests;

import com.automationpractice.pages.*;
import org.testng.annotations.Test;

public class ProductsManipulationTest extends BaseTest{

    @Test
    public void addToCartAllItemsFromSummerDressPage(){  // Add and validate items in cart.
        String expectedSum = "3 Products";

        SummerDressPage summerDressPage = new SummerDressPage(driver);
        summerDressPage.addingToCartAllThreeItemsFromSummerDressSubMenu();
        CartPage cartPage = new CartPage(driver);
        cartPage.assertSumOfProductsInCart(expectedSum);
        cartPage.assertActualAndExpectedItemsSKUForSummerDress();
    }

    @Test
    public void addBlouseToWishlist() throws InterruptedException { // Add Blouse to Wish list and validate it.

        WishlistPage wishlistPage = new WishlistPage(driver);
        wishlistPage.addBlouseToWishListAndGoToWishlist();
        wishlistPage.waitAndAssertTitles();
    }

    @Test
    public void buyBlouse10pcsWhiteColorSizeL() throws InterruptedException {  // At the Home page select more options on item Blouse and choose 10pcs, white color, size L and validate buy.

        HomePage homePage = new HomePage(driver);
        homePage.addingBlouseToCart10pcsWhiteLAndGoThroughAllPagesAndConfirmOrder();
        CartPage cartPage = new CartPage(driver);
        cartPage.assertTitleOrderConfirmation();
    }
}




