package util;

public class StringUtils {
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.equals("") || str.matches("\\s*");
	}

	/**
	 * 给输入的字符串设置默认值
	 * 
	 * @param content
	 * @param defaultValue
	 * @return
	 */
	public static String defaultValue(String content, String defaultValue) {
		if (isEmpty(content)) {
			return defaultValue;
		}
		return content;
	}
}
