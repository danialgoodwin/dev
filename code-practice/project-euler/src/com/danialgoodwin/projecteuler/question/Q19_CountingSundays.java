/**
 * Created by Danial on 4/14/2015.
 */
package com.danialgoodwin.projecteuler.question;

import java.util.Calendar;
import java.util.GregorianCalendar;

/** You are given the following information, but you may prefer to do some research for yourself.

 1 Jan 1900 was a Monday.
 Thirty days has September,
 April, June and November.
 All the rest have thirty-one,
 Saving February alone,
 Which has twenty-eight, rain or shine.
 And on leap years, twenty-nine.
 A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

 How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * Website: https://projecteuler.net/problem=19
 */
public class Q19_CountingSundays extends Question {

    @Override
    protected String getQuestionName() {
        return "Q19_CountingSundays";
    }

    @Override
    public void solve() {
//        Calendar dateFrom = new GregorianCalendar(1901, 1, 1);
//        Calendar dateTo = new GregorianCalendar(2000, 12, 31);
//        int answer = countSundaysOnFirstOfMonth(dateFrom, dateTo);
//        int answer = countSundaysOnFirstOfMonth(1901, 2000);
        int answer = countSundaysOnFirstOfMonth(2000, 1901);
        log("answer=" + answer);
    }


    // Notes:
    // - The first of day of a year could begin on one of seven days.
    // - Each on of those days would have a two certain amount of sundays on the first of them month - either with or without leap day.
    // - So, calculate those 14 constant values once, then apply for year.
    // - Or, if it's fast enough, since it's only 100 years, just iterate through all years.
    /** Return the number of Sundays that fell on the first of the month from dateFrom to dateTo.
     * One optimization would be to only create the GregorianCalendar once. */
    private static int countSundaysOnFirstOfMonth(int yearFrom, int yearTo) {
        if (yearFrom > yearTo) {
            yearFrom ^= yearTo;
            yearTo ^= yearFrom;
            yearFrom ^= yearTo;
        }
        int numberOfSundays = 0;
        for (int year = yearFrom; year <= yearTo ; year++) {
            numberOfSundays += countSundaysOnFirstOfMonth(year);
        }
        return numberOfSundays;
    }

    /** Return the number of Sundays that fell on the first of the month for the supplied year. */
    private static int countSundaysOnFirstOfMonth(int year) {
        int numberOfSundays = 0;
        Calendar date = new GregorianCalendar(year, 1, 1);
        for (int month = 0; month < 12; month++) {
            date.set(Calendar.MONTH, month);
            int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY) { numberOfSundays++; }
        }
        return numberOfSundays;
    }


    // Notes: The first of a
    /** Return the number of Sundays that fell on the first of the month from dateFrom to dateTo. */
//    private static int countSundaysOnFirstOfMonth(Calendar dateFrom, Calendar dateTo) {
//        // TODOv2: Make sure that dateTo is the later date.
//        Calendar date = dateFrom;
//        Calendar endDate = dateTo;
//
//        int numberOfSundays = 0;
//        final int endYear = dateFrom.get(Calendar.YEAR);
//        while (date.before(endDate)) {
//
//        }
//
//        return numberOfSundays;
//    }

}
