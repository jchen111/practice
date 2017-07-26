package facebook;

/**
 * Created by z001ktb on 6/13/17.
 */
public class SortColorII {
    public static void sortColors2(int[] colors, int k) {
        // write your code here
        int[] kcolor = new int[k];
        for(int i = 0; i < colors.length; i++) {
            kcolor[colors[i]%k]++;
        }

        int i = 0;
        while(i < colors.length) {
            for(int j = 1; j < kcolor.length; j++) {
                for(int p = 0; p < kcolor[j]; p++){
                    colors[i++] = j;
                }
            }
            for(int p = 0; p < kcolor[0]; p++) {
                colors[i++] = k;
            }
        }
    }

    public static void main(String[] args) {

    }
}
