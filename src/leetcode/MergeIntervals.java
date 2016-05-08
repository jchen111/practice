package leetcode;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        int length = intervals.size();
        if(length==0) return new LinkedList<Interval>();
        int mid = length/2;
        if(length==1){
        	return intervals;
        }
        List<Interval> l1 = intervals.subList(0, mid);
        List<Interval> l2 = intervals.subList(mid, length);
        return ListMerge(merge(l1),merge(l2));
    }
    public static Interval ElementMerge(Interval a, Interval b){
    	if(a.start<=b.start && a.end>=b.end){
    		return new Interval(a.start,a.end);
    	}else if(b.start<=a.start && b.end>=a.end){
    		return new Interval(b.start,b.end);
    	}else if(a.start<=b.start && a.end>=b.start){
    		return new Interval(a.start,b.end);
    	}else if(b.start<=a.start && b.end>=a.start){
    		return new Interval(b.start,a.end);
    	}
    	return null;
    }
    public static List<Interval> ListMerge(List<Interval> l1,List<Interval> l2){
    	List<Interval> res = new LinkedList<Interval>();
    	int i=0,j=0;
    	while(i<l1.size() && j<l2.size()){
    		if(l1.get(i).end<l2.get(j).start){
    			int len = res.size();
    			if(len!=0){
    				Interval tmp = res.get(len-1);
    				if(tmp.end>=l1.get(i).start){
    					res.remove(len-1);
    					res.add(ElementMerge(tmp,l1.get(i)));
    				}else{
    					res.add(l1.get(i));
    				}
    				i++;
    			}else{
    				res.add(l1.get(i));
    				i++;
    			}
    		}else if(l2.get(j).end<l1.get(i).start){
    			int len = res.size();
    			if(len!=0){
    				Interval tmp = res.get(len-1);
    				if(tmp.end>=l2.get(j).start){
    					res.remove(len-1);
    					res.add(ElementMerge(tmp,l2.get(j)));
    				}else{
    					res.add(l2.get(j));
    				}
    				j++;
    			}else{
    				res.add(l2.get(j));
    				j++;
    			}
    		}else{
    			Interval tmp = ElementMerge(l1.get(i),l2.get(j));
    			int len = res.size();
    			if(len!=0){
    				Interval last = res.get(len-1);
    				if(last.end>=tmp.start){
    					res.remove(len-1);
    					res.add(ElementMerge(tmp,last));
    				}else{
    					res.add(tmp);
    				}
    				j++;
    				i++;
    			}else{
    				res.add(tmp);
    				i++;
    				j++;
    			}
    		}
    	}
    	while(i<l1.size()){
    		int len = res.size();
    		Interval tmp = res.get(len-1);
    		if(tmp.end>=l1.get(i).start){
    			res.remove(len-1);
    			res.add(ElementMerge(tmp,l1.get(i)));
    		}else{
    		res.add(l1.get(i));
    		}
    		i++;
    	}
    	while(j<l2.size()){
    		int len = res.size();
    		Interval tmp = res.get(len-1);
    		if(tmp.end>=l2.get(j).start){
    			res.remove(len-1);
    			res.add(ElementMerge(tmp,l2.get(j)));
    		}else{
    		res.add(l2.get(j));
    		}
    		j++;
    	}
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(2,3);
		Interval i2 = new Interval(4,6);
		Interval i3 = new Interval(3,4);
		Interval i4 = new Interval(5,7);
		Interval i5 = new Interval(3,4);
//		Interval i6 = new Interval(2,2);
//		Interval i7 = new Interval(4,6);
		List<Interval> l1 = new LinkedList<Interval>();
		l1.add(i1);l1.add(i2);
		List<Interval> l2 = new LinkedList<Interval>();
		l2.add(i3);l2.add(i4);
		List<Interval> res = ListMerge(l1,l2);
		for(int i=0;i<res.size();i++){
			System.out.print("["+res.get(i).start+","+res.get(i).end+"]");
		}
	}

}
