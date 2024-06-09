package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class AccountsPage {
    static Duration TIMEOUT = Duration.ofMillis(5000);
    private static String accountNumber;
    private static SelenideElement accountsOverviewPageTitle = $(By.xpath("//*[@id='showOverview']/h1")),
            accountTable = $(By.id("accountTable")),
            accountTableHeaderRowElementAccount = $(By.xpath("//*[@id='accountTable']//th[1]")),
            accountTableHeaderRowElementBalance = $(By.xpath("//*[@id='accountTable']//th[2]")),
            accountTableHeaderRowElementAvailable = $(By.xpath("//*[@id='accountTable']//th[3]")),
            accountNumberClickableElement = $(By.xpath("//*[@id='loginPanel']//a[@href='activity.htm?id=" + accountNumber + "']")),
            accountIdElement = $(By.id("accountId")),
            accountTypeElement = $(By.id("accountType")),
            balanceElement = $(By.id("balance")),
            availableElement = $(By.id("availableBalance")),
            transactionTable = $(By.id("transactionTable")),
            accountNumberElement = $(By.xpath("//*[@id='accountTable']//td[1]/a"));


    public static void validatePageTitle(){
        accountsOverviewPageTitle.shouldHave(Condition.text("Accounts Overview"));
    }

    public static void validateAccountsOverviewTable(){
        accountTable.shouldBe(Condition.visible);
        accountTableHeaderRowElementAccount.shouldHave(Condition.text("Account"));
        accountTableHeaderRowElementBalance.shouldHave(Condition.text("Balance"));
        accountTableHeaderRowElementAvailable.shouldHave(Condition.text("Available Amount"));

    }

    public static void openAccountDetailsPage(String accountNumber) {
        accountNumberClickableElement.click();
    }

    public static void validateAccountDetails (String accountNumber, String accountType) {
        accountIdElement.shouldBe(Condition.visible).shouldHave(Condition.matchText(accountNumber));
        accountTypeElement.shouldBe(Condition.visible).shouldHave(Condition.matchText(accountType));
        balanceElement.shouldNotBe(Condition.empty);
        availableElement.shouldNotBe(Condition.empty);
        transactionTable.shouldBe(Condition.visible);

    }
    public static String getAccountNumber(){
        accountNumber = accountNumberElement.getValue();
        return accountNumber;
    }




}
