package com.automationpractice.tests;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String wrongemail = "proba1@proba.com";
    String wrongpassword = "password";
    String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    String authFailedMessage = "Authentication failed.";

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.welcomeMessage(),welcomeMessage);
    }

    @Test
    public void wrongLoginPassword(){                       // NAPRAVI METODU
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirect();
        loginPage.loginEnterEmail(wrongemail);
        loginPage.loginEnterPassword(wrongpassword);
        loginPage.clickSubmitUnSuccLogin();
        Assert.assertEquals(loginPage.signinAuthError(),authFailedMessage, "Something goes wrong with invalid email and password login!");
    }
}
