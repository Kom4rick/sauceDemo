package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка позитивного логина",
            testName = "Позитивный логин",
            groups = {"login"})
    public void checkLoginWithPositiveCred() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @DataProvider(name = "Тестовые данные для негативного логина")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Тестовые данные для негативного логина",
            description = "Проверка негативного логина",
            testName = "Негативный логин")
    public void checkLoginWithNegativeCred(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
