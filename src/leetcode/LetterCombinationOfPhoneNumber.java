package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
    	String str = "";
    	List<String> res = new LinkedList<String>();
    	if(digits.length()==0) return res;
        HashMap<Character,String> map = new HashMap<Character,String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        res = helper(map,digits,digits.length()-1,res);
        return res;
    }
    public static List<String> helper(HashMap<Character,String> map, String str, int index, List<String> res){
    	if(index==0){
    		char current = str.charAt(index);
    		String content = map.get(current);
    		String s = "";
    		for(int i=0;i<content.length();i++){
    			s+=content.charAt(i);
    			res.add(new String(s));
    			s="";
    		}
    		return res;
    	}
    	List<String> subres = helper(map,str,index-1,res);
    	List<String> newres = new LinkedList<String>();
    	char current = str.charAt(index);
    	String content = map.get(current);
    	for(int i=0;i<content.length();i++){
    		for(String sub:subres){
    			String newsub = sub;
    			newsub+=content.charAt(i);
    			newres.add(newsub);
    		}
    	}
    	return newres;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = letterCombinations("23");
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}

}
