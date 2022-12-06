package Views;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class DisplayView {

    private final SelenideElement darkThemeToggle = $(MobileBy.AccessibilityId("Dark theme"));


    @Step("Toggle dark mode")
    public void toggleDarkMode() {
        if(darkThemeToggle.isDisplayed()) {
            darkThemeToggle.click();
        }

    }

    @Step("Check if dark mode is enabled")
    public boolean checkDarkThemeToggle() throws InterruptedException {
        Thread.sleep(1000);
        return darkThemeToggle.isEnabled();
    }
}
