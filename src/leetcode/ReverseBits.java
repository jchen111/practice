package leetcode;

public class ReverseBits {
    public static int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            if((n & 1) == 1) {
                int tmp = 1 << (31 - i);
                res = res | tmp;
            }
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
