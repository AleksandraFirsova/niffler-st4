package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String URL = "/login";
    private SelenideElement
            userNameInput = $("input[name='username']"),
            passwordInput = $("input[name='password']"),
            signInBtn = $(".form__submit");

    @Step("Check that page loaded")
    public LoginPage checkPageLoaded() {
        $(".form__header").shouldHave(text("Welcome to Niffler. The coin keeper"));
        userNameInput.should(visible);
        passwordInput.should(visible);
        return this;
    }

    @Step("Check that page loaded")
    public MainPage login(String userName, String password) {
        userNameInput.setValue(userName);
        passwordInput.setValue(password);
        signInBtn.click();
        return new MainPage();
    }
}
