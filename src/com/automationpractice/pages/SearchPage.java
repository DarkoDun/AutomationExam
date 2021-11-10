package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(className = "heading-counter")
    WebElement searchResultQuantity;        // Ovde mi je bio cilj da napravim IF loop - Ako search result ima vise od 1 rezultata da udje u List metodu listSearchedItems

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
}
