package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiaqichen on 10/16/16.
 */
public class GasStation {
    //O(n)
    /**
     * This solution is based on two observation:
     * 1. If start from station i, can not reach station j, then every station between i and j
     *      can not reach j;
     * 2. If totalGas (gas[0] + gas[1] + ... + gas[N-1]) is bigger than totalCost (cost[0] + cost[1] + ... + cost[N-1])
     *      then there must be a valid start index.
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int begin = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            int remain = gas[i] - cost[i];
            tank += remain;
            if(tank < 0){
                begin = i+1;
                tank = 0;
            }
        }
        if(totalGas >= totalCost) return begin;
        else return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2};
        int[] cost = {2,1};
        canCompleteCircuit(gas,cost);
    }
}
