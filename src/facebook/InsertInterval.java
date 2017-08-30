package facebook;




import MS.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 6/19/17.
 */
public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int nStart = newInterval.start;
        int nEnd = newInterval.end;
        int i = 0;
        int n = intervals.size();
        List<Interval> result = new ArrayList<Interval>();

        while(i < n && intervals.get(i).end < nStart) {
            result.add(intervals.get(i++));
        }
        if(i == n) {
            result.add(newInterval);
            return result;
        }

        nStart = Math.min(nStart, intervals.get(i).start);

        while(i < n && intervals.get(i).start < nEnd) {
            nEnd = Math.max(nEnd,  intervals.get(i).end);
            i++;
        }

        result.add(new Interval(nStart, nEnd));

        while(i < n) {
            result.add(intervals.get(i++));
        }
        return result;

    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,3));
        list.add(new Interval(6,9));
//        list.add(new Interval(8,10));
//        list.add(new Interval(12,16));

        insert(list, new Interval(2,5));
    }
}
