package google;

import java.util.*;

/**
 * Created by jiaqichen on 11/24/16.
 */
public class SkylineProblem {

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        //默认初始堆大小11
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2 - o1;
            }

        });
        //保存即将排序后的轮廓边缘点
        List<int[]> sort = new ArrayList<int[]>();

        for(int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            sort.add(new int[]{building[0], building[2]});
            sort.add(new int[]{building[1], -building[2]});
        }
        //将所有轮廓边缘点排序
        Collections.sort(sort, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });

        int pre = 0;
        int cur = 0;
        for(int i = 0; i < sort.size(); i++) {
            int[] building = sort.get(i);
            if(building[1] > 0) {
                maxHeap.add(building[1]);
                cur = maxHeap.peek();
            } else {
                maxHeap.remove(-building[1]);
                cur = (maxHeap.peek() == null) ? 0:maxHeap.peek();
            }
            //当前结点与前一结点不同，说明遇到拐点
            if(cur != pre) {
                result.add(new int[]{building[0], cur});
                pre = cur;
            }
        }

        return result;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] buildings = new int[N][N];
        for(int i = 0; i < N; i++){
            buildings[i][0] = sc.nextInt();
            buildings[i][1] = sc.nextInt();
            buildings[i][2] = sc.nextInt();
        }
        getSkyline(buildings);
    }
}
