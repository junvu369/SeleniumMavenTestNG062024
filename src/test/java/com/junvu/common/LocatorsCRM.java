package com.junvu.common;

public class LocatorsCRM {
    //Login page
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String checkboxRememberMe = "//input[@id='remember']"; //HTML là thẻ input nhưng giao diện là checkbox nên đặt tên biến là checkbox
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']"; //Forgot Password là key text, ít khi thay đổi (giao diện hiện là link nên đặt tên biến là link
    public static String alertErrorMessage = "//div[@id='alerts']/div";
}
