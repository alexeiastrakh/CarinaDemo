package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.components.HeaderButton;
import com.solvd.carina.demo.gui.components.HeaderMenu;
import com.solvd.carina.demo.gui.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestHeaderMenu implements IAbstractTest {
    @Test
    @MethodOwner(owner = "OleksiiA")
    public void testHeaderMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickMenuHumburgerButton();
        HeaderMenu headerMenu = homePage.getHeaderMenu();
        SoftAssert softAssert = new SoftAssert();
        for (HeaderButton headerButton:HeaderButton.values()) {
            softAssert.assertTrue(headerMenu.openPage(headerButton),headerButton.getValue()+
                    " page did not open");
        }
        softAssert.assertAll();
    }
}
