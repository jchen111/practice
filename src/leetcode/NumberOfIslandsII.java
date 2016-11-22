package leetcode;

import java.util.*;
import java.util.stream.StreamSupport;

/**
 * Created by z001ktb on 11/12/16.
 */
public class NumberOfIslandsII {

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<Integer>();
        int[] roots = new int[m*n];
        Arrays.fill(roots,-1);
        int count = 0;
        for(int i = 0; i < positions.length; i++){
            int root = positions[i][0]*n + positions[i][1];
            roots[root] = root;
            count++;
            //find all the neighbors
            for(int[] dir : dirs){
                int x = positions[i][0]+dir[0];
                int y = positions[i][1]+dir[1];
                int id = x*n + y;
                if(x >= m || x < 0 || y >= n || y < 0 || roots[id] == -1) continue;
                int newroot = find(roots,id);
                if(newroot != root){
                    roots[root] = newroot;
                    count--;
                    root = newroot;
                }
            }
            result.add(count);

        }
        return result;
    }

    public static int find(int[] roots, int id){
        if(roots[id] == id){
            return id;
        }
        return find(roots,roots[id]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int N = sc.nextInt();
        int[][] pos = new int[N][2];
        for(int i = 0; i < N; i++){
            pos[i][0] = sc.nextInt();
            pos[i][1] = sc.nextInt();
        }
        System.out.println(numIslands2(m,n,pos));
    }
}
