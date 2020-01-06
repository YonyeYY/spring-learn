package spring.airyny.util;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
    private static Logger logger = Logger.getLogger(DateUtils.class);
    private final static DateUtils dateUtils = new DateUtils();
    private static String acceptTime;

    private DateUtils() {
    }

    /**
     * 要用到的DATE Format的定义
     */
    public final static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd"; // 年/月/日
    public final static String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd"; // 年/月/日
    public final static String DATE_FORMAT_YYYY_MM_DD_CH = "yyyy年MM月dd日"; // 年/月/日
    public final static String DATE_FORMAT_YYYY_MM_CH = "yyyy年MM月"; // 年/月
    public final static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss"; // 年/月/日
    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"; // 年/月/日
    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM_STR = "yyyy年MM月dd日HH:mm"; // 年/月/日
    public final static String DATE_FORMAT_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm"; // 年/月/日
    public final static String DATE_FORMAT_DATEONLY_STRING = "yyyyMMdd"; // 年/月/日
    public final static String DATE_FORMAT_YYYYMMDD = "yyyyMMdd"; // 年/月/日
    public final static String DATE_FORMAT_DATETIME_STRING = "yyyyMMddHHmmss"; // 年/月/日
    public final static String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss"; // 年/月/日
    public final static String DATE_FORMAT_TIMEONLY_STRING = "HHmmss"; // 时/分/秒
    public final static String DATE_FORMAT_HH_MM_STR = "HH:mm"; // 时/分/秒

    /**
     * 根据日期格式字符串解析日期字符串
     *
     * @param str           日期字符串
     * @param parsePatterns 日期格式字符串
     * @return 解析后日期
     * @throws ParseException
     */
    public static Date parseDate(String str, String parsePatterns) {
        try {
            return parseDate(str, new String[]{parsePatterns});
        } catch (ParseException e) {
            logger.error("parseDate is error:::" + e.getMessage());
        }
        return null;
    }

    /**
     * 根据日期格式字符串解析日期字符串
     *
     * @param str           日期字符串
     * @param parsePatterns 日期格式字符串
     * @return 解析后日期
     * @throws ParseException
     */
    public static Calendar parseCalendar(String str, String parsePatterns) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(parseDate(str, new String[]{parsePatterns}));
        } catch (ParseException e) {
            logger.error("parseCalendar,str:" + str + "|parsePatterns:" + parsePatterns, e);
        }
        return calendar;
    }

    /**
     * 根据日期格式字符串解析日期字符串
     *
     * @param str 日期字符串
     * @return 解析后日期
     * @throws ParseException
     */
    public static Calendar parseCalendar(String str) {
        return parseCalendar(str, DateUtils.DATE_FORMAT_DATEONLY_STRING);
    }


    /**
     * 判断输入日期是一个星期中的第几天(星期天为一个星期第一天)
     *
     * @param date
     * @return
     */
    public static int getWeekIndex(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    /**
     * 取得通用日期时间格式字符串
     *
     * @param date
     * @return String
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 取得通用日期时间格式字符串
     *
     * @param date
     * @return String
     */
    public static String formatDate2(Date date, String parsePatterns) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(parsePatterns);
        return dateFormat.format(date);
    }

    /**
     * 取得指定日期格式的字符串
     *
     * @param date
     * @return String
     */
    public static String formatDate(Date date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得指定日期格式的时间戳
     *
     * @param date
     * @return String
     */
    public static String formatDate(String timeZone, Long date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            if (!"".equals(timeZone) && null != timeZone)
                dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得指定日期格式的字符串
     *
     * @param date
     * @return String
     */
    public static String formatDate(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return date;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.format(DateUtils.parseDate(date, DateUtils.DATE_FORMAT_YYYYMMDD));
        } catch (Exception e) {
            logger.error("formatDate is error:::" + e.getMessage());
        }
        return date;
    }


    /**
     * 取得指定日期格式的字符串 带时分秒
     *
     * @param date
     * @return String
     */
    public static String formatDateTime(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return date;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.format(DateUtils.parseDate(date, DateUtils.DATE_FORMAT_DATETIME_STRING));
        } catch (Exception e) {
            logger.error("formatDate is error:::" + e.getMessage());
        }
        return date;
    }

    /**
     * 根据传入的数字，输出相比现在days天的数据
     *
     * @param days
     * @return Date
     */
    public static Date getDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 根据传入的数字，输出相比现在days天的数据
     *
     * @param minutes
     * @return Date
     */
    public static Date getDateAddMinute(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }


    /**
     * 根据传入的数字，输出相比现在大days天的数据
     *
     * @param days
     * @return Date
     */
    public static Date getDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 对时间进行格式化
     *
     * @param date
     * @return
     */
    public static Date dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date value = new Date();

        try {
            value = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            logger.error("dateFormat error", e);
            e.printStackTrace();
        }

        return value;

    }


    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 获取今天剩余的毫秒数
     * 每天总共有86400000毫秒，
     * 为了防止redis数据穿透，则预留1分钟强制走数据库
     *
     * @return 今天剩余的毫秒数
     */
    public static long getMilliSecondsLeftToday() {
        long milliSecondsLeftToday = (86400000 - (1000 * 60)) -
                DateUtils.getFragmentInMilliseconds(Calendar.getInstance(), Calendar.DATE);
        return milliSecondsLeftToday <= 0 ? 5000 : milliSecondsLeftToday;
    }


    /**
     * 获取当前时间，对应数据的 AcceptTime 字段
     *
     * @return
     */
    public static String getAcceptTime() {
        return formatDate(new Date(), DateUtils.DATE_FORMAT_DATETIME_STRING);
    }

    /**
     * 时间比较
     *
     * @param endTime
     * @return
     */
    public static boolean compareTime(String endTime, Date currDate) {
        /*Calendar cal = Calendar.getInstance();
        cal.set(cal.HOUR_OF_DAY, Integer.parseInt(endTime.substring(0, 2)));  //获得时
        cal.set(cal.MINUTE, Integer.parseInt(endTime.substring(2, 4))); //获得分
        cal.set(cal.SECOND, Integer.parseInt(endTime.substring(4))); //获得秒

        long currTimeLong = currDate.getTime();
        long endTimeLong = cal.getTime().getTime();

        if (currTimeLong > endTimeLong) {//当前时间大于市场结束时间
            return true;
        }*/
        return Long.parseLong(endTime) < Long.parseLong(DateUtils.formatDate(currDate, DateUtils.DATE_FORMAT_DATETIME_STRING));
    }

    /**
     * 时间比较
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareTime(String startDate, String endDate) {
        try {
            Date $startDate = new Date();
            if (StringUtils.isNotEmpty(startDate)) {
                $startDate = DateUtils.parseDate(startDate, DateUtils.DATE_FORMAT_DATEONLY_STRING);
            }
            Date $endDate = DateUtils.parseDate(endDate, DateUtils.DATE_FORMAT_DATEONLY_STRING);

            long startTimeLong = $startDate.getTime();
            long endTimeLong = $endDate.getTime();

            if (startTimeLong > endTimeLong) {//当前时间大于市场结束时间
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * String转化成对应的形式的翻译
     *
     * @param pDate
     * @param pOrgStyle
     * @param pDateStyle
     * @return
     */
    public static String changeStyle(String pDate, String pOrgStyle, String pDateStyle) {
        String strDate = "";
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat(pOrgStyle).parse(pDate));
            strDate = new SimpleDateFormat(pDateStyle).format(calendar.getTime());
        } catch (Exception e) {
            strDate = pDate;
        }
        return strDate;
    }

    /**
     * 日期相减得到间隔
     *
     * @param dateMinuend
     * @param dateMeiosis
     * @param dateFormat
     * @return
     */
    public static long getMinusDay(String dateMinuend, String dateMeiosis, String dateFormat) throws Exception {
        long day = 0;
        if (dateMinuend.length() != dateMeiosis.length() || dateMinuend.length() != dateFormat.length()) {
            logger.error("dateMinuend【" + dateMinuend + "】;dateMeiosis【" + dateMeiosis + "】;dateFormat【" + dateFormat + "】");
            throw new Exception("日期格式不正确");
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            Date date1 = formatter.parse(dateMinuend);
            Date date2 = formatter.parse(dateMeiosis);
            day = (date1.getTime() - date2.getTime()) / (1000 * 3600 * 24);
        } catch (Exception e) {
            logger.error("dateMinuend【" + dateMinuend + "】;dateMeiosis【" + dateMeiosis + "】;dateFormat【" + dateFormat + "】");
            throw new Exception("日期相减出错");
        }

        return day;
    }

    public static Date[] getSeasonDate(Date date) {
        Date[] season = new Date[3];

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int nSeason = getSeason(date);
        if (nSeason == 1) {// 第一季度
            c.set(Calendar.MONTH, Calendar.JANUARY);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.FEBRUARY);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.MARCH);
            season[2] = c.getTime();
        } else if (nSeason == 2) {// 第二季度
            c.set(Calendar.MONTH, Calendar.APRIL);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.MAY);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.JUNE);
            season[2] = c.getTime();
        } else if (nSeason == 3) {// 第三季度
            c.set(Calendar.MONTH, Calendar.JULY);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.AUGUST);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
            season[2] = c.getTime();
        } else if (nSeason == 4) {// 第四季度
            c.set(Calendar.MONTH, Calendar.OCTOBER);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.NOVEMBER);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.DECEMBER);
            season[2] = c.getTime();
        }
        return season;
    }

    public static int getSeason(Date date) {

        int season = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    /**
     * 取得季度第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDateOfSeason(Date date) {
        return getFirstDateOfMonth(getSeasonDate(date)[0]);
    }

    /**
     * 取得季度最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDateOfSeason(Date date) {
        return getLastDateOfMonth(getSeasonDate(date)[2]);
    }

    public static Date getFirstDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 取得月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 获取时间戳
     *
     * @param dataStr 日期字符串
     * @param patten  日期字符串格式化类型
     * @return
     */
    public static Long getTimeStamp(String dataStr, String patten) {
        SimpleDateFormat format = new SimpleDateFormat(patten);
        Long atamp = 0L;
        try {
            atamp = format.parse(dataStr).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return atamp;
        }
        return atamp;
    }

    /**
     * HH:mm:ss
     *
     * @param timetemp
     * @return
     */
    public static String getHMS(long timetemp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timetemp);
        SimpleDateFormat fmat = new SimpleDateFormat("HHmmss");
        String time = fmat.format(calendar.getTime());
        return time;
    }

    //获取本月的第一天的初始时间【0点】
    public static String getFristDateForNow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 0);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date3 = cal.getTime();
        SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStringYYYYMMDD3 = format3.format(date3);


        return dateStringYYYYMMDD3;
    }

    //加上N月后额获取的最后的时间【接近0点】
    public static String getLastDateForMoverMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
        Date date3 = cal.getTime();
        SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStringYYYYMMDD3 = format3.format(date3);
        return dateStringYYYYMMDD3;
    }


    //加上N月后额获取的第一天的初始时间【0点】
    public static String getFristDateForMoverMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date3 = cal.getTime();
        SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStringYYYYMMDD3 = format3.format(date3);
        return dateStringYYYYMMDD3;
    }

    //获取下月的第一天的初始时间【0点】
    public static String getFristDateForNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 1);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date3 = cal.getTime();
        SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStringYYYYMMDD3 = format3.format(date3);
        return dateStringYYYYMMDD3;
    }

    //获取上月的第一天的初始时间【0点】
    public static String getFristDateForLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date3 = cal.getTime();
        SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStringYYYYMMDD3 = format3.format(date3);
        return dateStringYYYYMMDD3;
    }


    public static void main(String[] args) {
        //   String str = DateUtils.formatDate("Asia/Shanghai",1530868590101L,DateUtils.DATE_FORMAT_YYYY_MM_DD_HH_MM_STR);
//        DateUtils.formatDate(new Date(), DateUtils.DATE_FORMAT_DATETIME_STRING);
//     String str=DateUtils.getAcceptTime();
//        System.out.println(str);
//
//        System.out.println(DateUtils.formatDate(new Date(), DateUtils.DATE_FORMAT_YYYYMMDD));
//
//        System.out.println(DateUtils.formatDate(DateUtils.parseDate("20180914151000",DATE_FORMAT_DATETIME_STRING),DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
//        DateUtils.parseDate("20180914151000",DATE_FORMAT_DATETIME_STRING);


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(5));
        Date date3 = cal.getTime();
        SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStringYYYYMMDD3 = format3.format(date3);
        System.out.println(dateStringYYYYMMDD3);
        System.out.println("========<>========");



        cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(0));
        date3 = cal.getTime();
        format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        dateStringYYYYMMDD3 = format3.format(date3);
        System.out.println(dateStringYYYYMMDD3);
        System.out.println("==========...,.,.,==========");


        cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));

        date3 = cal.getTime();
        format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        dateStringYYYYMMDD3 = format3.format(date3);
        System.out.println(dateStringYYYYMMDD3);
        cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));

        date3 = cal.getTime();
        format3 = new SimpleDateFormat("yyyyMMddHHmmss");
        dateStringYYYYMMDD3 = format3.format(date3);
        System.out.println(dateStringYYYYMMDD3);

        System.out.println("====================");

        System.out.println("季度");
        Date[] season = DateUtils.getSeasonDate(new Date());
        season.toString();
        String s = DateUtils.getLastDateForMoverMonth(new Date(), -1);
        String a = DateUtils.formatDateTime(s, DateUtils.DATE_FORMAT_YYYY_MM_CH);
        System.out.println(a);


        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

            Date retDate = dateFormat.parse("2019-12");

            Date periodName = dateFormat.parse("2019-01");

            System.out.println(retDate.compareTo(periodName));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
