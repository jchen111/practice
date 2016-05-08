package leetcode;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        if(grid==null) return 0;
    	int row = grid.length;
        int column = grid[0].length;
        for(int i=1;i<column;i++){
        	grid[0][i]+=grid[0][i-1];
        }
        for(int j=1;j<row;j++){
        	grid[j][0] += grid[j-1][0];
        }
        for(int i=1;i<row;i++){
        	for(int j=1;j<column;j++){
        		grid[i][j] +=Math.min(grid[i-1][j], grid[i][j-1]);
        	}
        }
        return grid[row-1][column-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
