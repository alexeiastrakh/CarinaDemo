package com.solvd.carina.demo.gui.components;

import com.azure.core.http.rest.Page;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.carina.demo.gui.pages.*;
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
    public HomePage openHomePage() {
        headerMenuButton.format(HeaderButton.HOME.getValue()).click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        headerMenuButton.format(HeaderButton.NEWS.getValue()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        headerMenuButton.format(HeaderButton.REVIEWS.getValue()).click();
        return new ReviewsPage(driver);
    }

    public VideosPage openVideosPage() {
        headerMenuButton.format(HeaderButton.VIDEOS.getValue()).click();
        return new VideosPage(driver);
    }

    public FeaturedPage openFeaturedPage() {
        headerMenuButton.format(HeaderButton.FEATURED.getValue()).click();
        return new FeaturedPage(driver);
    }

    public PhoneFinderPage openPhoneFinderPage() {
        headerMenuButton.format(HeaderButton.PHONE_FINDER.getValue()).click();
        return new PhoneFinderPage(driver);
    }

    public DealsPage openDealsPage() {
        headerMenuButton.format(HeaderButton.DEALS.getValue()).click();
        return new DealsPage(driver);
    }

    public MerchPage openMerchPage() {
        headerMenuButton.format(HeaderButton.MERCH.getValue()).click();
        return new MerchPage(driver);
    }

    public CoveragePage openCoveragePage() {
        headerMenuButton.format(HeaderButton.COVERAGE.getValue()).click();
        return new CoveragePage(driver);
    }

    public ContactPage openContactPage() {
        headerMenuButton.format(HeaderButton.CONTACT.getValue()).click();
        return new ContactPage(driver);
    }
    public LoginMenu openLoginMenu() {
        loginButton.click();
        return loginMenu;
    }
}