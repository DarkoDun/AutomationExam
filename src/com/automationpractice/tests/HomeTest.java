package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{

    @Test
    public void checkFontInBlockMyAccAtTheBottomOfThePage(){    // Checking font at the bottom of home page in block My Account

        HomePage homePage = new HomePage(driver);
        homePage.assertFontValue();
    }
}
