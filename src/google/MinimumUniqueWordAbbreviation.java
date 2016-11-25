package google;

import java.util.*;

/**
 * Created by jiaqichen on 11/22/16.
 */
public class MinimumUniqueWordAbbreviation {
    static class Abbrv{
        int length;
        String abbrv;
        Abbrv(String abbrv, int length){
            this.length = length;
            this.abbrv = abbrv;
        }
    }
    static final Set<Character> numbers = new HashSet<Character>(Arrays.asList('0','1', '2','3','4','5','6','7','8','9'));
    static PriorityQueue<Abbrv> abbreviations;
    public static String minAbbreviation(String target, String[] dictionary) {
        abbreviations = new PriorityQueue<Abbrv>(new Comparator<Abbrv>() {
            @Override
            public int compare(Abbrv o1, Abbrv o2) {
                if(o1.length > o2.length) return 1;
                else if(o1.length < o2.length) return -1;
                else return 0;
            }
        });
        getAbbreviations(target, new StringBuilder(), 0, 0);

        while(!abbreviations.isEmpty()){
            String tmp = abbreviations.poll().abbrv;
            boolean valid = true;
            for(String w : dictionary){
                if(validWordAbbreviation(w,tmp)) valid = false;
            }
            if(valid) return tmp;
        }
        return "";
    }

    public static void getAbbreviations(String target, StringBuilder abrv, int length, int index){
        if(index == target.length()){
            abbreviations.add(new Abbrv(abrv.toString(),length));
            return;
        }
        if(index > 0){
            int i = abrv.length();
            int num = 1;
            int len = length;
            StringBuilder sb = new StringBuilder(abrv);
            while(i > 0 && numbers.contains(sb.charAt(i-1))){
                i--;
            }
            if(i != abrv.length()){
                num = Integer.valueOf(sb.substring(i,abrv.length()));
                sb.delete(i,abrv.length());
                num++;
            }else{
                len += 1;
            }
            sb.append(""+num);
            getAbbreviations(target,sb,len,index+1);
            sb = new StringBuilder(abrv);
            sb.append(target.charAt(index));
            getAbbreviations(target, sb, length+1, index+1);

        }else{
            StringBuilder sb = new StringBuilder(abrv);
            sb.append(target.charAt(index));
            getAbbreviations(target, sb, length+1, index+1);
            sb = new StringBuilder(abrv);
            sb.append('1');
            getAbbreviations(target, sb, length+1, index+1);
        }
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while(i < abbr.length() && j < word.length()){
            int start = i;
            int num = 0;
            while(i < abbr.length() && abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9'){
                if(abbr.charAt(i) == '0' && (i <= 0 || !(abbr.charAt(i-1) >= '1' && abbr.charAt(i-1) <= '9'))) return false;
                i++;
            }
            if(start != i){
                num = Integer.valueOf(abbr.substring(start,i));
                if(j + num > word.length()){
                    return false;
                }
                j += num;
            }else{
                if(abbr.charAt(i) != word.charAt(j)) return false;
                i++;
                j++;
            }

        }
        return i == abbr.length() && j == word.length();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
       System.out.println( minAbbreviation(target,new String[]{}));
    }
}
