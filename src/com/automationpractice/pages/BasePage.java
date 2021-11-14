package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    ChromeDriver driver;

    public BasePage(ChromeDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Select selectIt (WebElement element){
        Select string = new Select(element);
        return string;
    }

    public WebDriverWait waitFor (){
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        return wait;
    }

    public Actions performAction (){
        Actions action = new Actions(driver);
        return action;
    }
}

