package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.HeaderIconLink;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;


public class MyWebSampleTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MyWebSampleTest.class);
    @Test
    @MethodOwner(owner = "Oleksii")
    public void testSignUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SignUpPage signupPage = homePage.getHeaderMenu().goToSignUpPage();
        signupPage.writeToNicknameTextBox("Test1234567");
        signupPage.writeToEmailTextBox("test1@gmail.com");
        signupPage.writeToPasswordTextBox("12345Qwerty!");
        signupPage.confirmEverything();
        signupPage.clickSubmitButton();
        assertTrue(signupPage.getRegistrationResult().contains("Your account was created."),
                "your registration has not been successful");

    }

    @Test
    @MethodOwner(owner = "Oleksii")
    public void testLogIN() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().clickHeaderMenuIcon(HeaderIconLink.LOG_IN);
        homePage.getLoginForm().writeToLoginTextBox("test1@gmail.com");
        homePage.getLoginForm().writeToPasswordTextBox("12345Qwerty!");
        LoginPage loginPage = homePage.getLoginForm().LoginButtonClick();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.isLoggedIn(),true,"Failed: not logged in");
        softAssert.assertAll();

    }
}