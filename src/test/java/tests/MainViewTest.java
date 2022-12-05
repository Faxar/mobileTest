package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Views.DisplayView;
import Views.MainView;
import Views.SettingsView;
import io.qameta.allure.Description;

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

    @Description("First test try")
    @Test
    public void testPushOfTheButton() {
        mainView.pushSettingsButton();
        settingsView.pushDisplayButton();
        displayView.toggleDarkMode();
    }
}
