package google;

import java.util.Scanner;

/**
 * Created by jiaqichen on 11/8/16.
 */
public class SortedTransformedArray {
    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] result = new int[len];
        double symmetryAxis = -1 * ((double)b/2*(double)a);
        if(symmetryAxis <= nums[0]){
            if(a > 0){
                for(int i = 0; i < len; i++){
                    result[i] = a*nums[i]*nums[i] + b*nums[i] + c;
                }
                return result;
            }else if(a < 0){
                for(int i = 0; i < len; i++){
                    result[len-1-i] = a*nums[i]*nums[i] + b*nums[i] + c;
                }
            }else{
                if(b >=0){
                    for(int i = 0; i < len; i++){
                        result[i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }else{
                    for(int i = 0; i < len; i++){
                        result[len-1-i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }
                return result;
            }
        }
        if(symmetryAxis >= nums[len-1]){
            if(a > 0){
                for(int i = 0; i < len; i++){
                    result[len-1-i] = a*nums[i]*nums[i] + b*nums[i] + c;
                }
            }else if(a < 0){
                for(int i = 0; i < len; i++){
                    result[i] = a*nums[i]*nums[i] + b*nums[i] + c;
                }
            }else{
                if(b >=0){
                    for(int i = 0; i < len; i++){
                        result[i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }else{
                    for(int i = 0; i < len; i++){
                        result[len-1-i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }
                return result;
            }
        }
        for(int i = 0; i < len-1; i++){
            if(symmetryAxis >= nums[i] && symmetryAxis <= nums[i+1]){
                if(symmetryAxis == nums[i]){
                    return helper(nums,a,b,c,i,i,result);
                }
                if(symmetryAxis == nums[i+1]){
                    return helper(nums,a,b,c,i+1,i+1,result);
                }
                return helper(nums,a,b,c,i,i+1,result);
            }
        }
        return result;
    }

    public static int function(int a, int b, int c, int x){
        return a*x*x + b*x + c;
    }

    public static int[] helper(int[] nums, int a, int b, int c, int index1, int index2, int[] res){
        if(index1 == index2){
            if(a > 0){
                int index = 0;
                int left = index1 - 1;
                int right = index1 + 1;
                res[index++] = function(a,b,c,nums[index1]);
                while(index < nums.length && left >= 0 && right < nums.length){
                    if(function(a,b,c,nums[left]) > function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[right]);
                        right++;
                    }else if(function(a,b,c,nums[left]) < function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                    }else{
                        res[index++] = function(a,b,c,nums[left]);
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                        right++;
                    }
                    index++;
                }
                while(left >= 0){
                    res[index] = function(a,b,c,nums[left]);
                    left--;
                    index++;
                }
                while(right < nums.length){
                    res[index] = function(a,b,c,nums[right]);
                    right++;
                    index++;
                }
            }else if(a < 0){
                int index = nums.length-1;
                int left = index1 - 1;
                int right = index1 + 1;
                res[index--] = function(a,b,c,nums[index1]);
                while(index >= 0 && left >= 0 && right < nums.length){
                    if(function(a,b,c,nums[left]) > function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                    }else if(function(a,b,c,nums[left]) < function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[right]);
                        right++;
                    }else{
                        res[index++] = function(a,b,c,nums[left]);
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                        right++;
                    }
                    index--;
                }
                while(left >= 0){
                    res[index] = function(a,b,c,nums[left]);
                    left--;
                    index--;
                }
                while(right < nums.length){
                    res[index] = function(a,b,c,nums[right]);
                    right++;
                    index--;
                }

            }else{
                if(b >=0){
                    for(int i = 0; i < nums.length; i++){
                        res[i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }else{
                    for(int i = 0; i < nums.length; i++){
                        res[nums.length-1-i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }
            }
        }else{
            if(a > 0){
                int index = 0;
                int left = index1;
                int right = index2;
                if(function(a,b,c,nums[left]) < function(a,b,c,nums[right])){
                    res[index++] = function(a,b,c,nums[left]);
                    left--;
                }else if(function(a,b,c,nums[left]) > function(a,b,c,nums[right])){
                    res[index++] = function(a,b,c,nums[right]);
                    right++;
                }else{
                    res[index++] = function(a,b,c,nums[left]);
                    res[index] = function(a,b,c,nums[left]);
                    left--;
                    right++;
                }

                while(index < nums.length && left >= 0 && right < nums.length){
                    if(function(a,b,c,nums[left]) > function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[right]);
                        right++;
                    }else if(function(a,b,c,nums[left]) < function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                    }else{
                        res[index++] = function(a,b,c,nums[left]);
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                        right++;
                    }
                    index++;
                }
                while(left >= 0){
                    res[index] = function(a,b,c,nums[left]);
                    left--;
                    index++;
                }
                while(right < nums.length){
                    res[index] = function(a,b,c,nums[right]);
                    right++;
                    index++;
                }
            }else if(a < 0){
                int index = nums.length-1;
                int left = index1;
                int right = index2;
                if(function(a,b,c,nums[left]) < function(a,b,c,nums[right])){
                    res[index--] = function(a,b,c,nums[right]);
                    right++;
                }else if(function(a,b,c,nums[left]) > function(a,b,c,nums[right])){
                    res[index--] = function(a,b,c,nums[left]);
                    left--;
                }else{
                    res[index--] = function(a,b,c,nums[left]);
                    res[index--] = function(a,b,c,nums[left]);
                    left--;
                    right++;
                }
                while(index >= 0 && left >= 0 && right < nums.length){
                    if(function(a,b,c,nums[left]) > function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                    }else if(function(a,b,c,nums[left]) < function(a,b,c,nums[right])){
                        res[index] = function(a,b,c,nums[right]);
                        right++;
                    }else{
                        res[index++] = function(a,b,c,nums[left]);
                        res[index] = function(a,b,c,nums[left]);
                        left--;
                        right++;
                    }
                    index--;
                }
                while(left >= 0){
                    res[index] = function(a,b,c,nums[left]);
                    left--;
                    index--;
                }
                while(right < nums.length){
                    res[index] = function(a,b,c,nums[right]);
                    right++;
                    index--;
                }

            }else{
                if(b >=0){
                    for(int i = 0; i < nums.length; i++){
                        res[i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }else{
                    for(int i = 0; i < nums.length; i++){
                        res[nums.length-1-i] = a*a*nums[i] + b*nums[i] + c;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int[] res = sortTransformedArray(arr,a,b,c);

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
