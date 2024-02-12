package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {
    private SelenideElement
            loginBtn = $("a[href*='redirect']"),
            registrationBtn = $("a[href*='register']");

    @Step("Check that page loaded")
    public WelcomePage checkPageLoaded() {
        $(".main__header").shouldHave(text("Welcome to magic journey with Niffler. The coin keeper"));
        loginBtn.should(visible);
        registrationBtn.should(visible);
        return this;
    }

    @Step("Click to 'Login' button")
    public LoginPage clickLoginButton() {
        loginBtn.click();
        return new LoginPage();
    }
}
