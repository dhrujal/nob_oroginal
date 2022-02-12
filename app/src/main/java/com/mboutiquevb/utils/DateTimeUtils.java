package com.mboutiquevb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtils {
    public static SimpleDateFormat pauseDateFormator = new SimpleDateFormat("MMM dd");
    public static SimpleDateFormat slashedDateFormator = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat dateFormator = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static SimpleDateFormat globalDateFormator = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat orderDateFormator = new SimpleDateFormat("dd MMM yyyy");
    public static SimpleDateFormat simpleDateFormator = new SimpleDateFormat("dd MMM yyyy hh:mm aa");
    public static SimpleDateFormat dayDateFormator = new SimpleDateFormat("EEEE, dd-MMM-yyyy");
    public static SimpleDateFormat currentDateFormator = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat currentYearFormator = new SimpleDateFormat("yyyy");
    public static SimpleDateFormat hoursFormator = new SimpleDateFormat(" HH:mm ");
    public static SimpleDateFormat onlyHoursFormator = new SimpleDateFormat(" hh aa");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    public static SimpleDateFormat hoursFormat = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat apiDateFormat = new SimpleDateFormat("h aa");

    public static String getPauseFormatDate(Date date) {
        return pauseDateFormator.format(date);
    }


    public static Date getTomorrowDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    public static Date getTomorrowPlusDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        return calendar.getTime();
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 0);
        return calendar.getTime();
    }

    public static String getDate(Date date) {
        if (date == null) {
            return "";
        }
        return simpleDateFormator.format(date);
    }

    public static String getdayDate(Date date) {
        if (date == null) {
            return "";
        }
        return currentDateFormator.format(date);
    }

    public static String getCurrentDate(Date date) {
        if (date == null) {
            return "";
        }
        return currentDateFormator.format(date);
    }

    public static String getCurrentYear(Date date) {
        if (date == null) {
            return "";
        }
        return currentYearFormator.format(date);
    }

    public static String getHours(Date date) {
        if (date == null) {
            return "";
        }
        return hoursFormator.format(date);
    }

    public static String getDateFormat(Date date) {
        if (date == null) {
            return "";
        }
        return currentDateFormator.format(date);
    }

    public static String getTime(Date date) {
        if (date == null) {
            return "";
        }
        return onlyHoursFormator.format(date);
    }

    public static String apiTime(String time) {
        Date date = null;
        if (time == null) {
            return "";
        }
        try {
            date = hoursFormat.parse(time);
        } catch (ParseException e) {
        }
        return apiDateFormat.format(date);
    }

    public static String getOnlyDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateFormat.format(date);
    }

    public static Date stringToDate(String str) {
        Date date = null;
        try {
            date = dateFormator.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String datefromcalander(Date calendar) {
        return currentDateFormator.format(calendar);
    }

    public static String getSplashedDate(Date date) {
        if (date == null) {
            return "";
        }
        return slashedDateFormator.format(date);
    }

    public static Date getTomorrowPlus2Date() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        return calendar.getTime();
    }

    public static Date getPreviousDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date getFirstDateOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

}
