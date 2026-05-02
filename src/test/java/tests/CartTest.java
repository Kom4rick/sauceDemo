package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test(description = "Проверка отсутствия товаров в корзине",
            testName = "Проверка корзины")
    public void checkCartSizeWithEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        assertEquals(cartPage.getTitle(), "Your Cart");
        int cartSize = cartPage.getCartSize();
        assertEquals(cartSize, 0);
    }

    @Test(dataProvider = "Тестовые данные для добавления и удаления товаров корзины",
            description = "Проверка удаления товаров в корзине",
            testName = "Удаление товара по имени")
    public void removeItemFromCart(String itemName) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.open();
        productsPage.addItem(itemName);
        assertFalse(productsPage.isItemNotAdded(itemName));
        cartPage.open();
        assertEquals(cartPage.getTitle(), "Your Cart");
        cartPage.removeItem(itemName);
        assertFalse(cartPage.isItemInCart(itemName));
    }

    @DataProvider(name = "Тестовые данные для добавления и удаления товаров корзины")
    public Object[] itemData() {
        return new Object[][] {
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }
}
