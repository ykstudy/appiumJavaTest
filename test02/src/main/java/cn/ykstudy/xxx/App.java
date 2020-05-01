package cn.ykstudy.xxx;

import android.os.Bundle;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

/**
 * @author: yangk
 * @create: 2020/3/22 16:13
 * @program:
 * @description:
 **/
public class App extends UiAutomatorTestCase {

    private int min, max;
    private String wordType;
    private Bundle params = null;

    public static void main(String[] args) {

    }

    public void testDemo() {
        wordType = getParamsVal("wordType", "1");
        min = Integer.parseInt(getParamsVal("minWait", "2"));
        max = Integer.parseInt(getParamsVal("maxWait", "8"));
    }

    //第一个参数：-e 后面的字段
    //第二个参数：在获取不到第一个参数的时候，设置的默认值
    public String getParamsVal(String key, String defVal) {
        String val = "";
        if (null == params)
            params = getParams();
        if (params.isEmpty()) {
            return defVal;
        }

        if (params.containsKey(key)) {
            val = params.getString(key);
            if (null == val) {
                val = defVal;
            }
        } else {
            val = defVal;
        }
        return val;
    }
}
