package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    static Duration TIMEOUT = Duration.ofMillis(5000);
    private static SelenideElement usernameField = $(By.name("username")),
            passwordField = $(By.name("password")),
            loginButton = $(By.xpath("//input[@value='Log In']")),
            registerButton = $(By.xpath("//a[text()='Register']")),
            logoutButton = $(By.xpath("//a[text()='Log Out']")),
            accountsOverviewButton = $(By.xpath("//a[text()='Accounts Overview']"));


    public static void inputUserName(String userName) {
        usernameField.shouldBe(Condition.visible, TIMEOUT).sendKeys(userName);
    }

    public static void inputPassword(String password) {
        passwordField.shouldBe(Condition.visible, TIMEOUT).sendKeys(password);
    }

    public static void clickLoginButton() {
        loginButton.shouldBe(Condition.visible, TIMEOUT).click();
    }

    public static void goToaccountsOverview() {
        accountsOverviewButton.shouldBe(Condition.visible, TIMEOUT).click();
    }

    public static void clickRegisterNewCustomerButton() {
        registerButton.shouldBe(Condition.visible, TIMEOUT).click();
    }

    public static void validateSuccessfulLogin() {
        logoutButton.shouldBe(Condition.visible, TIMEOUT);
    }

    /**
     * This method is for logging in with given username and password
     * @param userName
     * @param password
     */
    public static void login(String userName, String password) {
        MainPage.inputUserName(userName);
        MainPage.inputPassword(password);
        MainPage.clickLoginButton();
        MainPage.validateSuccessfulLogin();
        System.out.println("User " + userName + " is logged in");
    }


}
