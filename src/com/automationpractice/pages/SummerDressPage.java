package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SummerDressPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement firstItemPrintedSummerDressImg;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    WebElement firstItemPrintedSummerDressImgAddToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement continueShoppButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement secondItemPrintedSummerDressImg;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")
    WebElement secondItemPrintedSummerDressImgAddToCartButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img")
    WebElement thridItemPrintedChiffonDressImg;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]/span")
    WebElement thridItemPrintedChiffonDressImgAddToCartButton;

    public SummerDressPage(ChromeDriver driver) {
        super(driver);
    }

    public void movePointerToFirstPSDImgAndAddToCart(){
        performAction().moveToElement(firstItemPrintedSummerDressImg).perform();
        waitFor().until(ExpectedConditions.visibilityOf(firstItemPrintedSummerDressImgAddToCartButton));
        performAction().moveToElement(firstItemPrintedSummerDressImgAddToCartButton).click().perform();
    }

    public void movePointerToSecondPSDImgAndAddToCart(){
        performAction().moveToElement(secondItemPrintedSummerDressImg).moveToElement(secondItemPrintedSummerDressImgAddToCartButton).click().perform();
    }

    public void movePointerToThridPChiffonDressImgAndAddToCart(){
        performAction().moveToElement(thridItemPrintedChiffonDressImg).moveToElement(thridItemPrintedChiffonDressImgAddToCartButton).click().perform();
    }

    public void waitForContinueShoppButtonAndClick(){
        waitFor().until(ExpectedConditions.visibilityOf(((continueShoppButton))));
        continueShoppButton.click();
    }

    public void addAllThreeSummerDressItemsDressesToCart(){
        movePointerToFirstPSDImgAndAddToCart();
        waitForContinueShoppButtonAndClick();
        movePointerToSecondPSDImgAndAddToCart();
        waitForContinueShoppButtonAndClick();
        movePointerToThridPChiffonDressImgAndAddToCart();
        waitForContinueShoppButtonAndClick();
    }

    public void addingToCartAllThreeItemsFromSummerDressSubMenu(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSummerDressFromDressSubMenu();
        homePage.assertIfCartEmpty();
        addAllThreeSummerDressItemsDressesToCart();
        homePage.clickCartPageButton();
    }
}
