package org.springblade.anbiao.baobiaowenjian.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间范围调用工具类
 *
 * @author hyp
 */
public class DateScopeUtil {

    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static String getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7 - 1);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static String getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7 - 1);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(cal.getTime());
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month-1, 1);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(calendar.getTime());
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month-1, 1);
        calendar.roll(Calendar.DATE, -1);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(calendar.getTime());
    }

    public static void main(String[] args) {
        String s1 = getFirstDayOfWeek(2019, 21).toString();
        String s2 = getLastDayOfWeek(2019, 21).toString();
        System.out.println("  ---- " + s1 + "  s2: " + s2);
        String m1 = getFirstDayOfMonth(2019, 5).toString();
        String m2 = getLastDayOfMonth(2019, 5).toString();
        System.out.println("  ---- " + m1 + "  m2: " + m2);
    }


}
