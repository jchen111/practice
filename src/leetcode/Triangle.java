package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle==null) return 0;
        int height = triangle.size();
        for(int i=1;i<height;i++){
        	int old = triangle.get(i).get(0);
        	triangle.get(i).set(0, old+triangle.get(i-1).get(0));
        }
        for(int i=1;i<height;i++){
        	int prelevelsize = triangle.get(i-1).size();
        	int size = triangle.get(i).size();
        	int old = triangle.get(i).get(size-1);
        	triangle.get(i).set(size-1, old+triangle.get(i-1).get(prelevelsize-1));
        }
        for(int i=2;i<height;i++){
        	int size = triangle.get(i).size();
        	for(int j=1;j<size-1;j++){
        		int way1 = triangle.get(i-1).get(j-1);
        		int way2 = triangle.get(i-1).get(j);
        		int old = triangle.get(i).get(j);
        		int myway = Math.min(way1, way2);
        		triangle.get(i).set(j, old+myway);
        	}
        }
        int min = Integer.MAX_VALUE;
        int size = triangle.get(height-1).size();
        for(int i=0;i<size;i++){
        	if(triangle.get(height-1).get(i)<min){
        		min = triangle.get(height-1).get(i);
        	}
        }
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> test = new ArrayList<List<Integer>>();
		ArrayList<Integer> level0 = new ArrayList<Integer>();
		ArrayList<Integer> level1 = new ArrayList<Integer>();
		ArrayList<Integer> level2 = new ArrayList<Integer>();
		level0.add(-1); level1.add(2);level1.add(3);level2.add(1);level2.add(-1);level2.add(-1);
		test.add(level0);test.add(level1);test.add(level2);
		System.out.println(minimumTotal(test));
	}

}
