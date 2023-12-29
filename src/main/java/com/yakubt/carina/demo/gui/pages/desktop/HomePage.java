package com.yakubt.carina.demo.gui.pages.desktop;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.yakubt.carina.demo.db.models.User;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class HomePage extends AbstractPage {

    @FindBy(id = "user-name")
    private ExtendedWebElement userField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login(User user) {
        userField.type(user.getUserName());
        passwordField.type(user.getPassword());
        loginBtn.check();
    }
}
