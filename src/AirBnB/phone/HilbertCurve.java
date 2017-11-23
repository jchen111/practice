package AirBnB.phone;

/**
 * Created by z001ktb
 */
public class HilbertCurve {
    /**
     * Quadrant
     * **/
    public static int hc(int x, int y, int iter) {
        if (iter == 0) {
            return 1;
        }

        int len = (int)Math.pow(2, iter - 1);
        int areaCount = len * len;

        if (x < len && y < len) {
            // III
            return hc(y, x, iter - 1); //previous tier and current tier are symmetrical about straight line y=x
        } else if (x < len && y >= len) {
            // II
            return areaCount + hc(x, y - len, iter - 1); // previous tier is len below current tier
        } else if (x >= len && y >= len) {
            // I
            return 2 * areaCount + hc(x - len, y - len, iter - 1); // current tier can be obtained by moving previous tier len up and len right
        } else {// IV
            return 3 * areaCount + hc( len - 1 - y, 2 * len - 1 - x, iter - 1); // current tier can be obtained by
//            first get symmetrical of previous tier about straight line y=-x, and then moving previous tier 2 * len - 1 to the right and len up
        }
    }

    public static void main(String[] args) {
        System.out.println(hc(1,1,2));
        System.out.println(hc(0,1,1));
        System.out.println(hc(2,2,2));
        System.out.println(hc(1,3,2));
        System.out.println(hc(3,1,2));
        System.out.println(hc(2,2,2));
        System.out.println();
        System.out.println(hc(0,0,1));
        System.out.println(hc(0,0,2));
        System.out.println(hc(1,1,1));
        System.out.println(hc(2,2,2));
        System.out.println(hc(3,0,2));
    }
}
