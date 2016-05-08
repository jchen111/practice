package leetcode;

/**
 * Created by z001ktb on 2/2/16.
 */
public class NimGame_292 {
    public static boolean canWinNim(int n){
        if(n-4 < 0){
            return true;
        }else{
            if(n-4 == 0){
                return false;
            }
            else{
                return canWinNim(n-4);
            }
        }
    }

    public static boolean canWinNim1(int n){
        if(n-4 < 0){
            return true;
        }
        else if(n == 4){
            return false;
        }else{
            if(n%4 >0){
                return true;
            }
            return false;
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {4,5,9,8,13};
        for(int i=0; i< a.length;i++) {
            System.out.println(a[i] + ":" + canWinNim1(a[i]));
        }
    }
}
