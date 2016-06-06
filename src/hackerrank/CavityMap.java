package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/22/16.
 */
public class CavityMap {
    static void findCavity(String[] grid) {
        int size = grid.length;
        StringBuilder sb;
        String[] res = new String[size];
        res[0] = grid[0];
        for(int i = 1; i < size-1; i++) {
            sb = new StringBuilder();
            res[i] = "";
            int flag = 0;
            for(int j=1; j < size-1; j++) {
                if(grid[i-1].charAt(j) < grid[i].charAt(j) && grid[i+1].charAt(j) < grid[i].charAt(j) && grid[i].charAt(j-1) < grid[i].charAt(j) && grid[i].charAt(j+1) < grid[i].charAt(j)) {
                    sb.append(grid[i].substring(flag,j)+'X');
                    flag = j+1;
                    res[i] += sb.toString();
                    sb = new StringBuilder();
                }
            }
            res[i] += grid[i].substring(flag);
        }
        res[size-1] = grid[size-1];
        for(int i=0; i<size; i++) {
            System.out.println(res[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String grid[] = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        findCavity(grid);
    }
}
