package com.automationpractice.tests;

import com.automationpractice.pages.*;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CreateAnAccountTest extends BaseTest{

    String newAccEmail = "proba3@test.com";
    String name = "RegIme";
    String lastname = "RegPrezime";
    String password = "passwordProba";
    String enterDayValue = "15";
    String enterMonthValue = "11";
    String enterYearValue = "1921";
    String adress = "Test Adresa 14a";
    String city = "Test grad ";
    String postcode = "11000";
    String mobilePhoneNumber = "0603300";
    String selectState = "Florida";
    String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

    String oldAccEmail = "proba1@test.com";

    @Test
    public void createAccount(){

        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirect();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.createAccEmail(newAccEmail);
        loginPage.clickOnSubmitCreateNewAcc();
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.waitForGender();
        createAnAccountPage.selectGender();
        createAnAccountPage.enterName(name);
        createAnAccountPage.enterLastname(lastname);
        createAnAccountPage.enterPassword(password);
        createAnAccountPage.selectDay(enterDayValue);
        createAnAccountPage.selectMonth(enterMonthValue);
        createAnAccountPage.selectYear(enterYearValue);
        createAnAccountPage.enterAdress(adress);
        createAnAccountPage.enterCity(city);
        createAnAccountPage.selectStateText(selectState);
        createAnAccountPage.enterPostcode(postcode);
        createAnAccountPage.enterMobilePhoneNumber(mobilePhoneNumber);
        createAnAccountPage.clickRegister();
        MyAccountPage myAccPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccPage.welcomeMessage(),welcomeMessage, "Welcome message doesn't exist!");
    }

    @Test
    public void tryToRegisterWithUsedEmail(){
        String expectedErrorMessage = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirect();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.createAccEmail(oldAccEmail);
        loginPage.clickOnSubmitCreateNewAcc();
        Assert.assertEquals(loginPage.newAccUsedEmailError(),expectedErrorMessage, "There is no error message with used email test!");
    }
}
