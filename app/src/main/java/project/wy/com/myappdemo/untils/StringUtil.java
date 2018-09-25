package project.wy.com.myappdemo.untils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description String类工具集合
 * @Author 一花一世界
 */

public class StringUtil {

    /**
     * @Description 判断字符串是否有值，如果为null或者是空字符串或者只有空格或者为"null"字符串，则返回true，否则则返回false
     */
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim()) && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }

    public static String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time+" 00:00:00";
    }

    /**
     * GMT(格林威治标准时间)转换当前北京时间
     * 比如：1526217409 -->2018/5/13 21:16:49 与北京时间相差8个小时，调用下面的方法，是在1526217409加上8*3600秒
     * @param GMT 秒单部位
     * @return
     */
    public static String[] stampToDate(String GMT) {
         Long newGTM = Long.parseLong(GMT) / 1000;
        long lt = newGTM+8*3600;
        String res = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            res = simpleDateFormat.format(lt*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        return res.split(" ");
    }
}
