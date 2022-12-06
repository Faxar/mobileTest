package driver;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.annotation.Nonnull;

import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;

public class EmulatorDriver implements WebDriverProvider {
    protected static AndroidDriver driver;
    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String PLATFORM_NAME = ConfigReader.emulatorConfig.platformName();
    private static final String AUTOMATION_NAME = ConfigReader.emulatorConfig.automationName();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();

    public static java.net.URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        //initPackageAndActivity();

        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
        desiredCapabilities.setCapability("platformName", PLATFORM_NAME);

        driver = new AndroidDriver<>(getUrl(), desiredCapabilities);
        return driver;
    }
}
