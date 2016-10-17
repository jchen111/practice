package leetcode;

/**
 * Created by jiaqichen on 10/13/16.
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        return helper(1,n);
    }

    public static int helper(int start, int end){
        int res = 1;
        while(start <= end){
            if(start == end){
                if(isBadVersion(start))
                    res = start;
            }
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid+1;
            }
        }
        return res;
    }

    public static boolean isBadVersion(int n){
        if(n==2126753390) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

}
