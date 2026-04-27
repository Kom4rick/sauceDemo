package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void checkCartSizeWithEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        assertEquals(cartPage.getTitle(), "Your Cart");
        int cartSize = cartPage.getCartSize();
        assertEquals(cartSize, 0);
    }

    @Test
    public void removeItemFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.open();
        productsPage.addItem("Sauce Labs Backpack");
        assertFalse(productsPage.isItemNotAdded("Sauce Labs Backpack"));
        cartPage.open();
        assertEquals(cartPage.getTitle(), "Your Cart");
        //productsPage.AddItem("Sauce Labs Backpack");
        cartPage.removeItem("Sauce Labs Backpack");
        assertFalse(cartPage.isItemInCart("Sauce Labs Backpack"));
    }
}
