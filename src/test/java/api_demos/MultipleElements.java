package api_demos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MultipleElements {


    @Test
    public void test() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID); // same as "platformName", "android"
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "codefish");
        caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        URL url = new URL("http://localhost:4723/wd/hub"); // localhost == 0.0.0.0
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);

        List<AndroidElement> items = driver.findElements(By.id("android:id/text1"));

        for (AndroidElement el : items){
            System.out.println(el.getText());
            el.click();
            driver.navigate().back();
//            driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        }








    }


}
