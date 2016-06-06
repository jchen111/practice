package hackerrank;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by z001ktb on 5/28/16.
 */
public class ACMICPCTeam {

    public static HashMap<Integer,Integer> pool = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String topic[] = new String[n];
        ArrayList<BitSet> people = new ArrayList<BitSet>();
        for(int topic_i=0; topic_i < n; topic_i++){
            String input = in.next();
            BitSet bitSet = new BitSet(m);
            for(int i = 0; i < m; i++) {
                if(input.charAt(i) == '1') {
                    bitSet.set(i);
                }
            }
            people.add(bitSet);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                BitSet tmp = (BitSet) people.get(i).clone();
                tmp.or(people.get(j));
                int settedBits = tmp.cardinality();
                if(settedBits > max) {
                    max = settedBits;
                }
                if(pool.containsKey(settedBits)) {
                    int num = pool.get(settedBits);
                    pool.put(settedBits,num+1);
                }else {
                    pool.put(settedBits,1);
                }
            }
        }
        System.out.println(max);
        System.out.println(pool.get(max));
    }
}
