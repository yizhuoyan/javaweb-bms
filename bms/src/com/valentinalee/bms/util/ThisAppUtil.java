package com.valentinalee.bms.util;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThisAppUtil {

	/**
	 * 判断字符串是否为空(null or 空字符串  or  空白字符串)
	 * @param str 待判断的字符串
	 * @return 为空 true,否则 false  
	 */
	public static boolean isNone(String str){
		return str==null||str.trim().length()==0;
	}
	/**
	 * 把字符串按照一定格式转换为时间对象
	 * @param source 源字符串
	 * @param pattern 时间格式
	 * @return 时间对象
	 * @throws ParseException 解析失败
	 */
	public static Date parseDate(String source,String pattern) throws ParseException{
		SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
		return dateFormat.parse(source);
	}
	
	public static void main(String[] args) throws Throwable{
		System.out.println(parseDate("dfdsfdf","yyyy-MM-dd"));
	}
}
