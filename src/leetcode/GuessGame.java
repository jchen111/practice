package leetcode;

public class GuessGame {
    static int target = 0;
    public static int guessNumber(int n) {
        long low = 0;
        long high = (long)n + 1;
        while(high - low > 1) {
            long mid = (high - low) / 2 + low;
            if(guess((int)mid) > 0) {
                low = mid;
            } else if(guess((int)mid) < 0) {
                high = mid;
            } else {
                return (int)mid;
            }
        }
        return -1;
    }

    private static int guess(int n) {
        if(target > n) {
            return 1;
        } else if(target < n) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(2147483647));
    }

}
