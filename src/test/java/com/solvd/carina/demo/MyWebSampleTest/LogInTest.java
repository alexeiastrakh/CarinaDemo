package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.MyWebSampleTest.dataProvider.DataProviderLogIn;
import com.solvd.carina.demo.gui.components.LoginMenu;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogInTest implements IAbstractTest{
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testLogIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().openLoginMenu();
        homePage.getLoginMenu().fillToLoginTextBox("test2345@gmail.com");
        homePage.getLoginMenu().fillToPasswordTextBox("12345Qwerty!");
        LoginPage loginPage = homePage.getLoginMenu().LoginButtonClick();
        Assert.assertTrue(loginPage.isLogin(), "Login is not successful");

    }
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testLoginMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().openLoginMenu();
        SoftAssert softAssert = new SoftAssert();
        LoginMenu loginMenu = homePage.getLoginMenu();
        softAssert.assertTrue(loginMenu.isLoginTextPresent(),
                "Title login textField is not present");
        softAssert.assertTrue(loginMenu.isLoginTextBoxPresent(), "Email textField is not present");
        softAssert.assertTrue(loginMenu.isLoginTextBoxReadyToEnterValues(), "Can't ready to enter email");
        softAssert.assertTrue(loginMenu.isPasswordTextBoxPresent(), "Password textField is not present");
        softAssert.assertTrue(loginMenu.isPasswordTextBoxReadyToEnterValues(), "Can't ready to enter password");
        softAssert.assertTrue(loginMenu.isLoginButtonPresent(), "Login button is not present");
        loginMenu.hoverLoginButton();
        softAssert.assertTrue(loginMenu.isForgotPasswordButtonPresent(),
                "Forgot my password button is not present");
        softAssert.assertTrue(loginMenu.isForgotPasswordButtonClickable(),
                "Forgot my password button is not clickable");
        softAssert.assertAll();
    }

    @Test(description = "test unsuccessful login", dataProvider = "login scenarios",
            dataProviderClass = DataProviderLogIn.class)
    @MethodOwner(owner = "OleksiiA")
    public void testLoginUnSuccessfulDataProvider(String login, String password,  String emailErrorMessage, String passwordErrorMessage) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.getHeaderMenu().openLoginMenu();
        LoginMenu loginMenu = homePage.getLoginMenu();
        loginMenu.fillToLoginTextBox(login);
        loginMenu.fillToPasswordTextBox(password);
        loginMenu.LoginButtonClick();
        Assert.assertTrue(loginMenu.isLoginTextPresent(),
                "Title login textField is not present");
        Assert.assertTrue(loginMenu.isLoginTextBoxPresent(), "Email textField is not present");
        Assert.assertEquals(loginMenu.getEmailErrorMessage(), emailErrorMessage, "incorrect validation message");
        Assert.assertEquals(loginMenu.getPasswordErrorMessage(), passwordErrorMessage, "incorrect validation message");

    }

    }


