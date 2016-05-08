package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	static int columnForRow[] = new int[8];
	static int N;
	public static boolean check(int row){
		for(int i=0;i<row;i++){
			int diff = Math.abs(columnForRow[row]-columnForRow[i]);
			if(diff==0 || diff==row-i){
				return false;
			}
		}
		return true;
	}
    public static List<String[]> solveNQueens(int n) {
    	N=n;
        List<String[]> res = new ArrayList<String[]>();
        helper(0,res);
        return res;
    }
    public static void helper(int row, List<String[]> res){
    	if(row==N){
    		String[] newboard = new String[N];
    		for(int i=0;i<N;i++){
    			StringBuilder strRow = new StringBuilder();
    			for(int j=0;j<N;j++){
    				if(columnForRow[i]==j)
    					strRow.append("Q");
    				else
    					strRow.append(".");
    			}
    			newboard[i] = strRow.toString();
    		}
    		res.add(newboard);
    		return;
    	}
    	for(int i=0;i<N;i++){
    		columnForRow[row]=i;
    		if(check(row)){
    			helper(row+1,res);
    		}else
    			columnForRow[row]=0;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
