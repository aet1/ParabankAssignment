package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class AccountsPage {
    private static SelenideElement accountsOverviewPageTitle = $(By.xpath("//*[@id='showOverview']/h1")),
            accountTable = $(By.id("accountTable")),
            accountTableHeaderRowElementAccount = $(By.xpath("//*[@id='accountTable']//th[1]")),
            accountTableHeaderRowElementBalance = $(By.xpath("//*[@id='accountTable']//th[2]")),
            accountTableHeaderRowElementAvailable = $(By.xpath("//*[@id='accountTable']//th[3]")),
            accountNumberClickableElement = $(By.xpath("//a[contains(@href,'activity.htm?id=')]")),
            accountIdElement = $(By.id("accountId")),
            accountTypeElement = $(By.id("accountType")),
            balanceElement = $(By.id("balance")),
            availableElement = $(By.id("availableBalance")),
            transactionTable = $(By.id("transactionTable")),
            accountNumberElement = $(By.xpath("//*[@id='accountTable']//td[1]/a"));


    public static void validatePageTitle(){
        accountsOverviewPageTitle.shouldHave(Condition.text("Accounts Overview"));
    }

    /**
     * Method to check Accounts overview table
     */
    public static void validateAccountsOverviewTable(){
        System.out.println("Checking that Accounts Overview table elements are visible");
        accountTable.shouldBe(Condition.visible);
        accountTableHeaderRowElementAccount.shouldHave(Condition.text("Account"));
        accountTableHeaderRowElementBalance.shouldHave(Condition.text("Balance"));
        accountTableHeaderRowElementAvailable.shouldHave(Condition.text("Available Amount"));

    }

    /**
     * Method to open accounts details page
     */
    public static void openAccountDetailsPage() {
        System.out.println("Opening account details page");
        accountNumberClickableElement.click();
    }

    /**
     * Method to check account details page elements
     * @param accountType
     */
    public static void validateAccountDetails (String accountNumber, String accountType) {
        System.out.println("Checking that Accounts details page elements are visible");
        accountIdElement.shouldBe(Condition.visible).shouldHave(Condition.matchText(accountNumber));
        accountTypeElement.shouldBe(Condition.visible).shouldHave(Condition.matchText(accountType));
        balanceElement.shouldNotBe(Condition.empty);
        availableElement.shouldNotBe(Condition.empty);
        transactionTable.shouldBe(Condition.visible);

    }
    public static String getAccountNumber(){
        String accountNumber = accountNumberElement.shouldBe(Condition.visible, Duration.ofMillis(7000)).getText();
        return accountNumber;
    }




}
