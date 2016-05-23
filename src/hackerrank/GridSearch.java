package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/21/16.
 */
public class GridSearch {

    static boolean findPattern(String[] P, String[] G, int R, int C, int r, int c) {
        int prow = 0;
        int pcol = 0;
        for(int row = 0; row < R-r+1; row++) {
            for (int col = 0; col < C - c + 1; col++) {
                if(G[row].charAt(col) == P[prow].charAt(pcol)) {
                    int irow = row;
                    int icol = col;
                    while(irow < R && icol < C && prow < r && pcol < c && G[irow].charAt(icol) == P[prow].charAt(pcol)) {
                        if(pcol == c-1 || icol == C-1) {
                            if (pcol == c-1) {
                                prow++;
                                if(prow == r) {
                                    return true;
                                }else {
                                    pcol = 0;
                                    irow++;
                                    icol = icol - c + 1;
                                }
                            }
                        }else {
                            icol++;
                            pcol++;
                        }
                    }
                    prow = 0;
                    pcol = 0;
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }

            if(findPattern(P,G,R,C,r,c)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
