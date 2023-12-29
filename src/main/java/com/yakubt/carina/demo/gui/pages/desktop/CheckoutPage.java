package com.yakubt.carina.demo.gui.pages.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.yakubt.carina.demo.db.models.User;

public class CheckoutPage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "postal-code")
    private ExtendedWebElement zipField;

    @FindBy(id = "continue")
    private ExtendedWebElement continueBtn;

    @FindBy(id = "finish")
    private ExtendedWebElement finishBtn;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private ExtendedWebElement successfulOrderLabel;

    @FindBy(xpath = "//div[contains(@class,'summary_subtotal_label')]")
    private ExtendedWebElement totalSumLabel;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void makeOrder(User user) {
        firstNameField.type(user.getFirstName());
        lastNameField.type(user.getLastName());
        zipField.type(user.getZip());
        continueBtn.click();
        finishBtn.click();
    }

    public void makeOrderWithoutFinishing(User user) {
        firstNameField.type(user.getFirstName());
        lastNameField.type(user.getLastName());
        zipField.type(user.getZip());
        continueBtn.click();
    }

    public boolean isOrderSuccessful() {
        return successfulOrderLabel.isVisible();
    }

    public double getTotalSum() {
        String text = totalSumLabel.getText();
        int dolPos = text.indexOf('$');
        return Double.parseDouble(text.substring(dolPos+1));
    }
}
