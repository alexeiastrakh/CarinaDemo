package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.LoginMenu;
import com.solvd.carina.demo.gui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLoginMenu implements IAbstractTest {
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
}
