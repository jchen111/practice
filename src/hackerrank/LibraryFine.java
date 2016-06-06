package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/24/16.
 */
public class LibraryFine {
    public static int[] daysOfMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int[] leapYearDaysOfMonth = {0,31,29,31,30,31,30,31,31,30,31,30,31};

    public static boolean checkLeapYear(int y) {
        if(y%400 == 0){
            return true;
        }
        return false;
    }

    public static int countDays(int m1, int d1, int m2, int d2, int y) {
        int days = 0;
        if(checkLeapYear(y)) {
            for(int i = m2; i < m1; i++) {
                days += leapYearDaysOfMonth[i];
            }
            days = days - d2 + d1;
        }else {
            for(int i = m2; i < m1; i++) {
                days += daysOfMonth[i];
            }
            days = days - d2 + d1;
        }
        return Math.abs(days);
    }

    public static int countFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if(y1 >= y2) {
            if(y1 > y2) {
                return 10000;
            }
            else if(m1 > m2 && y1 == y2) {
                return 500*(m1 - m2);
            }
            else if(d1 > d2 && m1 == m2) {
                return 15 * countDays(m1, d1, m2, d2, y1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        System.out.println(countFine(d1,m1,y1,d2,m2,y2));
    }
}
