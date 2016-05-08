package leetcode;
public class QuickSort {
	public static int[] quickSort(int nums[]){
		if(nums.length==0) return null;
		else if(nums.length==1) return nums;
		else doQuickSort(nums,0,nums.length-1);
		return nums;
	}
	public static void doQuickSort(int[] nums,int left,int right){
		int leftindex = left;
		int rightindex = right;
		int mid = left+(right-left)/2;
		int pviot = nums[mid];
		while(left<=right){
			while(left<nums.length-1 && nums[left]<pviot){
				left++;
			}
			while(right>=0 && nums[right]>pviot){
				right--;
			}
			if(left>=right){
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		}
		if(left<rightindex)
			doQuickSort(nums,left,rightindex);
		if(right>leftindex)
			doQuickSort(nums,leftindex,right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,10,4,7};
		nums = quickSort(nums);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
	}

}
