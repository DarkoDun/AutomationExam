package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(css = "#center_column > ul > li h5 > a")
    List<WebElement> searchedListResult;

    public SearchPage(ChromeDriver driver) {
        super(driver);
    }

    public String[] listSearchedItems() {
        List<WebElement> searchedLista = searchedListResult;
        String[] getItemText = new String[searchedLista.toArray().length];

        for (int i = 0; i < searchedLista.toArray().length; i++) {
            getItemText[i] = searchedLista.get(i).getText();
        }
        return getItemText;
    }

    public boolean assertExpectedSearchResult(String searchResult) {
        Assert.assertEquals(Arrays.toString(listSearchedItems()), searchResult, "Search result doesn't equal!");
        return true;
    }

    public void searchChiffonDress(){
        String chiffonDress = "Printed Chiffon Dress";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.enterTextToSearchFiledAndSearchIt(chiffonDress);
    }

    public void searchPrintedDress(){
        String printedDress = "Printed Dress";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage = new HomePage(driver);
        homePage.enterTextToSearchFiledAndSearchIt(printedDress);
    }
}
