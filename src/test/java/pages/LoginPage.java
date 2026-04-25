package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.cssSelector("#user-name");
    private final By PASSWORD_FIELD = By.cssSelector("#password");
    private final By LOGIN_BUTTON = By.cssSelector("#login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String pass) {
        driver.findElement(USERNAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMsg() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
