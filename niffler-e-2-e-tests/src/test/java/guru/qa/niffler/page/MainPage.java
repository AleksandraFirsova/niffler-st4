package guru.qa.niffler.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.niffler.page.component.HistoryOfSpendingsTable;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public static final String URL = "/main";

    HistoryOfSpendingsTable historyOfSpendingsTable = new HistoryOfSpendingsTable();

    SelenideElement
            deleteSelectedBtn = $$("button[type = 'button']").findBy(Condition.text("Delete selected"));

    @Step("Check that page loaded")
    public MainPage checkPageLoaded() {
        $(".main-content").shouldHave(Condition.text("Add new spending"), Condition.text("History of spendings"));
        return this;
    }

    @Step("Select spend with description: {description}")
    public MainPage selectSpendingByDescription(String description) {
        historyOfSpendingsTable.getRowByDescription(description)
                .$("td")
                .scrollIntoView(true)
                .click();
        return this;
    }

    @Step("Click 'Delete selected' button")
    public MainPage clickDeleteSelectedButton() {
        deleteSelectedBtn.click();
        return this;
    }

    @Step("Check that the number of rows in the table with spends is equal to {size}")
    public MainPage checkSpendingTableRowsHasSize(int size) {
        historyOfSpendingsTable.getTableRows().shouldHave(size(size));
        return this;
    }
}
