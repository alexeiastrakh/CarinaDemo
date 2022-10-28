package com.solvd.carina.demo.gui.components;

import com.azure.core.http.rest.Page;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//li/a[text() = '%s']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//a[contains(@class, 'signup-icon')]")
    private ExtendedWebElement signUpButton;

    @FindBy(id = "login-active")
    private ExtendedWebElement loginButton;

    @FindBy(id = "login-popup2")
    private LoginMenu loginMenu;

    @FindBy(xpath = "//*[@id='social-connect']/a[@class = \"%s\"]")
    private ExtendedWebElement headerIcon;

    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(), '%s')]")
    private ExtendedWebElement menuHumburgerButton;
    public  HeaderMenu(WebDriver driver, SearchContext searchContext) {super(driver,searchContext);}

    public void clickHeaderMenuButton(HeaderButton headerButton) {
        headerMenuButton.format(headerButton.getValue()).click();
    }

    public boolean isHeaderMenuButtonPresent(HeaderButton headerButton) {
        return headerMenuButton.format(headerButton.getValue()).isElementPresent();
    }
    public boolean openPage(HeaderButton headerButton) {
        menuHumburgerButton.format(headerButton.getValue()).click();
        return true;
    }
    public SignUpPage openSignUpPage() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public LoginMenu openLoginMenu() {
        loginButton.click();
        return loginMenu;
    }
}