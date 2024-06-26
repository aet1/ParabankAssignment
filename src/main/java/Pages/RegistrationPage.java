package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.Duration;
import static Util.HelperFunctions.generateRandomString;
import static Util.HelperFunctions.validateElementVisible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private static Duration TIMEOUT = Duration.ofMillis(5000);
    public static String username = generateRandomString(6);
    public static String password = generateRandomString(12);
    private static SelenideElement firstNameField = $(By.id("customer.firstName")),
            lastNameField = $(By.id("customer.lastName")),
            addressField = $(By.id("customer.address.street")),
            cityField = $(By.id("customer.address.city")),
            stateField = $(By.id("customer.address.state")),
            SSNField = $(By.id("customer.ssn")),
            zipCodeField = $(By.id("customer.address.zipCode")),
            setUserNameField = $(By.id("customer.username")),
            setPasswordField = $(By.id("customer.password")),
            repeatPasswordField = $(By.id("repeatedPassword")),
            submitRegistrationButton = $(By.xpath("//input[@value='Register']")),
            welcomePageTitle = $(By.xpath("//h1[@class='title']")),
            zipCodeRequiredError = $(By.id("customer.address.zipCode.errors")),
            userNameRequiredError = $(By.id("customer.username.errors")),
            passwordRequiredError = $(By.id("customer.password.errors")),
            passwordConfirmationRequiredError = $(By.id("repeatedPassword.errors"));

    public static void inputFirstName(String firstName){
        firstNameField.shouldBe(Condition.visible, TIMEOUT).sendKeys(firstName);
    }
    public static void inputLastName(String lastName){
        lastNameField.shouldBe(Condition.visible, TIMEOUT).sendKeys(lastName);
    }
    public static void inputaddress(String address){
        addressField.shouldBe(Condition.visible, TIMEOUT).sendKeys(address);
    }
    public static void inputCity(String city){
        cityField.shouldBe(Condition.visible, TIMEOUT).sendKeys(city);
    }
    public static void inputState(String state){
        stateField.shouldBe(Condition.visible, TIMEOUT).sendKeys(state);
    }
    public static void inputZipCode(String zipCode){
        zipCodeField.shouldBe(Condition.visible, TIMEOUT).sendKeys(zipCode);
    }

    public static void inputSSN(String SSN){
        SSNField.shouldBe(Condition.visible, TIMEOUT).sendKeys(SSN);
    }
    public static void inputSelectedUserName(String userName){
        setUserNameField.shouldBe(Condition.visible, TIMEOUT).sendKeys(userName);
    }
    public static void inputSelectedPassword(String password){
        setPasswordField.shouldBe(Condition.visible, TIMEOUT).sendKeys(password);
    }
    public static void repeatPassword(String password){
        repeatPasswordField.shouldBe(Condition.visible, TIMEOUT).sendKeys(password);
    }

    public static void clickSubmitRegistrationButton(){
        submitRegistrationButton.shouldBe(Condition.visible, TIMEOUT).click();
    }

    /**
     * Method to validate error messages
     */
    public static void validateErrorMessages() {
        System.out.println("Checking that error messages are displayed");
        validateElementVisible(zipCodeRequiredError);
        validateElementVisible(userNameRequiredError);
        validateElementVisible(passwordRequiredError);
        validateElementVisible(passwordConfirmationRequiredError);
    }

    /**
     * This method is to fill in new customer registration form and submit it
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param zipCode
     * @param SSN
     */
    public static void registerNewCustomer(String firstName, String lastName, String address,
                                                String city, String state, String zipCode, String SSN){

        MainPage.clickRegisterNewCustomerButton();
        System.out.println("Filling in user details on registration form");
        inputFirstName(firstName);
        inputLastName(lastName);
        inputaddress(address);
        inputCity(city);
        inputState(state);
        inputZipCode(zipCode);
        inputSSN(SSN);
        inputSelectedUserName(username);
        inputSelectedPassword(password);
        repeatPassword(password);
        clickSubmitRegistrationButton();
        welcomePageTitle.shouldBe(Condition.visible,TIMEOUT).shouldHave(Condition.text("Welcome " +username));
        System.out.println("New customer is registered. Username is " + username + " password is " + password);
    }


}




