package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jacky on 9/11/16.
 */
public class BlackList {

    public static ArrayList<Integer> choosenMercenaries = new ArrayList<Integer>();
    public static int minimumCost(int[][] priceList, int adversaryIndex, int cost, int K, int N, int lastMercenary) {
        int min = Integer.MAX_VALUE;
        int choosenMercenary = 11;
        if(adversaryIndex == N-1){
            for(int i = 0; i < K; i++){
                if(priceList[i][N-1] < min){
                    if(i != lastMercenary && !choosenMercenaries.contains(i)){
                        min = priceList[i][N-1];
                        choosenMercenary = i;
                    }else if(i == lastMercenary){
                        min = priceList[i][N-1];
                        choosenMercenary = i;
                    }
                }
            }
            choosenMercenaries.add(choosenMercenary);
            cost += min;
            return cost;
        }else{
            for(int i = 0; i < K; i++){
                if(priceList[i][adversaryIndex] < min){
                    if(i != lastMercenary && !choosenMercenaries.contains(i)){
                        min = priceList[i][adversaryIndex];
                        choosenMercenary = i;
                    }else if(i == lastMercenary){
                        min = priceList[i][adversaryIndex];
                        choosenMercenary = i;
                    }
                }
            }
            choosenMercenaries.add(choosenMercenary);
            cost += min;
            adversaryIndex += 1;
            return minimumCost(priceList,adversaryIndex,cost,K,N,choosenMercenary);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] priceList = new int[K][N];
        for(int i = 0; i < K; i++ ){
            for(int j = 0; j < N; j++){
                priceList[i][j] = sc.nextInt();
            }
        }
        System.out.println(minimumCost(priceList,0,0,K,N,-1));
    }
}
