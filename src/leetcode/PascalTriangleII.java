package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangleII {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> res;
        if(rowIndex==0){
        	res = new LinkedList<Integer>();
        	res.add(1);
        	return res;
        }
        res = getRow(rowIndex-1);
        List<Integer> more = new LinkedList<Integer>();
        more.add(1);
        for(int i=0;i<res.size()-1;i++){
        	more.add(res.get(i)+res.get(i+1));
        }
        more.add(1);
        return more;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
