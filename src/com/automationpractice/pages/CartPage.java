package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "summary_products_quantity")
    WebElement sumOfProductsQuantity;

    @FindBy(className = "cart_ref")
    List<WebElement> listOfActualProductsSKU;

    @FindBy(linkText = "Color : White, Size : L")
    WebElement blouseDescriptionWhiteL;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement clickButtonProceedToChechkoutInCartSummary;

    @FindBy(name = "processAddress")
    WebElement clickButtonProceedToChechkoutInProcessAddress;

    @FindBy(name = "cgv")
    WebElement selectChechkboxIAgreeToTheTerms;

    @FindBy(name = "processCarrier")
    WebElement clickButtonProceedToCheckoutAfterIAgree;

    @FindBy(className = "payment_module")
    WebElement clickOnPaymentMethodPayByCheck;

    @FindBy(css = "#cart_navigation > button")
    WebElement clickButtonIConfirmMyOrderInOrderSummary;

    String[] expectedAddedItemsSKUFromSummerDresses = {"SKU : demo_5","SKU : demo_6","SKU : demo_7"};
    String[] expectedAddedItemSKUForBlouse = {"SKU : demo_2"};
    String expectedTitleOrderConfirmation = "Order confirmation - My Store";

    public CartPage(ChromeDriver driver) {
        super(driver);
    }

    public boolean assertSumOfProductsInCart(String expectedSum){
        Assert.assertEquals(sumOfProductsQuantity.getText(),expectedSum, "The sum in cart ins't Equal!");
        return true;
    }

    public String[] listActualInventoryItems(){
        String[] actualItemsSKUText = new String[listOfActualProductsSKU.toArray().length];

        for (int i=0; i <listOfActualProductsSKU.toArray().length; i++){
            actualItemsSKUText[i] = listOfActualProductsSKU.get(i).getText();
        }
        return actualItemsSKUText;
    }

    public boolean assertActualAndExpectedItemsSKUForSummerDress(){
        Assert.assertEquals(listActualInventoryItems(),expectedAddedItemsSKUFromSummerDresses,"Cart SKU for summer dresses doesn't equal!");
        return true;
    }

    public boolean assertActualAndExpectedItemsSKUForBlouseShopp(){
        Assert.assertEquals(listActualInventoryItems(),expectedAddedItemSKUForBlouse, "Cart SKU for Blose doesn't equal!");
        return true;
    }

    public boolean assertBluseDescriptionWhiteL(){
        Assert.assertEquals(blouseDescriptionWhiteL.getText(),"Color : White, Size : L", "Description isn't equal!");
        return true;
    }

    public void clickOnProccedToCheckout(){
        clickButtonProceedToChechkoutInCartSummary.click();
    }

    public void clickOnProccedToCheckoutInAdressStep(){
        clickButtonProceedToChechkoutInProcessAddress.click();
    }

    public void selectCheckBoxIAgreeInShippingStep(){
        selectChechkboxIAgreeToTheTerms.click();
    }

    public void clickProceedToCheckoutInShippingStep(){
        clickButtonProceedToCheckoutAfterIAgree.click();
    }

    public void chosePaymentMethodPayByCheck(){
        clickOnPaymentMethodPayByCheck.click();
    }

    public void clickIConfirmMyOrderInOrderSummary(){
        clickButtonIConfirmMyOrderInOrderSummary.click();
    }

    public boolean assertTitleOrderConfirmation(){
        Assert.assertEquals(driver.getTitle(),expectedTitleOrderConfirmation, "Order confirmation Title isn't same od doesn't exist!" );
        return true;
    }

    public void goThroughAllTheStepsAndConfirmOrderForBlouseWhiteL(){
        clickOnProccedToCheckout();
        clickOnProccedToCheckoutInAdressStep();
        selectCheckBoxIAgreeInShippingStep();
        clickProceedToCheckoutInShippingStep();
        chosePaymentMethodPayByCheck();
        clickIConfirmMyOrderInOrderSummary();
    }
}
