package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    public final String BASEURL = "https://www.saucedemo.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BASEURL);
    }
}
