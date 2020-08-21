package com.cn.poker.admin.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期处理
 */
public class DateUtils {
	
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";

	/** 时间格式(yyyy/MM/dd) */
	public final static String DATE_PATTERN_SLASH = "yyyy/MM/dd";
	
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/** 时间格式(yyyy年M月dd日 ah:mm:ss) 代码生成器使用 */
	public final static String DATE_TIME_CHN_PATTERN = "yyyy年M月dd日 ah:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}


	/**
	 * 获取当前时间 后多少天的 时间
	 * @param days 天数
	 * @return 指定天数之前的日期
	 */
	public static Date getDateAfter( int days) {
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
		return now.getTime();
	}
}
