package com.solvd.carina.demo.gui;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.gui.components.HeaderButton;
import com.solvd.carina.demo.gui.components.HeaderMenu;
import com.solvd.carina.demo.gui.pages.*;
import org.testng.asserts.SoftAssert;

public class PageFactory implements IAbstractTest {
    HomePage homePage = new HomePage(getDriver());
    SoftAssert softAssert = new SoftAssert();
    HeaderMenu headerMenu = homePage.getHeaderMenu();
    public void createPage(HeaderButton headerButton){
        switch (headerButton) {
            case HOME:
                homePage.open();
                softAssert.assertTrue(homePage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case NEWS:
                NewsPage newsPage = headerMenu.openNewsPage();
                softAssert.assertTrue(newsPage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case REVIEWS:
                ReviewsPage reviewsPage = headerMenu.openReviewsPage();
                softAssert.assertTrue(reviewsPage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case VIDEOS:
                VideosPage videosPage = headerMenu.openVideosPage();
                softAssert.assertTrue(videosPage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case FEATURED:
                FeaturedPage featuredPage = headerMenu.openFeaturedPage();
                softAssert.assertTrue(featuredPage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case PHONE_FINDER:
                PhoneFinderPage phoneFinderPage = headerMenu.openPhoneFinderPage();
                softAssert.assertTrue(phoneFinderPage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case DEALS:
                DealsPage dealsPage = headerMenu.openDealsPage();
                softAssert.assertTrue(dealsPage.isPageOpened(), headerButton.getValue()+" is not opened");
                break;
            case MERCH:
                MerchPage merchNewPage = headerMenu.openMerchPage();
                softAssert.assertTrue(true, headerButton.getValue()+" is not opened");
                break;
            case COVERAGE:
                CoveragePage coveragePage = headerMenu.openCoveragePage();
                softAssert.assertTrue(coveragePage.isPageOpened(), "Coverage is not opened");
                break;
            case CONTACT:
                ContactPage contactPage = headerMenu.openContactPage();
                softAssert.assertTrue(contactPage.isPageOpened(), "Contact page is not opened");
                break;
            default:
                break;
        }
    }
}
