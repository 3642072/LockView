package com.darren.utils;

/**
 * Created by Forever on 2016/2/17.
 */
public class AppConfig {
    public static final boolean DEBUG = false;
    public static final String LOGINKEY = "login_key";//用户登录状态
    public static final String GESTUREPASSWORD = "GesturePassword";//手势密码保存
    public static final String CLEAN ="clean";//true:手势密码开启；false：手势密码关闭
    public static final int limitSetPwdNum = 2;//设置手势密码限制次数
    public static final int limitloginPwdNum = 5;//登录手势密码限制次数
}
