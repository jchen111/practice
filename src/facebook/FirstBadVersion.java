package facebook;

/**
 * Created by z001ktb on 6/15/17.
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        Long lo = new Long(0);
        Long hi = new Long(n ) + new Long(1);
        while(hi - lo > 1) {
            Long mid = (hi - lo)/2 + lo;
            if(mid - 1 >= 1 && isBadVersion(Math.toIntExact(mid)) && !isBadVersion(Math.toIntExact(mid-1))){
                return Math.toIntExact(mid);
            }else if(isBadVersion(Math.toIntExact(mid))) {
                hi = mid;
            }else {
                lo = mid;
            }
        }
        return 1;
    }

    private static boolean isBadVersion(int n) {
        switch (n){
            case 2147483647 :
                return true;
            default:
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2147483647));
    }
}
