package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.LoginPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class LoginMenu extends AbstractUIObject {

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/input[@id = \"email\"]")
    private ExtendedWebElement loginTextBox;

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/input[@id = \"upass\"]")
    private ExtendedWebElement passwordTextBox;

    @FindBy(xpath = "//span[@id='login-popup2']//input[@id='email']")
    private ExtendedWebElement emailTextBox;
    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/input[@id = \"nick-submit\"]")
    private ExtendedWebElement loginButton;

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/form/p[text() = 'Login']")
    private ExtendedWebElement loginText;

    @FindBy (xpath = "//*[@id = \"login-popup2\"]/a[@class = \"forgot\"]")
    private ExtendedWebElement isForgotPasswordButton;

    public LoginMenu(WebDriver driver, SearchContext searchContext) {super(driver, searchContext);}

    public void fillToLoginTextBox(String text) {
        loginTextBox.type(text);
    }

    public void fillToPasswordTextBox(String text) {
        passwordTextBox.type(text);
    }

    public LoginPage LoginButtonClick() {
        loginButton.click();
        return new LoginPage(getDriver());
    }

    public boolean isLoginTextPresent() {
        return loginText.isPresent();
    }

    public boolean isLoginTextBoxPresent() {
        return loginTextBox.isPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isPresent();
    }

    public boolean isForgotPasswordButtonPresent() {return isForgotPasswordButton.isPresent();}

    public void hoverLoginButton() {
        loginButton.hover();
    }
    public String getLoginButtonColor() {
        return loginButton.getElement().getCssValue("background-color");
    }

    public boolean isPasswordTextBoxPresent() {
        return passwordTextBox.isPresent();
    }

    public boolean isLoginTextBoxReadyToEnterValues() {

        loginTextBox.type("Something");
        return  true;
    }

    public boolean isPasswordTextBoxReadyToEnterValues() {

        passwordTextBox.type("Something");
        return  true;
    }

    public boolean isForgotPasswordButtonClickable() {
        return isForgotPasswordButton.isClickable();
    }
    public String getEmailErrorMessage() {
        return emailTextBox.getAttribute("validationMessage");
    }

    public String getPasswordErrorMessage() {
        return passwordTextBox.getAttribute("validationMessage");
    }
}