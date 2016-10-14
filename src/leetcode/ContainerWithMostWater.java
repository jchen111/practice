package leetcode;

/**
 * Created by jacky on 9/13/16.
 */
class ContainerWithMostWater {

//    public static void quickSort(int[] arr, int left, int right) {
//
//        int pivotIndex = left + (right - left) / 2;
//        int pivotValue = arr[pivotIndex];
//
//        int i = left, j = right;
//
//        while (i <= j) {
//
//            while (arr[i] < pivotValue) {
//                i++;
//            }
//
//            while (arr[j] > pivotValue) {
//                j--;
//            }
//
//            if (i <= j) {
//                int tmp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = tmp;
//                i++;
//                j--;
//            }
//
//            if (left < i) {
//                quickSort(arr, left, j);
//            }
//
//            if (right > i) {
//                quickSort(arr, i, right);
//            }
//
//        }
//    }

//    public static int maxArea(int[] height) {
//        int i = 0;
//        int j = height.length - 1;
//        int maxArea = Math.min(height[i],height[j]) * (j - i);
//        while(i < j){
//            if(height[i] < height[j]){
//                i++;
//            }else{
//                j--;
//            }
//            if((Math.min(height[i],height[j]) * (j - i)) > maxArea){
//                maxArea = Math.min(height[i],height[j]) * (j - i);
//            }
//        }
//        return maxArea;
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] heights = new int[N];
//        for(int i = 0; i < N; i++){
//            heights[i] = sc.nextInt();
//        }
////        quickSort(heights,0,N-1);
//        System.out.println(maxArea(heights));
//    }
}
