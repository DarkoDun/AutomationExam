package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img") WebElement firstItemPrintedSummerDressImg;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span") WebElement firstItemPrintedSummerDressImgAddToCartButton;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span") WebElement continueShoppButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img") WebElement secondItemPrintedSummerDressImg;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span") WebElement secondItemPrintedSummerDressImgAddToCartButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img") WebElement thridItemPrintedChiffonDressImg;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[2]/div[2]/a[1]/span") WebElement thridItemPrintedChiffonDressImgAddToCartButton;

    public SummerDressPage(ChromeDriver driver) {
        super(driver);
    }

    public Actions movePointerToFirstPSDImgAndAddToCart(){
        Actions perform = new Actions(driver);
        perform.moveToElement(firstItemPrintedSummerDressImg).moveToElement(firstItemPrintedSummerDressImgAddToCartButton).click().perform();
        return null;
    }

    public Actions movePointerToSecondPSDImgAndAddToCart(){
        Actions perform = new Actions(driver);
        perform.moveToElement(secondItemPrintedSummerDressImg).moveToElement(secondItemPrintedSummerDressImgAddToCartButton).click().perform();
        return null;
    }

    public Actions movePointerToThridPChiffonDressImgAndAddToCart(){
        Actions perfrom = new Actions(driver);
        perfrom.moveToElement(thridItemPrintedChiffonDressImg).moveToElement(thridItemPrintedChiffonDressImgAddToCartButton).click().perform();
        return null;
    }

    public void waitForContinueShoppButtonAndClick(){
        WebDriverWait waitContinue = new WebDriverWait(driver,200);
        waitContinue.until(ExpectedConditions.visibilityOfElementLocated(((By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")))));
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
}
