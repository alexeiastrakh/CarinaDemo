package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.FooterMenu;
import com.solvd.carina.demo.gui.components.HeaderButton;
import com.solvd.carina.demo.gui.components.HeaderMenu;
import com.solvd.carina.demo.gui.components.LoginMenu;
import com.solvd.carina.demo.gui.components.FooterButton;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;


public class MyWebSampleTest implements IAbstractTest {

    private static final Logger LOGGER = LogManager.getLogger(MyWebSampleTest.class);
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testSignUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SignUpPage signUpPage = homePage.getHeaderMenu().openSignUpPage();
        signUpPage.fillToNicknameTextBox("Test2345678");
        signUpPage.fillToEmailTextBox("test2345@gmail.com");
        signUpPage.fillToPasswordTextBox("12345Qwerty!");
        signUpPage.confirmTerms();
        signUpPage.clickSubmitButton();
        Assert.assertTrue(signUpPage.getResult().contains("Your account was created."),
                "Your registration is not successful");

    }

    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().openLoginMenu();
        homePage.getLoginForm().fillToLoginTextBox("test2345@gmail.com");
        homePage.getLoginForm().fillToPasswordTextBox("12345Qwerty!");
        LoginPage loginPage = homePage.getLoginForm().LoginButtonClick();
        Assert.assertTrue(loginPage.isLogin(), "Login is not successful");

    }
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testLoginMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().openLoginMenu();
        SoftAssert softAssert = new SoftAssert();
        LoginMenu loginMenu = homePage.getLoginForm();
        softAssert.assertTrue(loginMenu.isLoginTextPresent(),
                "Title login textField is not present");

        softAssert.assertTrue(loginMenu.isLoginTextBoxPresent(), "Email textField is not present");
        softAssert.assertTrue(loginMenu.isLoginTextBoxReadyToEnterValues(), "Can't ready to enter email");
        softAssert.assertTrue(loginMenu.isPasswordTextBoxPresent(), "Password textField is not present");
        softAssert.assertTrue(loginMenu.isPasswordTextBoxReadyToEnterValues(), "Can't ready to enter password");
        softAssert.assertTrue(loginMenu.isLoginButtonPresent(),"Login button is not present");
        loginMenu.hoverLoginButton();
        softAssert.assertTrue(loginMenu.isForgotPasswordButtonPresent(),
                "Forgot my password button is not present");
        softAssert.assertTrue(loginMenu.isForgotPasswordButtonClickable(),
                "Forgot my password button is not clickable");
        softAssert.assertAll();
    }
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testHeaderMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickMenuHumburgerButton();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        SoftAssert softAssert = new SoftAssert();
        for (HeaderButton headerButton:HeaderButton.values()) {
            softAssert.assertTrue(headerMenu.openPage(headerButton),headerButton.getValue()+
                    " page did not open");
            }
        softAssert.assertAll();
        }
    @Test
    @MethodOwner(owner = "YakubT")
    public void testFooter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickFooterMenuButton();
        FooterMenu footerMenu = homePage.getFooterMenu();
        SoftAssert softAssert = new SoftAssert();
        for (FooterButton footerButton: FooterButton.values()) {
            softAssert.assertTrue(footerMenu.openPage(footerButton),footerButton.getValue()+
                    " page did not open");
        }
        softAssert.assertAll();
    }
    }
