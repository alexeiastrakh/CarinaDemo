package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//h3[text() = 'Login successful.']")
    private ExtendedWebElement LoginSuccessfulTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isLoggedIn(){
        return  LoginSuccessfulTitle.isElementPresent();
    }
}