package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/18/16.
 */
public class LisaWorkbook {

    static int countSpecialProb(int numOfChapters, int problemsPerPage, int[] problems) {
        int numOfSpecial = 0;
        int page = 1;
        int chapterIndex = 1;
        for(int i = 0; i < problems.length; i++) {
            while(problems[i] >= problemsPerPage) {
                for(int t = chapterIndex; t < chapterIndex+problemsPerPage; t++ ) {
                    if(page == t) {
                        numOfSpecial++;
                    }
                }
                chapterIndex += problemsPerPage;
                problems[i] -= problemsPerPage;
                page++;
            }
            if(problems[i] > 0) {
                for (int t = chapterIndex; t < chapterIndex + problems[i]; t++) {
                    if (page == t) {
                        numOfSpecial++;
                    }
                }
                page++;
            }
            chapterIndex = 1;
        }

        return numOfSpecial;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t[] = new int[n];
        for(int i=0; i<n; i++) {
            t[i] = sc.nextInt();
        }
        System.out.println(countSpecialProb(n,k,t));
    }
}
