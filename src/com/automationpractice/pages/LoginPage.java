package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    WebElement loginEmail;

    @FindBy(id = "passwd")
    WebElement loginPassword;

    @FindBy(id = "SubmitLogin")
    WebElement submitLogin;

    @FindBy(id = "email_create")
    WebElement emailCreateField;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreateNewAcc;

    @FindBy(css = "div.alert.alert-danger ol:nth-child(2) > li:nth-child(1)")
    WebElement authErrorMessage;

    @FindBy(id = "create_account_error")
    WebElement createAccErrorEmailMessage;

    String trueEmail = "mailforexam@test.com";
    String truePass = "passwordExam";
    String wrongemail = "proba1@proba.com";
    String wrongpassword = "password";
    String oldAccEmail = "mailforexam@test.com";
    String expectedWelcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    String expectedAuthFailedMessage = "Authentication failed.";
    String expectedUsedEmailErrorMessage = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

    public LoginPage(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void loginEnterEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void loginEnterPassword(String password){
        loginPassword.sendKeys(password);
    }

    public String signinAuthError(){
        return authErrorMessage.getText();
    }

    public LoginPage clickOnSubmitCreateNewAcc(){
        submitCreateNewAcc.click();
        return new LoginPage (driver);
    }

    public HomePage login(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirectButton();
        waitFor().until(ExpectedConditions.visibilityOf(loginEmail));
        loginEmail.sendKeys(trueEmail);
        loginPassword.sendKeys(truePass);
        submitLogin.click();
        return new HomePage(driver);
    }

    public LoginPage tryWrongLoginData(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirectButton();
        loginEnterEmail(wrongemail);
        loginEnterPassword(wrongpassword);
        clickSubmitUnSuccLogin();
        return new LoginPage(driver);
    }

    public LoginPage tryRegisterWithUsedEmail(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirectButton();
        createAccEmail(oldAccEmail);
        clickOnSubmitCreateNewAcc();
        return new LoginPage(driver);
    }

    public void clickSubmitUnSuccLogin(){
        submitLogin.click();
    }

    public void createAccEmail(String newAccEmail){
        waitFor().until(ExpectedConditions.visibilityOf(emailCreateField));
        emailCreateField.sendKeys(newAccEmail);
    }

    public String newAccUsedEmailError(){
        waitFor().until(ExpectedConditions.visibilityOf(createAccErrorEmailMessage));

        return createAccErrorEmailMessage.getText();
    }

    public boolean assertUsedEmailRegister(){
        Assert.assertEquals(newAccUsedEmailError(),expectedUsedEmailErrorMessage, "There is no error message with used email test!");
        return true;
    }

    public boolean assertSuccessfullLoginMessage(){
        MyAccountPage myAccPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccPage.welcomeMessage(),expectedWelcomeMessage, "Expected Welcome message doesn't exist!");
        return true;
    }

    public boolean assertWrongLoginDataMessage(){
        Assert.assertEquals(signinAuthError(),expectedAuthFailedMessage, "Something goes wrong with invalid email and password login!");
        return true;
    }
}
