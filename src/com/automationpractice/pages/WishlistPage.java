package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WishlistPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"wishlist_40970\"]/td[5]/a")
    WebElement viewButton;

    @FindBy(id = "s_title")
    WebElement productTitle;

    WebDriverWait wait = new WebDriverWait(driver,2000);

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

    public Assert waitAndAssertTitles(){
        String expectedBlouseText  = "Blouse\n" +
                "S, Black";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s_title")));
        Assert.assertEquals(productTitle.getText(), expectedBlouseText, "Title doesn't exist!");
        return null;
    }
}
