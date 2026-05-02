package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LocatorTest {
    @Test
    public void checkLocator() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        By id = By.id("login_button_container");
        //Assert.assertEquals(id, "login_button_container");
        By name = By.name("user-name");
        By className = By.className("login_wrapper-inner");
        By tagName = By.tagName("body");

        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        By linkText = By.linkText("Sauce Labs Backpack");
        By partialLinkText = By.partialLinkText("Bike");

        By byAttributeXpath = By.xpath("//div[@id='root']");
        By byTextXpath = By.xpath("//button[text()='Add to cart']");
        By byPartAttrXpath = By.xpath("//div[contains(@data-test,'inventory-ite')]");
        By byPartTextXpath = By.xpath("//div[contains(text(),'Bolt T-Shirt')]");
        By byAnc = By.xpath("//div[@class='inventory_item_img']/a/ancestor::div[@class='inventory_item']");
        By byDesc = By.xpath("//div[@class='inventory_item_description']/descendant::div[@class='inventory_item_desc']");
        By byFollow = By.xpath("//div[@class='primary_header']/following::div[@class='header_secondary_container']");
        By byParent = By.xpath("//div[@class='primary_header']/parent::div");
        By byPreceding = By.xpath("//div[@class='bm-menu']/preceding::div[@class='bm-burger-button']");

        By byClassCss = By.cssSelector(".page_wrapper");
        By twoClassesCss = By.cssSelector(".bm-item.menu-item");
        By twoClassesParentCss = By.cssSelector(".bm-cross-button .bm-cross");
        By idCss = By.cssSelector("#login_button_container");
        By tagNameCss = By.cssSelector("html");
        By tagNameClassCss = By.cssSelector("div.page_wrapper");
        By equalsCss = By.cssSelector("[rel=\"apple-touch-icon\"]");
        By containsCss = By.cssSelector("[alt~=\"Labs\"]");
        By equalOrStartCss = By.cssSelector("[data-test|=\"item-4-img\"]");
        By startsWithCss = By.cssSelector("[class^=\"header\"]");
        By endsWithCss = By.cssSelector("[src$=\"jpg\"]");
        By subStrCss = By.cssSelector("[class*=\"container\"]");

        driver.quit();
    }
}