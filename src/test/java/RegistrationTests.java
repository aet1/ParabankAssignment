import Pages.MainPage;
import Pages.RegistrationPage;
import Util.WebDriverFactory;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import static Util.HelperFunctions.generateRandomNumber;
import static Util.HelperFunctions.generateRandomString;
import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {
        private static WebDriver driver;
        private static final String url = "https://parabank.parasoft.com/parabank/index.htm";

        String firstName = generateRandomString(4);
        String lastName = generateRandomString(7);
        String address = generateRandomString(7);
        String city = generateRandomString(4);
        String state = generateRandomString(5);
        String zipCode = generateRandomNumber(5);
        String SSN = generateRandomNumber(13);
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
        @Order(1)
        @Description("Negative test case - Registration when mandatory fields are left blank should not succeed")
        public void registrationWithIncompleteDataTest() {
            MainPage.clickRegisterNewCustomerButton();
            RegistrationPage.inputFirstName(firstName);
            RegistrationPage.inputLastName(lastName);
            RegistrationPage.inputaddress(address);
            RegistrationPage.inputCity(city);
            RegistrationPage.inputState(state);
            RegistrationPage.inputSSN(SSN);
            RegistrationPage.clickSubmitRegistrationButton();
            RegistrationPage.validateErrorMessages();
        }
        @Test
        @Order(2)
        @Description("Validates that when registration form is filled in, customer registration is successful")
        public void successfulRegistrationTest() {
            RegistrationPage.registerNewCustomer(firstName,lastName,address,city,state,zipCode,SSN);
        }
    }


