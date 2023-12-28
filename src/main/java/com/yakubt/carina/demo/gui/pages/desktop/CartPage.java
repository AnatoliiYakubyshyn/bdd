package com.yakubt.carina.demo.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class CartPage extends AbstractPage {

    @FindBy(id = "checkout")
    private ExtendedWebElement checkout;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage proceedToCheckout() {
        checkout.click();
        return new CheckoutPage(getDriver());
    }
}
