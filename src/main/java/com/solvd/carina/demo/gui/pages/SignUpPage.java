package com.solvd.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {



    @FindBy(xpath = "//input[@id='uname']")
    private ExtendedWebElement nicknameTextBox;

    @FindBy(xpath = "//*[@id = 'frmOpin']/fieldset/input[@id = \"email\"]")
    private ExtendedWebElement emailTextBox;

    @FindBy(xpath = "//*[@id = 'frmOpin']/input[@id = \"upass\"]")
    private ExtendedWebElement passwordTextBox;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement agreeTerms;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement confirmTerms;

    @FindBy(xpath = "//div[@id= \"ucsubmit-f\"]/input[@id= \"nick-submit\"]")
    private ExtendedWebElement submitButton;

    @FindBy( xpath = "//h3[text() = 'Your account was created. ']")
    ExtendedWebElement accountWasCreatedTitle;
    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public void fillToNicknameTextBox(String text) {
        nicknameTextBox.type(text);
    }

    public void fillToEmailTextBox(String text) {
        emailTextBox.type(text);
    }

    public void fillToPasswordTextBox(String text) {
        passwordTextBox.type(text);
    }

    public void confirmTerms() {
        agreeTerms.click();
        confirmTerms.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


    public String getResult(){
        return accountWasCreatedTitle.getText();
    }

}