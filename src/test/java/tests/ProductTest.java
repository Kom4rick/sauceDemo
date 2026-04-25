package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductTest extends BaseTest {

    @Test
    public void addToCartAllItems() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addToCartAllItems();
        Assert.assertTrue(productsPage.allItemsAdded());
    }

    @Test
    public void addItem() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addItem("Sauce Labs Backpack");
        assertFalse(productsPage.isItemNotAdded("Sauce Labs Backpack"));
    }

    @Test
    public void removeItem() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        productsPage.addToCartAllItems();
        assertTrue(productsPage.allItemsAdded());
        productsPage.removeItem("Sauce Labs Backpack");
        assertFalse(productsPage.isItemAdded("Sauce Labs Backpack"));
    }
}
