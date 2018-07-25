package com.webb.TestCase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.webb.Interface.HttpCase;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class LaladuiCase {
    private AndroidDriver<WebElement> driver;

    public static String MobilePhoneNumber = "13800000002" ;

    @BeforeClass
    public void setUp() throws Exception {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","SCL-TL00"); // Galaxy J3  SCL-TL00
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","7.1.1");  //7.1.1

        //配置测试apk
        capabilities.setCapability("appPackage", "com.yiku.laladui");
        capabilities.setCapability("appActivity", "com.yiku.laladui.MainActivity");
        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        //capabilities.setCapability("unicodeKeyboard", true);    //设置键盘
        //capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘
        capabilities.setCapability("automationName", "uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    //
    @Test
    public void appContact() throws InterruptedException{

        String Usernamexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText[1]";

        String VerificationCodexpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]";

        //验证码按钮
        String VCButten = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1] ";

        //登录按钮
        String Sign = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]";

        Thread.sleep(10000);
        //用户名
        WebElement Username = driver.findElement(By.xpath(Usernamexpath));

        Username.sendKeys(MobilePhoneNumber);

        Thread.sleep(3000);

        driver.findElement(By.xpath(VCButten)).click();

        Thread.sleep(3000);


        try {
            HttpCase.resultCheck();

            System.out.println("嘟嘟噜"+HttpCase.Code);
        } catch (IOException e) {

            e.printStackTrace();
        }


        //验证码
        WebElement VerificationCode = driver.findElement(By.xpath(VerificationCodexpath));

        VerificationCode.sendKeys(HttpCase.Code);

        Thread.sleep(3000);

        driver.findElement(By.xpath(Sign)).click();

    }

    //下拉加载
    public static void swipeToDown(AndroidDriver<WebElement> driver) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        for (int i = 0; i < 82; i++) {
            driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 1000);
            Thread.sleep(1000);
        }
    }

}
