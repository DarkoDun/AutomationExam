package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    String trueEmail = "proba2@test.com";
    String truePass = "passwordProba";

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
        homePage.clickOnSigninRedirect();
        WebDriverWait waitForEmail = new WebDriverWait(driver,200);
        waitForEmail.until(ExpectedConditions.visibilityOf(loginEmail));
        loginEmail.sendKeys(trueEmail);
        loginPassword.sendKeys(truePass);
        submitLogin.click();
        return new HomePage(driver);
    }

    public void clickSubmitUnSuccLogin(){
        submitLogin.click();
    }

    public void createAccEmail(String newAccEmail){
        emailCreateField.sendKeys(newAccEmail);
    }

    public String newAccUsedEmailError(){
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create_account_error")));

        return createAccErrorEmailMessage.getText();
    }
}
