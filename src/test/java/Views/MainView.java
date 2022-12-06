package Views;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainView {

    private final SelenideElement settingsButton = $(MobileBy.AccessibilityId("Settings"));

    @Step("Verify settings button")
    public void verifyAndClickSettingsButton() {
        if (settingsButton.isDisplayed()) {
            clickSettingsButton();
        }
    }

    @Step("Click on the setting button")
    private void clickSettingsButton() {
        settingsButton.click();
    }

}
