package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest implements IAbstractTest{
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
}
