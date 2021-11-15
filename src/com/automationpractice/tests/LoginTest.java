package com.automationpractice.tests;

import com.automationpractice.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        loginPage.assertSuccessfullLoginMessage();
    }

    @Test
    public void tryToLoginWithWrongData(){     // Validate error login with non-existent email and pass without special characters.
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryWrongLoginData();
        loginPage.assertWrongLoginDataMessage();
    }

    @Test
    public void tryToRegisterWithUsedEmail(){  // Validate is error displayed when trying to register with used email.

        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryRegisterWithUsedEmail();
        loginPage.assertUsedEmailRegister();
    }
}
