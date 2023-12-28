package com.yakubt.carina.demo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class ProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//button[text()='Add to cart']")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private ExtendedWebElement price;

    public ProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void addToCart() {
        addToCartBtn.click();
    }

    public double getPrice() {
       return Double.parseDouble(price.getText().substring(1));
    }
}
