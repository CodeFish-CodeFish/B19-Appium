package api_demos;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Gestures {

    @Test
    public void test() throws MalformedURLException {
        File file = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "codefish");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, desiredCapabilities);
        AndroidElement viewsButton = driver.findElementByAccessibilityId("Views");
//        viewsButton.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton)))
                .perform();
    }

    @Test
    public void test2() throws MalformedURLException {

        File file = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "codefish");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");

        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);

        AndroidElement animationButton = driver.findElementByAccessibilityId("Animation");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(animationButton)))
                .perform();

        AndroidElement eventsButton = driver.findElementByAccessibilityId("Events");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(eventsButton)))
                .perform();

        AndroidElement playButton = driver.findElement(By.id("io.appium.android.apis:id/startButton"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(playButton)))
                .perform();

    }


}
