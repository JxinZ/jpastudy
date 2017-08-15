package org.spring.springboot.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.proxy.HibernateProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zjx
 * 基本工具类
 * 2017年8月15日
 */
public class ObjectHelper {

	static Logger logger = LoggerFactory.getLogger(ObjectHelper.class);

	public static void main(String[] p) {
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());
		System.out.println(ObjectHelper.isEmpty(sb));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("d", "dddddddddddd");
		map.put("s", "dsdddddddddddd");
		map.put("b", "aadddddddddddd");
	}

	public static boolean isEquals(Object object1, Object object2) {
		boolean ret = false;
		try {
			if (object1 == null && object2 == null) {
				ret = true;
				return ret;
			}
			ret = object1.equals(object2);
		} catch (NullPointerException e) {
			ret = false;
		}
		return ret;

	}

	/**
	 * 比较两字符串是否相等，忽略大小写
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean equalsIgnorecase(String s1, String s2) {
		if (s1 == null && s2 == null)
			return true;
		if (s1 != null && s2 != null) {
			if (s1.toLowerCase().equals(s2.toLowerCase()))
				return true;
		}
		return false;
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 *            -参数对象
	 * @return boolean -true:表示对象为空;false:表示对象为非空 集合： Collection.isEmpty()
	 *         数组：判断数组每个元素，所有元素都为空，即判定数组为空
	 *         字符串：判断字符串等于"null"，或去除两端""字窜后返回String.isEmpty()的结果 其它类型返回 false
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;

		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).entrySet().isEmpty();
		}

		if (obj instanceof Collection) {
			return ((Collection<?>) obj).isEmpty();
		}

		if (obj instanceof String) {
			return ((String) obj).equalsIgnoreCase("null") | ((String) obj).trim().isEmpty();
		}

		if (obj instanceof StringBuffer) {
			return ((StringBuffer) obj).length() == 0;
		}

		if (obj.getClass().isArray()) {
			try {
				Object[] a = (Object[]) obj;

				boolean b = true;
				for (Object o : a) {
					b = b & ObjectHelper.isEmpty(o);

					if (!b)
						break;
				}

				return b;
			} catch (ClassCastException e) {
				logger.error("数组判断出错",e);
			}
		}

		return false;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 校验邮箱是否合规
	 * 
	 * @param email
	 *            邮箱
	 * @return true 合规 false 不合规
	 */
	public static boolean isEmailFormat(String email) {

		Pattern pattern = Pattern
				.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean isEmailAdressFormat(String email) {
		boolean isExist = false;
		if (isEmpty(email)) {
			return isExist;
		}
		Pattern p = Pattern.compile("\\w+@(\\w+\\.)+[a-z]{2,3}");
		Matcher m = p.matcher(email);
		boolean b = m.matches();
		if (b) {
			isExist = true;
		}
		return isExist;
	}

	// /**
	// * 判断Map<String,Object>里指定key的value值是否为空
	// *
	// * @param params
	// * @param key
	// * @return boolean -true:表示value为空;false:表示value为非空
	// */
	// public static boolean isEmpty(Map<String, Object> params, String key) {
	// if (isEmpty(params))
	// return true;
	// else {
	// if (params.containsKey(key) && !isEmpty(params.get(key)))
	// return false;
	// return true;
	// }
	// }
	//
	//
	// /**
	// * 使用模型驱动的时候将模型驱动vo进行字符串解码
	// *
	// * @param obj
	// * 待转码的vo
	// * @throws IllegalArgumentException
	// * 参数错误！参数不能为空。。。
	// * @throws IllegalAccessException
	// * 参数错误！
	// * @throws UnsupportedEncodingException
	// * 不支持的编码方式
	// */
	// public static void decodeObject(Object obj)
	// throws IllegalArgumentException, IllegalAccessException,
	// UnsupportedEncodingException {
	// if (StringUtil.isEmpty(obj)) {
	// return;
	// }
	// // 取得该对象里面所有定义的字段,并对每个字段进行转码
	// for (Field field : obj.getClass().getDeclaredFields()) {
	// // 将此对象的 accessible 标志设置为指示的布尔值。(即,当该字段为private时,也可以访问)
	// field.setAccessible(true);
	// // 回指定对象上此 Field 表示的字段的值。(即,取得传入对象中改字段的值)
	// Object fieldObj = field.get(obj);
	// if (!StringUtil.isEmpty(fieldObj)) {
	// // 只有在字段为String类型的时候才有中文乱码,因为如果是其他类型的话,在类型转换的时候就出错了
	// if (field.getType() == String.class) {
	// // 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。(即,将传入的对象里面的这个字段设置为转码后的值)
	// field.set(
	// obj,
	// !fieldObj.toString().trim().isEmpty() ? URLDecoder
	// .decode(fieldObj.toString(),
	// CommonConstant.UTF8) : null);
	// }
	// }
	// }
	// }
	//
	// /**
	// * 字符串解码
	// *
	// * @param str
	// * 待转码的字符串
	// * @throws UnsupportedEncodingException
	// * 不支持的编码方式
	// */
	// public static void decodeString(String str)
	// throws UnsupportedEncodingException {
	// str = URLDecoder.decode(str, CommonConstant.UTF8);
	// }
	//
	// /**
	// * 将指定字符串的后4个字符替换成*
	// *
	// * @param source
	// * @param len
	// * @return
	// */
	// public static String replacementPartString(String source) {
	// return StringUtil.replacementPartString(source, 4, '*');
	// }
	//
	// /**
	// * 将指定字符串的后Len个字符替换成*
	// *
	// * @param source
	// * @param len
	// * @return
	// */
	// public static String replacementPartString(String source, int len) {
	// return StringUtil.replacementPartString(source, len, '*');
	// }
	//
	// /**
	// * 将指定字符串的后Len个字符替换成replaceStr
	// *
	// * @param source
	// * @param len
	// * @param replaceStr
	// * @return
	// */
	// public static String replacementPartString(String source, int len,
	// char replaceStr) {
	// if (StringUtil.isEmpty(source))
	// return "";
	// else {
	// if (source.length() < 4)
	// return source;
	// else {
	// String dest = source.substring(0, source.length() - 4);
	// for (int i = 0; i < len; i++) {
	// dest += replaceStr;
	// }
	// return dest;
	// }
	// }
	//
	// }
	//
	// /**
	// * 用于处理编号（应用与公文等）
	// *
	// */
	// public static String idCode(String profix, String type, String year,
	// String seq, int len) {
	// String idCode = profix + type + year;
	// for (int i = seq.length(); i < len; i++) {
	// seq = "0" + seq;
	// }
	// return idCode + seq;
	// }
	//
	// /**
	// * 将一个空的object 转换成""
	// *
	// * @param obj
	// * @return
	// */
	// public static String toChangeString(Object obj) {
	// if (obj == null) {
	// obj = "";
	// }
	// return String.valueOf(obj);
	// }
	//
	// /**
	// * 将验证码转换成小写
	// *
	// * @param str
	// * @return
	// */
	// public static String validateToLow(Object str) {
	// String validate = "";
	// if (str != null) {
	// validate = str.toString().toLowerCase();
	// }
	// return validate;
	// }
	//
	//
	// /**
	// * 验证传入的字符串是否是数字
	// *
	// * @Title: PartternValidateNm
	// * @Description:
	// * @param @return
	// * @return boolean
	// * @throws
	// */
	// public static boolean PartternValidateNm(String str) {
	// String pattern = "[0-9]*";
	// Pattern p = Pattern.compile(pattern);
	// Matcher m = p.matcher(str);
	// boolean b = m.matches();
	// return b;
	// }
	//
	// /**
	// * 将一个int数组转换成String
	// *
	// * @param count
	// * @return
	// */
	// public static String intsToString(int[] count) {
	// String str = "";
	// for (int value : count) {
	// str = str + String.valueOf(value) + "@";
	// }
	// return str;
	// }


	/**
	 * 实例化HibernateProxy到具体的实体对象
	 * 
	 * @param obj
	 * @return
	 */
	public static Object initializeProxy(Object obj) {
		if (obj instanceof HibernateProxy) {
			obj = ((HibernateProxy) obj).getHibernateLazyInitializer().getImplementation();
		}

		return obj;
	}

	/**
	 * 判断obj是否实现了type接口,如果type不是接口类型，直接返回false
	 * 
	 * @param obj
	 *            要检测的对象
	 * @param type
	 *            接口的类型
	 * @return
	 */
	public static boolean isImplement(Object obj, Class<?> type) {
		if (!type.isInterface()) {
			return false;
		}

		Class<?>[] clzz = obj.getClass().getInterfaces();

		for (Class<?> clz : clzz) {
			if (clz.getName().equals(type.getName())) {
				return true;
			}
		}

		return false;
	}
}
