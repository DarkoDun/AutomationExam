package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CreateAnAccountPage extends BasePage{

    @FindBy(id = "uniform-id_gender1") WebElement chooseMaleGender;
    @FindBy(id = "customer_firstname") WebElement nameField;
    @FindBy(id = "customer_lastname") WebElement lastnameField;
    @FindBy(id = "passwd") WebElement passwordField;
    @FindBy(id = "days") WebElement selectDayOfBirth;
    @FindBy(id = "months") WebElement selectMonthOfBirth;
    @FindBy(id = "years") WebElement selectYearOfBirth;
    @FindBy(id = "address1") WebElement adressField;
    @FindBy(id = "city") WebElement cityField;
    @FindBy(id = "id_state") WebElement selectState;
    @FindBy(id = "postcode") WebElement postcodeField;
    @FindBy(id = "phone_mobile") WebElement mobileNumberField;
    @FindBy(id = "submitAccount") WebElement clickOnSubmitAccRegistration;

    String newAccEmail = "mailforexam122@test.com";
    String name = "Exam";
    String lastname = "Examist";
    String password = "passwordExam";
    String enterDayValue = "15";
    String enterMonthValue = "11";
    String enterYearValue = "1921";
    String adress = "Test Adresa 14a";
    String city = "Test grad ";
    String postcode = "11000";
    String mobilePhoneNumber = "0603300";
    String selectStateText = "Florida";
    String expectedWelcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

    public CreateAnAccountPage(ChromeDriver driver) {
        super(driver);
    }

    public void waitAndChooseGender(){
        waitFor().until(ExpectedConditions.visibilityOf(chooseMaleGender));
        chooseMaleGender.click();
    }

    public void enterName(String name){
        nameField.sendKeys(name);
    }

    public void enterLastname(String lastname){
        lastnameField.sendKeys(lastname);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void enterAdress(String adress){
        adressField.sendKeys(adress);
    }

    public void enterCity(String city){
        cityField.sendKeys(city);
    }

    public void enterPostcode(String postcode){
        postcodeField.sendKeys(postcode);
    }

    public void enterMobilePhoneNumber(String mobilePhoneNumber){
        mobileNumberField.sendKeys(mobilePhoneNumber);
    }

    public void clickRegister(){
        clickOnSubmitAccRegistration.click();
    }

    public void selectDay(String enterDayValue){
        selectIt(selectDayOfBirth).selectByValue(enterDayValue);
    }

    public void selectMonth(String enterMonthValue){
        selectIt(selectMonthOfBirth).selectByValue(enterMonthValue);
    }

    public void selectYear(String enterYearValue){
        selectIt(selectYearOfBirth).selectByValue(enterYearValue);
    }

    public void selectStateText(String selectStateText){
        selectIt(selectState).selectByVisibleText(selectStateText);
    }

    public boolean assertWelcomeMessage(){
        MyAccountPage mcAccPage = new MyAccountPage(driver);
        Assert.assertEquals(mcAccPage.welcomeMessage(), expectedWelcomeMessage, "Welcome message doesn't exist!");
        return true;
    }

    public MyAccountPage creatingAccWithAllFilledFields(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninRedirectButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.createAccEmail(newAccEmail);
        loginPage.clickOnSubmitCreateNewAcc();
        waitAndChooseGender();
        enterName(name);
        enterLastname(lastname);
        enterPassword(password);
        selectDay(enterDayValue);
        selectMonth(enterMonthValue);
        selectYear(enterYearValue);
        enterAdress(adress);
        enterCity(city);
        selectStateText(selectStateText);
        enterPostcode(postcode);
        enterMobilePhoneNumber(mobilePhoneNumber);
        clickRegister();
        return new MyAccountPage(driver);
    }
}
