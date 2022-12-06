package Views;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SettingsView {

    private final SelenideElement displaySettingsButton =  $(MobileBy.xpath("(//android.widget.TextView[@text=\"Display\"])"));

    @Step("Verify display settings view")
    public void pushDisplayButton() {
        if(displaySettingsButton.isDisplayed()) {
            displaySettingsButton.click();
        }
    }
}
