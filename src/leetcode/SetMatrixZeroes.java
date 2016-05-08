package leetcode;

import java.util.Hashtable;

public class SetMatrixZeroes {
//	public  static void setZeroes(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        Hashtable<Integer,Boolean> rowtable = new Hashtable<Integer,Boolean>();
//        Hashtable<Integer,Boolean> coltable = new Hashtable<Integer,Boolean>();
//        for(int i=0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		if(matrix[i][j]==0){
//        			rowtable.put(i, true);
//        			coltable.put(j, true);
//        		}
//        	}
//        }
//        for(int i=0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		if(rowtable.containsKey(i) || coltable.containsKey(j)){
//        			matrix[i][j]=0;
//        		}
//        	}
//        }
//    }
	public  static void setZeroes(int[][] matrix) {
		int row = matrix.length-1;
		int col = matrix[0].length-1;
		while(row>=0){
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,0,0,5},
						  {4,3,1,4},
						  {0,1,1,4},
						  {1,2,1,3},
						  {0,0,1,1}};
//		int[][] matrix = {{0,1}};
		setZeroes(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
