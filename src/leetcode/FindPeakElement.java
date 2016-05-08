package leetcode;

public class FindPeakElement {
	public static int findPeakElement(int[] num) {
        int length = num.length;
        if(length==1){
        	return 0;
        }
        for(int i=1;i<length-1;i++){
        	if(num[i-1]<num[i] && num[i+1]<num[i]){
        		return i;
        	}
        }
        if(num[0]>num[1]){
        	return 0;
        }
        if(num[length-1]>num[length-2]){
        	return length-1;
        }
        return 0;
    }
	
	public static int findPeakElement2(int[] num){
		return helper(num,0,num.length);
	}
	
	public static int helper(int[] num, int start, int end){
		if(start==end) return start;
		if(start+1==end){
			if(num[start]>num[end])
				return start;
			else
				return end;
		}
		int mid = (start+end)/2;
		if(num[mid]>num[mid-1] && num[mid]>num[mid+1]){
			return mid;
		}else if(num[mid]>num[mid-1] && num[mid+1]>num[mid]){
			return helper(num,mid+1,end);
		}else if(num[mid]<num[mid-1] && num[mid+1]<num[mid]){
			return helper(num,start,mid-1);
		}
		else{
			return helper(num,start,mid-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {};
		System.out.println(findPeakElement(num));
	}

}
