import Pages.MainPage;
import Pages.RegistrationPage;
import Util.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.using;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegistrationTests {
        private static WebDriver driver;
        private static final String url = "https://parabank.parasoft.com/parabank/index.htm";

        String firstName = RegistrationPage.generateRandomString(4);
        String lastName = RegistrationPage.generateRandomString(7);
        String address = RegistrationPage.generateRandomString(7);
        String city = RegistrationPage.generateRandomString(4);
        String state = RegistrationPage.generateRandomString(5);
        String zipCode = RegistrationPage.generateRandomNumber(5);
        String SSN = RegistrationPage.generateRandomNumber(13);


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
            System.out.println("Error messages validated");


        }
        @Test
        @Order(2)
        public void successfulRegistrationTest() {
            RegistrationPage.registerNewCustomer(firstName,lastName,address,city,state,zipCode,SSN);
            System.out.println("New customer registered");
            System.out.println(RegistrationPage.username);
            System.out.println(RegistrationPage.password);
        }
    }


