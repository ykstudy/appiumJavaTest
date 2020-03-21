package cn.ykstudy.xxx.appium.script;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

/**
 * @author: yangk
 * @create: 2020/3/22 0:08
 * @program:
 * @description: Appium之上划、下划，左划、右划
 **/
public class SwipeScript {
    static Duration duration = Duration.ofSeconds(1);

    public void swipeToUp(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action1 = new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width / 2, height / 4)).release();
        action1.perform();
    }

    public void swipeToDown(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action2 = new TouchAction(driver).press(PointOption.point(width / 2, height / 4)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width / 2, height * 3 / 4)).release();
        action2.perform();
    }

    public void swipeToLeft(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action3 = new TouchAction(driver).press(PointOption.point(width * 3 / 4, height / 2)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width / 4, height / 2)).release();
        action3.perform();
    }

    public void swipeToRight(AndroidDriver driver) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction action4 = new TouchAction(driver).press(PointOption.point(width / 4, height / 2)).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(PointOption.point(width * 3 / 4, height / 2)).release();
        action4.perform();
    }
}
