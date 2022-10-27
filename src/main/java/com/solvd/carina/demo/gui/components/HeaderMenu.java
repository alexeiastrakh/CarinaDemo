package com.solvd.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.components.HeaderButtonLink;
import com.solvd.carina.demo.gui.components.HeaderIconLink;
import com.solvd.carina.demo.gui.pages.SignUpPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//li/a[text() = '%s']")
    private ExtendedWebElement headerMenuButton;

    @FindBy(xpath = "//*[@id='social-connect']/a[@class = \"%s\"]")
    private ExtendedWebElement headerIcon;
    public  HeaderMenu(WebDriver driver, SearchContext searchContext) {super(driver,searchContext);}

    public void clickHeaderMenuButton(HeaderButtonLink headerButtonLink) {
        headerMenuButton.format(headerButtonLink.getValue()).click();
    }

    public boolean isHeaderMenuButtonPresent(HeaderButtonLink headerButtonLink) {
        return headerMenuButton.format(headerButtonLink.getValue()).isElementPresent();
    }

    public void clickHeaderMenuIcon(HeaderIconLink headerIconLink) {
        headerIcon.format(headerIconLink.getValue()).click();
    }

    public SignUpPage goToSignUpPage() {
        clickHeaderMenuIcon(HeaderIconLink.SIGN_UP);
        return new SignUpPage(getDriver());
    }
}