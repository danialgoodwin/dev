/**
 * Created by dan on 10/26/15.
 */
package com.anonsage.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A car rental company which rents car by per-hour basis wants to know the time period for maximum number cars that are rented.
 * I.e., you are given the list of rental start time and return times of all rented cars in the day.
 *
 * Find the maximum time period in which cars are on the road.
 *
 * More info: http://www.careercup.com/question?id=5736337204314112
 */
public class CarRental {

    private static void log(String message) {
        System.out.println(message);
    }

    private static final int DAY_IN_MINUTES = 24 * 60;
    private static final long MINUTES_IN_MILLISECONDS = 60 * 1000;
    private static final long DAY_IN_MILLISECONDS = 24 * 60 * 60 * 1000;

    public static void main(String[] args) {
        List<TimeRange> times = new ArrayList<>();
        times.add(new TimeRange(0 * MINUTES_IN_MILLISECONDS, 60 * MINUTES_IN_MILLISECONDS));
        times.add(new TimeRange(30 * MINUTES_IN_MILLISECONDS, 60 * MINUTES_IN_MILLISECONDS));
        times.add(new TimeRange(45 * MINUTES_IN_MILLISECONDS, 60 * MINUTES_IN_MILLISECONDS));
        times.add(new TimeRange(250 * MINUTES_IN_MILLISECONDS, 320 * MINUTES_IN_MILLISECONDS));
        times.add(new TimeRange(250 * MINUTES_IN_MILLISECONDS, 290 * MINUTES_IN_MILLISECONDS));
        times.add(new TimeRange(250 * MINUTES_IN_MILLISECONDS, 270 * MINUTES_IN_MILLISECONDS));
        times.add(new TimeRange(300 * MINUTES_IN_MILLISECONDS, 320 * MINUTES_IN_MILLISECONDS));
        TimeRange range = findTimeWithMostCars(times);
        log("range=" + range.toString());
    }

    // Idea 3: Use an int array to store the change of number of cars on the road. Considerably less time will be used
    //         to traverse array storing the values. Just two per range, rather than stop-start per range.
    // Idea 2: Use an array to store the number of cars active each minute of the day.
    // Idea 1: Sort the time ranges and make a single pass through them, keeping track of active cars. Unfortunately,
    //         this method can get messy because not a good way to sort the time ranges? Mainly in the cases of a
    //         small time range enveloped by a large time range. Idea 3 finds the way around this issue.
    // Clarification needed: Find max time period of cars on road? Or, find max time period of max cars on road?
    //     I'm choosing to do the simpler one for now. It will be easier to expand later, if needed.
    public static TimeRange findTimeWithMostCars(List<TimeRange> times) {
        // Store time range in array.
        int[] cars = new int[DAY_IN_MINUTES];
        for (TimeRange time : times) {
            int startMinute = (int) ((time.start / MINUTES_IN_MILLISECONDS) % DAY_IN_MILLISECONDS);
            int stopMinute = (int) ((time.stop / MINUTES_IN_MILLISECONDS) % DAY_IN_MILLISECONDS);
            cars[startMinute]++;
            cars[stopMinute]--;
        }

        int active = 0;
        int start = -1;
        int stop;
        int range;
        int maxStart = 0;
        int maxStop= 0;
        int maxRange = 0;
        for (int i = 0; i < cars.length; i++) {
            active += cars[i];
            if (start == -1 && active > 0) {
                start = i;
            } else if (active == 0 && start != -1) {
                stop = i;
                range = stop - start;
                if (range > maxRange) {
                    maxRange = range;
                    maxStart = start;
                    maxStop = stop;
                }
                start = -1;
            }
        }

        return new TimeRange(maxStart, maxStop);
    }


    // Improvement: Don't allow negative numbers (and maybe some others).
    private static class TimeRange implements Comparable {
        long start;
        long stop;
        public TimeRange(long start, long stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Object object) {
            TimeRange o = (TimeRange) object;
            if (start < o.start) {
                return -1;
            } else if (start > o.start) {
                return 1;
            } else if (stop < o.start) {
                return -1;
            } else if (stop > o.start) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "TimeRange{" +
                    "start=" + start +
                    ", stop=" + stop +
                    '}';
        }
    }

}
