package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By TITLE = By.cssSelector("[data-test=title]");
    private final String ENDPOINT = "/cart.html";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(By.xpath("*//div[@class='cart_item']"));
    }

    public int getCartSize() {
        return driver.findElements(By.xpath("*//div[@class='cart_item']")).size();
    }

    @Override
    public void open() {
        driver.get(BASEURL + ENDPOINT);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void removeItem(String itemName) {
        String id = "remove-" + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(id)).click();
    }

    public boolean isItemInCart(String itemName) {
        String id = "remove-" + itemName.toLowerCase().replace(" ", "-");
        return !driver.findElements(By.id(id)).isEmpty();
    }


}
