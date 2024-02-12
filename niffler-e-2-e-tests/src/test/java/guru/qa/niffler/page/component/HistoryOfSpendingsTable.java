package guru.qa.niffler.page.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HistoryOfSpendingsTable {

    private SelenideElement self = $(".spendings-table tbody");
    private ElementsCollection rows = self.$$("tr");

    public ElementsCollection getTableRows() {
        return rows;
    }

    public SelenideElement getRowByDescription(String description) {
        return rows.find(Condition.text(description));
    }
}
