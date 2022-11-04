package com.solvd.carina.demo.gui.components;


import com.solvd.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;


public class FooterMenu extends AbstractUIObject {
    @FindBy(linkText = "Home")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = "//div[@id='footer']//a[contains(text(), '%s')]")
    private ExtendedWebElement footerMenuButton;
    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
    private ExtendedWebElement compareLink;
    
    @FindBy(linkText = "News")
    private ExtendedWebElement newsLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HomePage openHomePages() {
        homeLink.click();
        return new HomePage(driver);
    }

    public CompareModelsPage openComparePage() {
        compareLink.click();
        return new CompareModelsPage(driver);
    }
    public ExtendedWebElement getFooterMenuButton(){
        return footerMenuButton;
    }

    public boolean openPage(FooterButton footerButton) {
        footerMenuButton.format(footerButton.getValue()).click();
        return true;
    }
    public void clickFooterMenuButton(FooterButton footerButton) {
        footerMenuButton.format(footerButton.getValue()).click();
    }
    public HomePage openHomePage() {
        footerMenuButton.format(FooterButton.HOME.getValue()).click();
        return new HomePage(driver);
    }

    public NewsPage openNewsPage() {
        footerMenuButton.format(FooterButton.NEWS.getValue()).click();
        return new NewsPage(driver);
    }

    public ReviewsPage openReviewsPage() {
        footerMenuButton.format(FooterButton.REVIEWS.getValue()).click();
        return new ReviewsPage(driver);
    }
    public CoveragePage openCoveragePage() {
        footerMenuButton.format(FooterButton.Coverage.getValue()).click();
        return new CoveragePage(driver);
    }

    public GlossaryPage openGlossaryPage() {
        footerMenuButton.format(FooterButton.Glossary.getValue()).click();
        return new GlossaryPage(driver);
    }

    public FAQPage openFAQPage() {
        footerMenuButton.format(FooterButton.FAQ.getValue()).click();
        return new FAQPage(driver);
    }
}
