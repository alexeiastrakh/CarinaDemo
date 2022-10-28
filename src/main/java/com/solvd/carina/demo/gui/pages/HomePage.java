package com.solvd.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.solvd.carina.demo.gui.components.HeaderMenu;

import com.solvd.carina.demo.gui.components.FooterMenu;
import com.solvd.carina.demo.gui.components.LoginMenu;
import com.solvd.carina.demo.gui.components.WeValuePrivacyAd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;


public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id ="header")
    private HeaderMenu headerMenu;
    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[contains(@class, 'brandmenu-v2')]//a")
    private List<ExtendedWebElement> brandLinks;

    @FindBy(className = "news-column-index")
    private ExtendedWebElement newsColumn;

    @FindBy(id = "login-popup2")
    private LoginMenu loginMenu;

    @FindBy(xpath = "//button[contains(@class, 'lines-button minus')]")
    private ExtendedWebElement menuHumburgerButton;

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(), '%s')]")
    private ExtendedWebElement footerMenuButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(newsColumn);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LoginMenu getLoginForm() {
        return loginMenu;
    }

    public void clickMenuHumburgerButton() {
        menuHumburgerButton.click();
    }
    public void clickFooterMenuButton() {
        footerMenuButton.click();
    }
    public BrandModelsPage selectBrand(String brand) {
        LOGGER.info("selecting '" + brand + "' brand...");
        for (ExtendedWebElement brandLink : brandLinks) {
            String currentBrand = brandLink.getText();
            LOGGER.info("currentBrand: " + currentBrand);
            if (brand.equalsIgnoreCase(currentBrand)) {
                brandLink.click();
                return new BrandModelsPage(driver);
            }
        }
        throw new RuntimeException("Unable to open brand: " + brand);
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
        return new WeValuePrivacyAd(driver);
    }

}