package MS.OTS;

import java.util.*;

/**
 * Created by z001ktb
 */
public class RearrangeString {
    static class Occur {
        Character c;
        int count;
        Occur(Character ch) {
            c = ch;
        }
    }

    public static String rerrangeString(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        LinkedList<Occur> queue = new LinkedList<Occur>();

        for(int i = 0; i < str.length(); i++) {
            int count = map.containsKey(str.charAt(i)) ? map.get(str.charAt(i)) + 1 : 1;
            map.put(str.charAt(i), count);
        }

        for(Character key : map.keySet()) {
            Occur occur = new Occur(key);
            occur.count = map.get(key);
            queue.offer(occur);
        }

        queue.sort(new Comparator<Occur>() {
            @Override
            public int compare(Occur o1, Occur o2) {
                return o2.count - o1.count;
            }
        });

        while(!queue.isEmpty()) {
            Occur cur = queue.poll();
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == cur.c) break;
            sb.append(cur.c);
            cur.count--;
            if(cur.count > 0) queue.offer(cur);
        }

        if(sb.length() < str.length()) System.out.println("Impossible");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rerrangeString("a"));
    }
}
