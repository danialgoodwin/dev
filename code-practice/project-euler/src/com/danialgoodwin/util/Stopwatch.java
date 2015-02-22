/**
 * Created by Danial on 2014-09-16.
 */
package com.danialgoodwin.util;

/** Simple wrapper for using `System.currentTimeMillis()` to time events. May use nanos in future. */
public class Stopwatch {

    private long start = 0;
    private long end = 0;

    public Stopwatch() {
        start = 0;
        end = 0;
    }

    public void reset() {
        start = 0;
        end = 0;
    }

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        end = System.currentTimeMillis();
    }

    public long getTime() {
        return end - start;
    }

    public long getLapTime() {
        return System.currentTimeMillis() - start;
    }

}
