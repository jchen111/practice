package AirBnB.phone;

/**
 * https://en.wikipedia.org/wiki/Collatz_conjecture
 * 考拉兹猜想
 * 给你公式，比如偶数的话除2，奇数的话就变成3*n+1，对于任何一个正数，数学猜想是最终他会变成1。
 * 每变一步步数加1，给一个上限，让找出范围内最长步数
 *
 * 记忆化搜索
 *
 * 这题如果follow up还可以考虑输出最长的序列，那么我们就需要一个map来保存 integer -> list(integer)
 */

import java.util.HashMap;
import java.util.Map;

public class CollatzConjecture {
    /**
     * https://en.wikipedia.org/wiki/Collatz_conjecture
     * 考拉兹猜想
     * 给你公式，比如偶数的话除2，奇数的话就变成3*n+1，对于任何一个正数，数学猜想是最终他会变成1。
     * 每变一步步数加1，给一个上限，让找出范围内最长步数
     *
     * 记忆化搜索
     *
     * 这题如果follow up还可以考虑输出最长的序列，那么我们就需要一个map来保存 integer -> list(integer)
     */

    public static int findMaxLength(int n) {
        int maxLength = 1;
        int length = 1;
        Map<Integer, Integer> cache = new HashMap<>();

        cache.put(1,1);
        if(cache.containsKey(n)) return cache.get(1);

        for(int i = 2; i <= n; i++) {
            length = 0;
            int seq = i;

            while(seq != 1 && seq >= i) {
                if(seq % 2 == 0) {
                    seq = seq / 2;
                }else {
                    seq = seq * 3 + 1;
                }
                length++;
            }
            cache.put(i,length + cache.get(seq));


            if(cache.get(i) > maxLength) {
                maxLength = cache.get(i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            System.out.println(findMaxLength(i));
        }
        System.out.println(findMaxLength(1000));
    }
}
//}
