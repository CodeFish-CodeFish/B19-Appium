package api_demos;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchApp {

    @Test
    public void launchAppTest() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "codefish");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", apkFile.getAbsolutePath());

        URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(appiumServerUrl, caps);

        AndroidElement animationButton = driver.findElement
                (By.xpath("//android.widget.TextView[@content-desc='Animation']"));


        animationButton.click();
    }

    @Test
    public void test2() throws MalformedURLException, InterruptedException {

        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "codefish");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());

        URL connectionUrl = new URL("http://0.0.0.0:4723/wd/hub");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(connectionUrl, desiredCapabilities);

        AndroidElement viewsButton = driver.findElement(
                By.xpath("//android.widget.TextView[@text='Views']"));
        viewsButton.click();

        AndroidElement chronometerButton = driver.findElementByAccessibilityId("Chronometer");
        chronometerButton.click();

        AndroidElement startButton = driver.findElement(By.id("io.appium.android.apis:id/start"));
        startButton.click();

        Thread.sleep(10000);

        AndroidElement stopButton = driver.findElement(By.id("io.appium.android.apis:id/stop"));
        stopButton.click();

        AndroidElement time = driver.findElement(By.id("io.appium.android.apis:id/chronometer"));
        String timeText = time.getText();
        System.out.println(timeText);


    }


}
