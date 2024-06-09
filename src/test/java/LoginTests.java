import Pages.MainPage;
import Pages.RegistrationPage;
import Util.WebDriverFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    private static WebDriver driver;
    private static final String url = "https://parabank.parasoft.com/parabank/index.htm";
    String username = RegistrationPage.username;
    String password = RegistrationPage.password;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        open(url);
    }

    @AfterAll
    public static void tearDown() {
        WebDriverFactory.quitChromeDriver(driver);
    }

    @Test
    public void successfulLoginTest() {
        System.out.println("Start login");
        System.out.println(username);
        System.out.println(password);
        MainPage.inputUserName(username);
        MainPage.inputPassword(password);
        MainPage.clickLoginButton();
        MainPage.validateSuccessfulLogin();
        System.out.println("Login succeeded");

    }
}
