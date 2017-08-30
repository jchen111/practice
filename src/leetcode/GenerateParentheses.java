package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<String>();
    	if(n==0){
    		return result;
    	}
    	int leftnumber = n;
    	int rightnumber = n;
    	char[] current = new char[n*2];
    	buildRest(leftnumber,rightnumber,current,result,0);
    	return result;
    }
    public static void buildRest(int leftnumber, int rightnumber, char[] current, List<String> result, int count){
    	if(leftnumber==0 && rightnumber==0){
    		result.add(new String(current));
    		return;
    	}
    	if(leftnumber>0){
    		current[count]='(';
    		buildRest(leftnumber-1,rightnumber,current,result,count+1);
    	}
    	if(rightnumber>leftnumber){
    		current[count]=')';
    		buildRest(leftnumber,rightnumber-1,current,result,count+1);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> result = generateParenthesis(3);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}

}
