package com.danialgoodwin.interviewcake.question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Danial on 1/23/2015.
 */
public class MergingRangesQuestion extends Question {

    @Override
    protected String getQuestionName() {
        return "MergingRanges";
    }

    @Override
    public void solve() {
        ArrayList<Pair> meetingTimes = new ArrayList<Pair>();
        meetingTimes.add(new Pair(0, 1));
        meetingTimes.add(new Pair(3, 5));
        meetingTimes.add(new Pair(4, 8));
        meetingTimes.add(new Pair(10, 12));
        meetingTimes.add(new Pair(9, 10));

        sortByStartTime(meetingTimes);
        mergeTimes(meetingTimes);
        System.out.println("MergingRangesQuestion. mergedTimes: " + meetingTimes.toString());
    }

    private void sortByStartTime(ArrayList<Pair> meetingTimes) {
        // Space: O(n/2), Time: O(n*lg(n). Both are much better if already mostly sorted.
        Collections.sort(meetingTimes);
    }

    // Space: O(1), Time: O(n).
    private void mergeTimes(ArrayList<Pair> sortedMeetingTimes) {
        if (sortedMeetingTimes == null || sortedMeetingTimes.size() < 2) { return; }

        for (int i = 0; i < sortedMeetingTimes.size() - 1; i++) {
            if (isOverlappingTimes(sortedMeetingTimes.get(i), sortedMeetingTimes.get(i + 1))) {
                // Combine, delete, and repeat
                sortedMeetingTimes.get(i).end = (sortedMeetingTimes.get(i).end > sortedMeetingTimes.get(i + 1).end) ?
                        sortedMeetingTimes.get(i).end : sortedMeetingTimes.get(i + 1).end;
                sortedMeetingTimes.remove(i + 1);
                i--;
            }
        }
    }

    // Note: This requires pair2.start to be >= pair1.start.
    private boolean isOverlappingTimes(Pair pair1, Pair pair2) {
        return pair1.start <= pair2.start && pair1.end >= pair2.start;
    }

    private class Pair implements Comparable {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) { return 0; }
            if (o == null || !(o instanceof Pair)) { throw new IllegalArgumentException("Object cannot be null"); }

            Pair other = (Pair) o;
            if (this.start == other.start) {
                if (this.end == other.end) {
                    return 0;
                } else if (this.end < other.end) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.start < other.start) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
