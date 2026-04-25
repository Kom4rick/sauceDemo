package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final String ENDPOINT = "/inventory.html";
    private final By ADD_TO_CART_BUTTON = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private final By REMOVE_BUTTON = By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(BASEURL + ENDPOINT);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public List<WebElement> getItems() {
        return driver.findElements(By.xpath("*//div[@class='inventory_item']"));
    }

    public void addToCartAllItems() {
        List<WebElement> addToCart = driver.findElements(ADD_TO_CART_BUTTON);
        for (WebElement element : addToCart) {
            element.click();
        }
    }

    public boolean allItemsAdded() {
        List<WebElement> addToCart = driver.findElements(ADD_TO_CART_BUTTON);
        return addToCart.isEmpty();
    }

    public boolean isItemAdded(String itemName) {
        String id = "remove-" + itemName.toLowerCase().replace(" ", "-");
        return !driver.findElements(By.id(id)).isEmpty();
    }

    public void removeItem(String itemName) {
        String id = "remove-" + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(id)).click();
    }

    public boolean isItemNotAdded(String itemName) {
        String id = "add-to-cart-" + itemName.toLowerCase().replace(" ", "-");
        return !driver.findElements(By.id(id)).isEmpty();
    }

    public void addItem(String itemName) {
        String id = "add-to-cart-" + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(id)).click();
    }
}
