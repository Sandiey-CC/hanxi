package com.bcjd.hanxi.commom;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DataUtils {
    //价格规范
    public static String formatPrice(BigDecimal price) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        String xs = df.format(price);
        return xs;
    }
    //简单日期
    public static String getFormatDate(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    //生成32位唯一序列（UUID）
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    //生成随机3位字符
    public static String getRandomCode() {
        return getUUID().substring(0, 3).toUpperCase();
    }

}
