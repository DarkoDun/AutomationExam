package com.automationpractice.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(className = "login") WebElement singinHeaderButton;
    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]") WebElement clickOnCart;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") WebElement listDressesSubMenu;
    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]") WebElement summerDresses;
    @FindBy(className = "ajax_cart_no_product") WebElement emptyCart;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img") WebElement blouseItemImg;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]/span") WebElement moreButtonAtImgs;
    @FindBy(xpath = "//*[@id=\"wishlist_button\"]") WebElement clickOnAddToWishlist;
    @FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div/a") WebElement closeButtonAfterAddingToWishlist;
    @FindBy(id = "search_query_top") WebElement searchFiled;
    @FindBy(name = "submit_search") WebElement clickOnSubmitSearchInSearchField;
    @FindBy(name = "qty") WebElement quantityField;
    @FindBy(name = "group_1") WebElement selectSizeDropDown;
    @FindBy(id = "color_8") WebElement whiteColorButton;
    @FindBy(name = "Submit") WebElement clickOnAddToCartButton;
    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span") WebElement clickOnProceedToCheckout;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/section[5]/div/ul/li/a") List<WebElement> myAccBlockList;

    String[] expectedFont = {"Arial, Helvetica, sans-serif","Arial, Helvetica, sans-serif","Arial, Helvetica, sans-serif","Arial, Helvetica, sans-serif"};
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToHomePageURL(){
        String url = "http://automationpractice.com/index.php";
        driver.navigate().to(url);
    }

    public LoginPage clickOnSigninRedirectButton(){
        singinHeaderButton.click();
        return new LoginPage(driver);
    }

    public CartPage clickCartPageButton(){
        performAction().moveToElement(clickOnCart).doubleClick().perform();
        return new CartPage(driver);
    }

    public void clickOnSummerDressFromDressSubMenu(){
        performAction().moveToElement(listDressesSubMenu).moveToElement(summerDresses).click().perform();
    }

    public boolean assertIfCartEmpty(){
        Assert.assertEquals(emptyCart.getText(),"(empty)","Cart isn't empty!");
        return true;
    }

    public Actions movePointerToBlouseItemAndAddToWishlist() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView();",blouseItemImg);
        performAction().moveToElement(blouseItemImg).moveToElement(moreButtonAtImgs).click().perform();
        performAction().moveToElement(clickOnAddToWishlist).click().perform();
        Thread.sleep(2000);
        closeButtonAfterAddingToWishlist.click();
        return null;
    }

    public CartPage movePointerToBlouseAdd10pcsSizeLWhiteColorAndProccedToCheckhout() throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView();",blouseItemImg);
        performAction().moveToElement(blouseItemImg).moveToElement(moreButtonAtImgs).click().perform();
        quantityField.clear();
        quantityField.sendKeys("10");
        selectIt(selectSizeDropDown).selectByVisibleText("L");
        whiteColorButton.click();
        clickOnAddToCartButton.click();
        waitFor().until(ExpectedConditions.visibilityOf((clickOnProceedToCheckout)));
        clickOnProceedToCheckout.click();
        return new CartPage(driver);
    }

    public SearchPage enterTextToSearchFiledAndSearchIt(String searchString){
        searchFiled.sendKeys(searchString);
        clickOnSubmitSearchInSearchField.click();
        return new SearchPage(driver);
    }

    public String[] fontValueFromBlockMyAcc(){
        List<WebElement> list = myAccBlockList;

        String[] getFontName = new String[list.toArray().length];

        for (int i=0; i <list.toArray().length; i++){
            getFontName[i] = list.get(i).getCssValue("font-family");
        }
        return getFontName;
    }

    public boolean assertFontValue(){
        Assert.assertEquals(Arrays.toString(fontValueFromBlockMyAcc()),Arrays.toString(expectedFont));
        return true;
    }

    public void addingBlouseToCart10pcsWhiteLAndGoThroughAllPagesAndConfirmOrder() throws InterruptedException {
        String expectedSum = "10 Products";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        goToHomePageURL();
        movePointerToBlouseAdd10pcsSizeLWhiteColorAndProccedToCheckhout();
        CartPage cartPage = new CartPage(driver);
        cartPage.listActualInventoryItems();
        cartPage.assertActualAndExpectedItemsSKUForBlouseShopp();
        cartPage.assertSumOfProductsInCart(expectedSum);
        cartPage.assertBluseDescriptionWhiteL();
        cartPage.goThroughAllTheStepsAndConfirmOrderForBlouseWhiteL();
    }
}
