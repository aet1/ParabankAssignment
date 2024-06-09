import Pages.MainPage;
import Util.WebDriverFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    private static WebDriver driver;
    private static final String url = "https://parabank.parasoft.com/parabank/index.htm";
    String username = "fJsyF1";
    String password = "lPYLpabskwYw";

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
    @Description("Login with valid credentials")
    public void successfulLoginTest() {
        MainPage.inputUserName(username);
        MainPage.inputPassword(password);
        MainPage.clickLoginButton();
        MainPage.validateSuccessfulLogin();

    }
}
