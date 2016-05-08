package leetcode;

public class Sqrt {
	public static int sqrt(int x) {
        if(x==0 || x==1) return x;
        int end = x/2;
		return (int) helper(1,end,x);
    }
	public static long helper(long start,long end,int target){
		long mid = (start+end)/2;
		if(start==end){
		   return mid;
	    }
		
		if(mid*mid<=target && (mid+1)*(mid+1)>target)
			return mid;
		if(mid*mid<target && mid*mid<target){
			return helper(mid+1,end,target);
		}
		if(mid*mid>target && mid*mid>target){
			return helper(start,mid-1,target);
		}
		return mid;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1;i<=2147395599;i++){
//		if(sqrt(i)==0)
//			System.out.println(i);
//		System.out.print(Integer.MAX_VALUE);
		System.out.println(sqrt(1));
		System.out.println((int) Math.sqrt(1850910295));
//		}
	}

}
