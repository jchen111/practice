package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class InsertIntervals {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty()){
            intervals.add(newInterval);
            return intervals;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        ListIterator<Interval> li = intervals.listIterator();
        boolean inserted = false;
        while(li.hasNext()){
            Interval itv = li.next();
            if(start <= itv.end){
                if(end < itv.start){ //newInterval does not overlap with current itv, time to insert
                    li.remove();
                    li.add(new Interval(start, end));
                    li.add(itv);
                    inserted = true;
                    break;
                }
                // still some overlap so compare start & end
                start = Math.min(start, itv.start);
                end = Math.max(end, itv.end);
                li.remove();          
            }
        }
        if(!inserted){
            intervals.add(new Interval(start, end));
        }

        return intervals;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(6,9);
		Interval i3 = new Interval(10,12);
		Interval i4 = new Interval(1,2);
//		Interval i5 = new Interval(3,4);
//		Interval i6 = new Interval(2,2);
//		Interval i7 = new Interval(4,6);
		List<Interval> l1 = new LinkedList<Interval>();
		l1.add(i1);
		List<Interval> res = insert(l1,i4);
		for(int i=0;i<res.size();i++){
			System.out.print("["+res.get(i).start+","+res.get(i).end+"]");
		}
	}

}
