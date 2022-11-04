package com.solvd.carina.demo.MyWebSampleTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.carina.demo.gui.PageFactory;
import com.solvd.carina.demo.gui.components.HeaderButton;
import com.solvd.carina.demo.gui.components.HeaderMenu;
import com.solvd.carina.demo.gui.pages.*;
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
        PageFactory pageFactory = new PageFactory();
        for (HeaderButton headerButton: HeaderButton.values()) {
          pageFactory.createPage(headerButton);
        }
        softAssert.assertAll();
    }
}
