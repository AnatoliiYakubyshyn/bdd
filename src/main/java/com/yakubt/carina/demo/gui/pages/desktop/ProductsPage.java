package com.yakubt.carina.demo.gui.pages.desktop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.yakubt.carina.demo.gui.components.ProductItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class ProductsPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(ProductsPage.class);

    @FindBy(xpath = "//span[text()='Products']")
    private ExtendedWebElement marker;

    private final String productItemLocator = "//div[text()='%s']/../../../..";

    private ProductItem productItem;

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement productCart;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(marker);
    }

    public ProductItem getItemByName(String name) {
        return new ProductItem(getDriver(), getDriver().
                findElement(By.xpath(String.format(productItemLocator, name))));
    }

    public CartPage proceedToCart() {
        productCart.click();
        return new CartPage(getDriver());
    }

}
