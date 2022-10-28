package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest implements IAbstractTest {
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
}
