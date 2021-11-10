package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HomeTest extends BaseTest{

    @Test
    public void checkFontInBlockMyAccAtTheBottomOfThePage(){
        String[] expectedFont = {"Arial, Helvetica, sans-serif","Arial, Helvetica, sans-serif","Arial, Helvetica, sans-serif","Arial, Helvetica, sans-serif"};

        HomePage homePage = new HomePage(driver);
        homePage.assertFontValue(Arrays.toString(expectedFont));
    }
}
