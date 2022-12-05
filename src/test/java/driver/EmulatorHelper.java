package driver;

import com.codeborne.selenide.SelenideElement;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EmulatorHelper extends EmulatorDriver {

    public static void goBack(){
        driver.navigate().back();
    }

    public static void androidScrollToAnElementByText(String text){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)" +
                        ".instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))")
                .click();
    }

    public static void closeKeyBoard(){
        if(driver.isKeyboardShown()){
            driver.hideKeyboard();
        }
    }

    public static void sendKeysAndFind(SelenideElement element, String text){
        element.sendKeys(text);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

}
