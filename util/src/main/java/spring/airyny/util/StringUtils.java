package spring.airyny.util;

import com.alibaba.dubbo.common.json.JSON;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yonye
 * @Package_name:
 * @Description: String工具类
 * @Date:
 * @Moditied:
 */
public class StringUtils {
    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    private StringUtils() {
        throw new IllegalAccessError("Utility class");
    }

    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    /**
     * @param pStr
     *            需要判断的值
     * @Title:isEmpty
     * @Description:是否为空
     * @author pinro
     */
    public static boolean isEmpty(String pStr) {
        return pStr == null || pStr.trim().length() == 0 || "null".equals(pStr);
    }

    public static boolean isNotEmpty(String pStr) {
        return !isEmpty(pStr);
    }

    public static String defaultIfBlank(String str, String defaultStr) {
        return isEmpty(str) ? defaultStr : str;
    }

    /**
     * @param ch
     *            需要转换的char
     * @Title:charToByteAscii
     * @Description:char转换成byte
     * @author pinro
     */
    public static byte charToByteAscii(char ch) {
        byte byteAscii = (byte) ch;
        return byteAscii;
    }

    /**
     * @Title:copyModel
     * @Description:拷贝属性
     * @author pinro
     */
    public static Object copyModel(Object classType, String[] parameters, Object o) {
        Object invoker = classType;
        Map<String, String> map = new HashMap<String, String>();
        try {
            Method method;
            Class<?> clazz = classType.getClass();
            Field[] fields = clazz.getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
            Field[] ofields = o.getClass().getDeclaredFields();// 根据Class对象获得属性 私有的也可以获得
            for (Field of : ofields) {
                map.put(of.getName(), of.getName());
            }
            for (String param : parameters) {
                for (Field f : fields) {
                    if (f.getName().equals(param) && map.containsKey(param)) {
                        String strFieldName = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                        if (f.getType().getName().equals("java.lang.String")) {
                            method = classType.getClass().getMethod("set" + strFieldName, new Class[] { String.class });
                            Method m = o.getClass().getMethod("get" + strFieldName);
                            method.invoke(invoker, new Object[] { (String) m.invoke(o) });
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("copyModel is error:::", e);
        }
        return invoker;
    }

    /**
     * @Title:defIfEmpty
     * @Description:判断为空的默认值
     * @author pinro
     */
    public static String defIfEmpty(String pStr, String pDefStr) {
        return isEmpty(pStr) ? pDefStr : pStr;
    }

    /**
     * 对象转成json
     *
     * @param o
     * @return
     */
    public static String toJson(Object o) {
        try {
            return JSON.json(o);
        } catch (IOException e) {
            logger.error("toJson 错误", e);
        }
        return "";
    }

    public static String format2RatioString(String value) {
        DecimalFormat formatter = new DecimalFormat("###############0.00");
        return (formatter.format(parseDouble(value)));
    }

    public static String format4RatioString(String value) {
        DecimalFormat formatter = new DecimalFormat("###############0.0000");
        return (formatter.format(parseDouble(value)));
    }
    public static String format5RatioString(String value) {
        DecimalFormat formatter = new DecimalFormat("###############0.00000");
        return (formatter.format(parseDouble(value)));
    }

    private static double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            logger.error("parseDouble 错误", e);
            return 0;
        }
    }

    public static void main(String[] args){
        System.out.println();
    }
}
