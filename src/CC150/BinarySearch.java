package CC150;

import java.util.Arrays;

public class BinarySearch {
	public static boolean binarySearch(int[] num, int target){
		int length = num.length;
		int mid = length/2;
		if(length==1){
			if(num[0]==target) return true;
			else return false;
		}
		if(target==num[mid]) {
			return true;
		}
		else if(target>num[mid]){
			num = Arrays.copyOfRange(num, mid+1,length);
			return binarySearch(num,target);
		}else if(target<num[mid]){
			num = Arrays.copyOfRange(num, 0,mid);
			return binarySearch(num,target);
		}else{
		return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1};
		System.out.print(binarySearch(num,1));
	}

}
