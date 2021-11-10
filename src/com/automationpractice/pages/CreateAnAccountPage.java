package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage extends BasePage{

    @FindBy(id = "uniform-id_gender1") WebElement chooseMaleGender;
    @FindBy(id = "customer_firstname") WebElement nameField;
    @FindBy(id = "customer_lastname") WebElement lastnameField;
    @FindBy(id = "email") WebElement emailField;
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

    public CreateAnAccountPage(ChromeDriver driver) {
        super(driver);
    }

    public void selectGender(){
        chooseMaleGender.click();
    }

    public void waitForGender(){
        WebDriverWait waitGender = new WebDriverWait(driver,200);
        waitGender.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_gender1")));
    }

    public void enterName(String name){
        nameField.sendKeys(name);
    }

    public void enterLastname(String lastname){
        lastnameField.sendKeys(lastname);
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
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

    public void selectDay(String enterDayValue) {
        Select dayOfBirth = new Select(selectDayOfBirth);
        dayOfBirth.selectByValue(enterDayValue);
    }

    public void selectMonth(String enterMonthValue){
        Select monthOfBirth = new Select(selectMonthOfBirth);
        monthOfBirth.selectByValue(enterMonthValue);
    }

    public void selectYear(String enterYearValue){
        Select yearOfBirth = new Select(selectYearOfBirth);
        yearOfBirth.selectByValue(enterYearValue);
    }

    public void selectStateText(String selectStateText){
        Select statedropdown = new Select(selectState);
        statedropdown.selectByVisibleText(selectStateText);
    }
}
