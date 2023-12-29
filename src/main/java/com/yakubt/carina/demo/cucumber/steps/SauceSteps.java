package com.yakubt.carina.demo.cucumber.steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;

import com.yakubt.carina.demo.gui.components.ProductItem;
import com.yakubt.carina.demo.gui.pages.desktop.CartPage;
import com.yakubt.carina.demo.gui.pages.desktop.CheckoutPage;
import com.yakubt.carina.demo.gui.pages.desktop.HomePage;
import com.yakubt.carina.demo.gui.pages.desktop.ProductsPage;
import com.yakubt.carina.demo.db.mappers.UserMapper;
import com.yakubt.carina.demo.db.mappers.OrderMapper;
import com.yakubt.carina.demo.db.models.User;
import com.yakubt.carina.demo.db.models.Order;
import com.yakubt.carina.demo.utils.ConnectionFactory;
import com.zebrunner.carina.webdriver.IDriverPool;

public class SauceSteps implements IDriverPool {

    private User currentUser;

    private double sum;

    @Given("I am on main page")
    public void iAmOnMainPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
    }

    @When("I login as normal user")
    public void loginAsNormalUser() {
        try (SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().
                openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            currentUser = userMapper.findById(1);
        }
        HomePage homePage = new HomePage(getDriver());
        homePage.login(currentUser);
    }

    @When("I login as {string} user")
    public void loginAsNumberUser(String id) {
        try (SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().
                openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            currentUser = userMapper.findById(Integer.parseInt(id));
        }
        HomePage homePage = new HomePage(getDriver());
        homePage.login(currentUser);
    }

    @Then("Product page is opened")
    public void productPageOpenedCheck() {
        ProductsPage productsPage = new ProductsPage(getDriver());
        Assert.assertTrue(productsPage.isPageOpened());
    }

    @When("I make order")
    public void makeOrder() {
        ProductsPage productsPage = new ProductsPage(getDriver());
        List<Integer> orderItemsIds = currentUser.getOrders();
        try (SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

            for (int orderId : orderItemsIds) {
                Order order = orderMapper.findById(orderId);
                ProductItem productItem = productsPage.getItemByName(order.getName());
                productItem.addToCart();
            }
            CartPage cartPage = productsPage.proceedToCart();
            CheckoutPage checkoutPage = cartPage.proceedToCheckout();
            checkoutPage.makeOrder(currentUser);
        }
    }

    @When("I proceed to checkout overview")
    public void proceedToCheckout() {
        ProductsPage productsPage = new ProductsPage(getDriver());
        List<Integer> orderItemsIds = currentUser.getOrders();
        try (SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

            for (int orderId : orderItemsIds) {
                Order order = orderMapper.findById(orderId);
                ProductItem productItem = productsPage.getItemByName(order.getName());
                productItem.addToCart();
                sum += productItem.getPrice();
            }
            CartPage cartPage = productsPage.proceedToCart();
            CheckoutPage checkoutPage = cartPage.proceedToCheckout();
            checkoutPage.makeOrderWithoutFinishing(currentUser);
        }
    }


    @Then("I have successful order message")
    public void checkSuccessOrder() {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        Assert.assertTrue(checkoutPage.isOrderSuccessful());
    }

    @Then("I have correct total sum")
    public void checkCorrectTotalSum() {
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        Assert.assertEquals(checkoutPage.getTotalSum(), sum);
    }
}
