package guru.qa.niffler.test;

import com.codeborne.selenide.Configuration;
import guru.qa.niffler.jupiter.GenerateCategory;
import guru.qa.niffler.jupiter.GenerateSpend;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.SpendJson;
import guru.qa.niffler.page.MainPage;
import guru.qa.niffler.page.WelcomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class SpendingTest extends BaseWebTest {

    static {
        Configuration.browserSize = "1980x1024";
        baseUrl = "http://127.0.0.1:3000";
    }

    WelcomePage welcomePage = new WelcomePage();

    @BeforeEach
    void doLogin() {
        open(baseUrl);
        welcomePage
                .checkPageLoaded()
                .clickLoginButton()
                .checkPageLoaded()
                .login("duck", "12345")
                .checkPageLoaded();
    }

    @GenerateCategory(
            username = "duck",
            category = "Обучение"
    )
    @GenerateSpend(
            username = "duck",
            description = "QA.GURU Advanced 4",
            amount = 72500.00,
            currency = CurrencyValues.RUB
    )
    @Test
    void spendingShouldBeDeletedByButtonDeleteSpending(SpendJson spend) {
        open(MainPage.URL, MainPage.class)
                .selectSpendingByDescription(spend.description())
                .clickDeleteSelectedButton()
                .checkSpendingTableRowsHasSize(0);
    }
}
