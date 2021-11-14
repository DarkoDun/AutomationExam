package com.automationpractice.tests;

import com.automationpractice.pages.*;
import org.testng.annotations.Test;

public class CreateAnAccountTest extends BaseTest{

    @Test
    public void createAccount(){  // Fill in all fields and confirm the Created account.

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.creatingAccWithAllFilledFields();
        createAnAccountPage.assertWelcomeMessage();
    }
}
