package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String oldAccEmail = "mailforexam@test.com";

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        loginPage.assertSuccessfullLoginMessage();
    }

    @Test
    public void tryToLoginWithWrongData(){     // Validate error login with non-existent email and pass without special characters.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryWrongLoginData();
        loginPage.assertWrongLoginDataMessage();
    }

    @Test
    public void tryToRegisterWithUsedEmail(){  // Validate is error displayed when trying to register with used email.

        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirectButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.createAccEmail(oldAccEmail);
        loginPage.clickOnSubmitCreateNewAcc();
        loginPage.assertUsedEmailRegister();
    }
}
