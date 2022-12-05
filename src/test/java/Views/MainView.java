package Views;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainView {

    private final SelenideElement settingsButton = $(MobileBy.AccessibilityId("Settings"));
    private final SelenideElement messageButton = $(MobileBy.AccessibilityId("Messages"));

    @Step
    public void pushMessageButton() {
        messageButton.should(Condition.visible).click();
    }

    @Step
    public void pushSettingsButton() {
        settingsButton.should(Condition.visible).click();
    }

}
