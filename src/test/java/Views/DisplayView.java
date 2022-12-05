package Views;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DisplayView {

    private final SelenideElement darkThemeToggle = $(MobileBy.AccessibilityId("Dark theme"));

    @Step
    public void toggleDarkMode() {
        darkThemeToggle.should(Condition.visible).click();
    }
}
