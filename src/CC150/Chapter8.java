package CC150;
import java.util.ArrayList;
import java.util.Arrays;


public class Chapter8 {
	/* solution for 8.1 generate the nth fibonacci number*/
	public static int nthFibonacci(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 1;
		}
		
		return nthFibonacci(n-1)+nthFibonacci(n-2);
	}
	/* solution for 8.2 how many possible paths for the robot 
	 * follow up if we have some pot robot can not step on them*/
	public static int possiblePaths(int row, int column, ArrayList<Integer[]> stophop){
		if(row==0 && column==0){
			return 1;
		}
		for(int i=0;i<stophop.size();i++){
			if(row==stophop.get(i)[0] && column==stophop.get(i)[1]){
				return 0;
			}
		}
		if(row==0 && column!=0){
			return possiblePaths(row,column-1,stophop);
		}
		if(column==0 && row!=0){
			return possiblePaths(row-1,column,stophop);
		}
		return possiblePaths(row-1,column,stophop)+possiblePaths(row,column-1,stophop);
	}
	/* solution for 8.3 write all subset of a set*/
	public static ArrayList<ArrayList<Integer>> AllSubset(ArrayList<Integer> s,int index){
		ArrayList<ArrayList<Integer>> newSubSet;
		if(s.size() == index){
			newSubSet = new ArrayList<ArrayList<Integer>>();
			newSubSet.add(new ArrayList<Integer>());
		}else{
			newSubSet = AllSubset(s,index+1);
			int item = s.get(index);
			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset:newSubSet){
				ArrayList<Integer> neww = new ArrayList<Integer>();
				neww.addAll(subset);
				neww.add(item);
				moreSubSets.add(neww);
			}
			newSubSet.addAll(moreSubSets);
		}
		
		return newSubSet;
	}
	/* solution for 8.3 write a method that returns all subsets of a set*/
	public static ArrayList<String> permutations(String s){
		int length = s.length();
		ArrayList<String> result;
		if(length==1){
			result = new ArrayList<String>();
			result.add(s);
			return result;
		}
		String s2 = s.substring(1, length);
		result = permutations(s2);
		ArrayList<String> next_result = new ArrayList<String>();
		for(int i=0;i<result.size();i++){
			for(int j=0;j<=result.get(i).length();j++){
				String newstring = result.get(i).substring(0, j)+s.charAt(0)+result.get(i).substring(j);
				if(!next_result.contains(newstring)){
					next_result.add(newstring);
				}
			}
		}
		return next_result;
	}
	/* solution for 8.5 implement an algorithm to print all valid
	 * combinations of n-pairs of parentheses*/
	public static ArrayList<String> allValidCombinations(int pairs){
		ArrayList<String> result;
		if(pairs==1){
			result = new ArrayList<String>();
			result.add("()");
			return result;
		}
		ArrayList<String> next_result = allValidCombinations(pairs-1);
		result = new ArrayList<String>();
		for(String sub:next_result){
			String newString = "";
			newString = "("+sub+")";
			result.add(newString);
			newString = "";
			newString = "()"+sub;
			if(!result.contains(newString)){
				result.add(newString);
			}
			newString = "";
			newString = sub+"()";
			if(!result.contains(newString)){
				result.add(newString);
			}
		}
		return result;
	}
	/* solution for 8.7 write code to calculate the number
	 * of ways of representing n cents*/
	public static int makeChange(int n, int denom) { 
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
	        break;
	    case 10:
	    	next_denom = 5;
	        break;
	    case 5:
	    	next_denom = 1;
	        break;
	    case 1:
	    	return 1; }
	int ways = 0; 
	for(int i=0;i*denom<=n;i++){
		ways += makeChange(n - i * denom, next_denom); 
		}
	return ways; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1;i<20;i++){
//			System.out.print(nthFibonacci(i)+" ");
//		}
//		ArrayList<Integer[]> stophop = new ArrayList<Integer[]>();
//		stophop.add(new Integer[]{1,2});
//		System.out.println(possiblePaths(2,2,stophop));
//		ArrayList<Integer> set = new ArrayList<Integer>();
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//		set.add(1);set.add(2);set.add(3);
//		result = AllSubset(set,0);
//		for(int i=0;i<result.size();i++){
//			for(int j =0;j<result.get(i).size();j++){
//				System.out.print(result.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
//		String s1= "123";
//		ArrayList<String> result = new ArrayList<String>();
//		result = permutations(s1);
//		for(int i=0;i<result.size();i++){
//			System.out.println(result.get(i));
//		}
//		ArrayList<String> result = allValidCombinations(2);
//		for(String string:result){
//			System.out.println(string);
//		}
		System.out.println(makeChange(15,25));
	}

}
