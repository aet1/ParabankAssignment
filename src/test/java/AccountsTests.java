import Pages.AccountsPage;
import Pages.MainPage;
import Util.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static Pages.RegistrationPage.password;
import static Pages.RegistrationPage.username;
import static com.codeborne.selenide.Selenide.open;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountsTests {
    private static WebDriver driver;
    private static final String url = "https://parabank.parasoft.com/parabank/index.htm";
    private static final String accountNumber = "17895";
    private static final String accountType = "CHECKING";
    @BeforeAll
    public static void setUp() {
        driver = WebDriverFactory.createChromeDriver();
        open(url);
        MainPage.login(username, password);
    }

    /*@AfterAll
    public static void tearDown() {
        WebDriverFactory.quitChromeDriver(driver);
    }*/

    @Test
    @Order(1)
    public void accountsOverviewPageTest() {
        MainPage.goToaccountsOverview();
        AccountsPage.validatePageTitle();
        AccountsPage.validateAccountsOverviewTable();
        System.out.println("Accounts overview page checked");

    }

    @Test
    @Order(2)
    public void accountsDetailsTest() {
        AccountsPage.openAccountDetailsPage(accountNumber);
        AccountsPage.validateAccountDetails(accountNumber,accountType);
        System.out.println("Accounts details page checked");
    }


}