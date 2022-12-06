package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Views.DisplayView;
import Views.MainView;
import Views.SettingsView;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;

public class MainViewTest extends BaseTest{

    private static MainView mainView;
    private static SettingsView settingsView;
    private static DisplayView displayView;

    @BeforeAll
    public static void init(){
        mainView = new MainView();
        settingsView = new SettingsView();
        displayView = new DisplayView();
    }

    @Test
    @Feature("Test feature")
    @Description("Try to enable dark mode")
    public void enableDarkMode() throws InterruptedException {
        mainView.verifyAndClickSettingsButton();
        settingsView.pushDisplayButton();
        displayView.toggleDarkMode();

        Assertions.assertTrue(displayView.checkDarkThemeToggle());
    }
}
