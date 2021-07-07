package com.example.demo.util;

/**
 * @ClassName: StringsUtil
 * @Description: TODO
 * @Create by: A
 * @Date: 2021/7/7 23:33
 */
public final class StringsUtil {

    /**
     * 如果字符串是null,返回空串 ,否则返回原字符串
     * @param string
     * @return
     */
    public static String nullToEmpty(String string) {
        return string == null ? "" : string;
    }

    /**
     * 如果字符串是空串,返回null ,否则返回原字符串
     * @param string
     * @return
     */
    public static String emptyToNull(String string) {
        return isNullOrEmpty(string) ? null : string;
    }

    /**
     * 判断字符串是不是null
     * @param string
     * @return {@code true} 如果是空串 , {@code false}不是空串
     */
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /**
     *
     * @param string
     * @return {@code true} 如果不是空串 , {@code false}是空串
     */
    public static boolean isNotNullOrEmpty(String string) {
        return string != null && !string.isEmpty();
    }

}
