import Pages.AccountsPage;
import Pages.MainPage;
import Util.WebDriverFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static Pages.AccountsPage.getAccountNumber;
import static com.codeborne.selenide.Selenide.open;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountsTests {
    private static WebDriver driver;
    private static final String url = "https://parabank.parasoft.com/parabank/index.htm";
    private static final String accountType = "CHECKING";
    @BeforeAll
    public static void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        open(url);
        MainPage.login("fJsyF1", "lPYLpabskwYw");
    }

    @AfterAll
    public static void tearDown() {
        WebDriverFactory.quitChromeDriver(driver);
    }

    @Test
    @Order(1)
    @Description("Open accounts overview page and validate Accounts overview table")
    public void accountsOverviewPageTest() {
        MainPage.goToaccountsOverview();
        AccountsPage.validatePageTitle();
        AccountsPage.validateAccountsOverviewTable();
    }

    @Test
    @Order(2)
    @Description("Open accounts details page and validate Accounts details table")
    public void accountsDetailsTest() {
        String accountNumber = getAccountNumber();
        AccountsPage.openAccountDetailsPage();
        AccountsPage.validateAccountDetails(accountNumber,accountType);
    }


}