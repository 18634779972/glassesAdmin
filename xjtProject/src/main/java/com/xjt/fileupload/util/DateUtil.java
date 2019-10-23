package com.xjt.fileupload.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String formatDate(Date date, String format) {
		if (StringUtils.isBlank(format)) {
			format = DEFAULT_FORMAT;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (date != null) {
			return sdf.format(date);
		} else {
			return "";
		}
	}

	public static Date formatString(String str, String format) throws Exception {
		if (StringUtils.isBlank(format)) {
			format = DEFAULT_FORMAT;
		}
        if (StringUtils.isBlank(str)) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(str);
        }
	}

	public static String getCurrentDateStr() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		return sdf.format(date);
	}
}