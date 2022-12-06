package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;

import static helper.DeviceHelper.executeBash;
import static helper.RunHelper.runHelper;
import static io.qameta.allure.Allure.step;


public class BaseTest {

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(false).savePageSource(true));
        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        disableAnimationOnEmulator();
    }

    private static void disableAnimationOnEmulator() {
        executeBash("adb -s shell settings put global transition_animation_scale 0.0");
        executeBash("adb -s shell settings put global window_animation_scale 0.0");
        executeBash("adb -s shell settings put global animator_duration_scale 0.0");
    }

    @BeforeEach
    public void startDriver() {
        step("Start app", (Allure.ThrowableRunnableVoid) Selenide::open);
    }

    @AfterEach
    public void afterEach() {
        SelenideLogger.removeListener("allure");
        step("Close app", Selenide::closeWebDriver);
    }
}
