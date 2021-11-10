package com.automationpractice.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    ChromeDriver driver;

    @BeforeMethod
    public void driverSetUp(){
        System.setProperty("webdriver.chrome.driver", ".\\driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
