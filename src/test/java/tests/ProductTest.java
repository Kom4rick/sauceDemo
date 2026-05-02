package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class ProductTest extends BaseTest {

    @Test(description = "Добавление всех товаров в корзину",
            testName = "Добвление всех товаров")
    public void addToCartAllItems() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addToCartAllItems();
        Assert.assertTrue(productsPage.allItemsAdded());
    }

    @Test(dataProvider = "Тестовые данные для добавления и удаления товаров корзины",
            description = "Добавление товара в корзину",
            testName = "Добвление одного товара")
    public void addItem(String itemName) throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addItem(itemName);
        assertFalse(productsPage.isItemNotAdded(itemName));
    }

    @Test(dataProvider = "Тестовые данные для добавления и удаления товаров корзины",
            description = "Удаление одного товара из корзины",
            testName = "Удаление товара из корзины")
    public void removeItem(String itemName) throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addItem(itemName);
        assertFalse(productsPage.isItemNotAdded(itemName));
        productsPage.removeItem(itemName);
        assertFalse(productsPage.isItemAdded(itemName));
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
