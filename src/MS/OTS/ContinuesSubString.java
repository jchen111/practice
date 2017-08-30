package MS.OTS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContinuesSubString {
    public static List<String> continuesSubstring(String str) {
        List<String> result = new ArrayList<>();
        String tmp = "";
        for(int i = 0; i < str.length() - 1; i++) {
            tmp = "" + str.charAt(i);
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(j) - str.charAt(j-1) == 1){
                    tmp += str.charAt(j);
                    if(j - i >= 1) result.add(tmp);
                }else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> solution = continuesSubstring(str);
        System.out.println(solution);
    }
}
