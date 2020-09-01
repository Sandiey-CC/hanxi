package com.bcjd.hanxi.commom;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyMsg {
    public static boolean dirtyWords(String username) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        /* ??????? */
        try {
            File file = ResourceUtils.getFile("classpath:static/dirtywords.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                    "UTF-8"));
            String lineTxt = null;
            while (((lineTxt = br.readLine()) != null)) {
                if (username.contains(lineTxt)) {
                    return true;
                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
        return false;
    }

    public static boolean nameIsFormal(String name) {
        if (name == null || name.length() > 10 || name.length() < 3)
            return false;
        else
            return true;
    }

    public static boolean passwordIsFormal(String password) {
        if (password.length() >= 8 && password.length() <= 16)
            return true;
        else
            return false;
    }

    public static boolean checkUsername(String username) {
        Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{2,9}");
        Matcher m = p.matcher(username);
        return m.matches();
    }

    public static boolean checkPassword(String password) {
        Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9]{7,15}");
        Matcher m = p.matcher(password);
        if (m.matches()) {
            char[] chars = password.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkPhoneNum(String phoneNum) {
        if (phoneNum.length() != 11) {
            return false;
        } else {
            /**
             * 移动号段正则表达式
             */
            String pat1 = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
            /**
             * 联通号段正则表达式
             */
            String pat2 = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)\\d{7}$";
            /**
             * 电信号段正则表达式
             */
            String pat3 = "^((133)|(153)|(177)|(18[0,1,9])|(149))\\d{8}$";
            /**
             * 虚拟运营商正则表达式
             */
            String pat4 = "^((170))\\d{8}|(1718)|(1719)\\d{7}$";

            Pattern pattern1 = Pattern.compile(pat1);
            Matcher match1 = pattern1.matcher(phoneNum);
            boolean isMatch1 = match1.matches();
            if (isMatch1) {
                return true;
            }
            Pattern pattern2 = Pattern.compile(pat2);
            Matcher match2 = pattern2.matcher(phoneNum);
            boolean isMatch2 = match2.matches();
            if (isMatch2) {
                return true;
            }
            Pattern pattern3 = Pattern.compile(pat3);
            Matcher match3 = pattern3.matcher(phoneNum);
            boolean isMatch3 = match3.matches();
            if (isMatch3) {
                return true;
            }
            Pattern pattern4 = Pattern.compile(pat4);
            Matcher match4 = pattern4.matcher(phoneNum);
            boolean isMatch4 = match4.matches();
            if (isMatch4) {
                return true;
            }
            return false;
        }
    }
}

