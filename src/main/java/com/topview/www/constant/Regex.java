package com.topview.www.constant;

/**
 * 正则表达式类
 * @author Pan梓涵
 *
 */
public class Regex {
	
	//邮箱正则表达式
	public static final String REGEX_EMAIL = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
	//手机号正则表达式
	public static final String REGEX_PHONE = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
	
}
