package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WishlistPage extends BasePage{

    @FindBy(css = "#wishlist_41201 > td:nth-child(5) > a")
    WebElement viewButton;

    @FindBy(id = "s_title")
    WebElement productTitle;

    public WishlistPage(ChromeDriver driver) {
        super(driver);
    }

    public void goToWishlistURL(){
        String url = "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist";
        driver.navigate().to(url);
    }

    public void clickOnViewButton(){
        viewButton.click();
    }

    public void waitAndAssertTitles(){
        String expectedBlouseText  = "Blouse\n" +
                "S, Black";
        waitFor().until(ExpectedConditions.visibilityOf(productTitle));
        Assert.assertEquals(productTitle.getText(), expectedBlouseText, "Title doesn't exist!");
    }

    public void addBlouseToWishListAndGoToWishlist() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePageURL();
        homePage.movePointerToBlouseItemAndAddToWishlist();
        goToWishlistURL();
        clickOnViewButton();
    }
}
