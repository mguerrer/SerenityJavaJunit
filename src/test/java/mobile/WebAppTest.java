package mobile;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class WebAppTest {

    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "Nexus 5X API 28");
//        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "9.0");
//        caps.setCapability("skipUnlock","true");
//        caps.setCapability("appPackage", "com.socialnmobile.dictapps.notepad.color.note");
//        caps.setCapability("appActivity","com.socialnmobile.colornote.activity.Main");
//        caps.setCapability("noReset","false");
//        caps.setCapability("automationName","uiAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability("deviceName", "Pixel 2 API 29");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("chromedriverExecutable","/home/cuongld/webdriver");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability(AndroidMobileCapabilityType.SUPPORTS_ALERTS,true);
//        ChromeOptions opt = new ChromeOptions();
//        opt.setExperimentalOption("w3c", true);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test_open_google(){

        driver.get("https://wwww.google.com");
        String name = "Google";

    }

}
