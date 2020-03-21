package cn.ykstudy.xxx;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import cn.ykstudy.xxx.appium.script.SwipeScript;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		File classpathRoot = new File("E:\\git\\appiumJavaTest");
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "manage.apk");
		if (!app.exists()) {
			System.out.println("本次需要安装的APK不存在");
			System.exit(0);
		}
		// 设置代理服务器
		AndroidDriver<AndroidElement> driver = null;
		// 设置启动参数
		DesiredCapabilities des = new DesiredCapabilities();
		// 设置浏览器类型 如果为空，就取用Appium中设定的浏览器
		des.setCapability(CapabilityType.BROWSER_NAME, "");
		// 设置键盘使得支持中文输入
		des.setCapability("unicodeKeyboard", true);
		des.setCapability("resetKeyboard", true);
		// 设置测试平台
		des.setCapability("platformName", "Android");
		// 设置设备名称
		des.setCapability("deviceName", "HUAWEI Honor V9");
		// 设置Android版本
		des.setCapability("platformVersion", "9");
		// 连接的物理设备的唯一设备标识
		des.setCapability("udid", "2f9b7a92");
		// 配置待测试的apk的路径
		des.setCapability("app", app.getAbsolutePath());
		// App安装后的包名,注意与原来的CalcTest.apk不一样
//		des.setCapability("appPackage", "com.xuekevip");
		// app测试人员常常要获取activity，进行相关测试,后续会讲到
//		des.setCapability("appActivity", "com.tianqi2345.homepage.ChooseCityActivity");

      //des.setCapability("automationName", "Appium");//Selendroid //自动化的模式选择
      //des.setCapability("browserName", "chrome");  //h5
		// 没有新命令时的超时时间设置
//		des.setCapability("newCommandTimeout", "60");
		// 跳过检查和对应用进行 debug 签名的步骤
//		des.setCapability("nosign", "True");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
		// 设置隐式等待超时时间,默认9500ms
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("App Start");
		Thread.sleep(2000);
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		SwipeScript swipeScript = new SwipeScript();
		TouchAction action1 = new TouchAction(driver)
				.press(PointOption.point(width*3/4, height/2))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(width/10,height/2))
				.release();
		action1.perform();
		Thread.sleep(2000);
		TouchAction action2 = new TouchAction(driver)
				.press(PointOption.point(width*3/4, height/2))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(width/10,height/2))
				.release();
		action2.perform();
		Thread.sleep(2000);
		TouchAction action3 = new TouchAction(driver)
				.press(PointOption.point(width*3/4, height/2))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(width/10,height/2))
				.release();
		action3.perform();
		Thread.sleep(2000);
	}
}
