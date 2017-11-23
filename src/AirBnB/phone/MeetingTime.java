package AirBnB.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingTime {
    public static void main(String[] args) {
        List<List<Interval>> intervals = new ArrayList<>();
        List<Interval> inter1 = new ArrayList<>();
        inter1.add(new Interval(1, 3));
//        inter1.add(new Interval(3, 4));
        inter1.add(new Interval(6, 7));
        List<Interval> inter2 = new ArrayList<>();
        inter2.add(new Interval(2, 4));
        List<Interval> inter3 = new ArrayList<>();
        inter3.add(new Interval(2, 3));
        inter3.add(new Interval(9, 11));
        intervals.add(inter1);
        intervals.add(inter2);
        intervals.add(inter3);

        List<Interval> res = getAvailableIntervals(intervals, 3);
        for (Interval inter : res) {
            System.out.println("[" + inter.start + "," + inter.end + "]");
        }
    }

    /**
     * brute force
     * time O(N*M*l) where N is the number of emplyees, M is the average number of meetings each employee has, l is the average length of a meeting
     * space O(L) where L is the latest interval ending time
     * **/
//    public static List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
//        List<Interval> result = new ArrayList<Interval>();
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        for(List<Interval> employee : intervals) {
//            for(Interval interval : employee) {
//                min = Math.min(min, interval.start);
//                max = Math.max(max, interval.end);
//            }
//        }
//        int[] time = new int[max+1];
//        for(List<Interval> employee : intervals) {
//            for(Interval interval : employee) {
//                for(int i = interval.start; i <= interval.end; i++) {
//                    time[i]++;
//                }
//            }
//        }
//
//        int i = min;
//        int start = 0, end = 0;
//        while(i <= max) {
//            while(i <= max && time[i] > 0) { // time[i] > intervals.size() - k
//                start = i;
//                i++;
//            }
//            while(i <= max && time[i] <= 0) { // time[i] <= intervals.size() - k
//                i++;
//                end = i;
//            }
//            if(end > start) {
//                result.add(new Interval(start, end));
//                start = i;
//                end = i;
//            }
//        }
//        return result;
//    }

    public static List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        List<Interval> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for (List<Interval> intervalList : intervals) {
            for (Interval interval : intervalList) {
                points.add(new Point(interval.start, true));
                points.add(new Point(interval.end, false));
            }
        }
        Collections.sort(points);

        int count = 0;
        Integer availableStart = null;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.isStart) {
                count++;
                if (availableStart == null && i == 0 && count <= 0) { // count <= intervals.size() - k
                    availableStart = point.time;
                } else if (availableStart != null && count == 1) {
                    res.add(new Interval(availableStart, point.time));
                    availableStart = null;
                }
            } else {
                count--;
                if (count == 0 && i < points.size() - 1) { //count == intervals.size() - k
                    availableStart = point.time;
                } else if (availableStart != null && i == points.size() - 1 && count <= 0) { // count <= intervals.size() - k
                    res.add(new Interval(availableStart, point.time));
                    availableStart = null;
                }
            }
        }

        return res;
    }

}

class Interval {
    int start;
    int end;
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Point implements Comparable<Point> {
    int time;
    boolean isStart;
    Point(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
    @Override
    public int compareTo(Point that) {
        if (this.time != that.time || this.isStart == that.isStart) {
            return this.time - that.time;
        } else {
            return this.isStart ? -1 : 1; //if time are same, start point should be in front of end point
        }
    }
}
