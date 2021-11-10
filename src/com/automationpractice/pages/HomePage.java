package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(className = "login") WebElement singinHeaderButton;
    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]") WebElement clickOnCart;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a") WebElement listDressesSubMenu;
    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]") WebElement summerDresses;
    @FindBy(className = "ajax_cart_no_product") WebElement emptyCart;
    @FindBy(css = "body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(2) div.center_column.col-xs-12.col-sm-12 div.tab-content ul.product_list.grid.row.homefeatured.tab-pane.active:nth-child(1) li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.last-item-of-mobile-line:nth-child(2) > div.product-container")
    WebElement blouseItemImg; //*[@id="center_column"]/ul/li[2]/div/div[1]/div/a[1]/img
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


    JavascriptExecutor js = (JavascriptExecutor) driver;

    public HomePage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToHomePageURL(){
        String url = "http://automationpractice.com/index.php";
        driver.navigate().to(url);
    }

    public LoginPage clickOnSigninRedirect(){
        singinHeaderButton.click();
        return new LoginPage(driver);
    }

    public CartPage clickCartPageButton(){
        Actions doubleClickOnCart = new Actions(driver);
        doubleClickOnCart.moveToElement(clickOnCart).doubleClick().perform();
        return new CartPage(driver);
    }

    public void clickOnSummerDressFromDressSubMenu(){
        Actions pointerDresses = new Actions(driver);
        pointerDresses.moveToElement(listDressesSubMenu).moveToElement(summerDresses).click().perform();
    }

    public boolean assertIfCartEmpty(){
        Assert.assertEquals(emptyCart.getText(),"(empty)","Cart isn't empty!");
        return true;
    }

    public Actions movePointerToBlouseItemAndAddToWishlist() throws InterruptedException {
        Actions perform = new Actions(driver);
        js.executeScript("arguments[0].scrollIntoView();",blouseItemImg);
        perform.moveToElement(blouseItemImg).moveToElement(moreButtonAtImgs).click().perform();
        perform.moveToElement(clickOnAddToWishlist).click().perform();                               // PAGE?
        Thread.sleep(2000);
        closeButtonAfterAddingToWishlist.click();
        return null;
    }

    public CartPage movePointerToBlouseAdd10pcsSizeLWhiteColorAndProccedToCheckhout() throws InterruptedException {
        Actions perform = new Actions(driver);
        js.executeScript("arguments[0].scrollIntoView();",blouseItemImg);
        perform.moveToElement(blouseItemImg).moveToElement(moreButtonAtImgs).click().perform();
        quantityField.clear();
        quantityField.sendKeys("10");
        Select selectSize = new Select(selectSizeDropDown);
        selectSize.selectByVisibleText("L");
        whiteColorButton.click();
        clickOnAddToCartButton.click();
        WebDriverWait waitContinue = new WebDriverWait(driver,2000);
        waitContinue.until(ExpectedConditions.visibilityOfElementLocated(((By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")))));
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

    public boolean assertFontValue(String expected){
        Assert.assertEquals(Arrays.toString(fontValueFromBlockMyAcc()),expected);
        return true;
    }
}
