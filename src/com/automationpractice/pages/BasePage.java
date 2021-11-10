package com.automationpractice.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    ChromeDriver driver;

    public BasePage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
