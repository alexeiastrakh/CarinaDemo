package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.FooterMenu;
import com.solvd.carina.demo.gui.components.HeaderButton;
import com.solvd.carina.demo.gui.pages.CompareModelsPage;
import com.solvd.carina.demo.gui.pages.CoveragePage;
import com.solvd.carina.demo.gui.pages.HomePage;
import com.solvd.carina.demo.gui.pages.ReviewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.solvd.carina.demo.gui.pages.*;



public class TestFooterMenu implements IAbstractTest {
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.scrollToFooterMenu();
        FooterMenu footerMenu = homePage.getFooterMenu();
        SoftAssert softAssert = new SoftAssert();

        NewsPage newsPage = footerMenu.openNewsPage();
        softAssert.assertTrue(newsPage.isPageOpened(), "News page is not opened");
        homePage.scrollToFooterMenu();
        ReviewsPage reviewsPage = footerMenu.openReviewsPage();
        softAssert.assertTrue(reviewsPage.isPageOpened(), "Reviews page is not opened");
        homePage.scrollToFooterMenu();
        CoveragePage coveragePage = footerMenu.openCoveragePage();
        softAssert.assertTrue(coveragePage.isPageOpened(), "Coverage is not opened");
        homePage.scrollToFooterMenu();
        GlossaryPage glossaryPage = footerMenu.openGlossaryPage();
        softAssert.assertTrue(glossaryPage.isPageOpened(), "Glossary is not opened");
        homePage.scrollToFooterMenu();
        FAQPage faqPage = footerMenu.openFAQPage();
        softAssert.assertTrue(faqPage.isPageOpened(), "FAQ is not opened");
        softAssert.assertAll();

    }
}
