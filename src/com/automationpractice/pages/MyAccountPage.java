package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(className = "info-account")
    WebElement myAccWelcomeMessage;

    public MyAccountPage(ChromeDriver driver) {
        super(driver);
    }

    public String welcomeMessage(){
        return myAccWelcomeMessage.getText();
    }
}
