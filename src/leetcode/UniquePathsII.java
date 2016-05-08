package leetcode;

public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1) return 0;
        obstacleGrid[0][0]=1;
        for(int i=1;i<column;i++){
        	if(obstacleGrid[0][i]==1)
        		obstacleGrid[0][i]=0;
        	else
        		obstacleGrid[0][i]=obstacleGrid[0][i-1];
        }
        for(int i=1;i<row;i++){
        	if(obstacleGrid[i][0]==1)
        		obstacleGrid[i][0]=0;
        	else
        		obstacleGrid[i][0]=obstacleGrid[i-1][0];
        }
        for(int i=1;i<row;i++){
        	for(int j=1;j<column;j++){
        		if(obstacleGrid[i][j]==1){
        			obstacleGrid[i][j]=0;
        		}else
        			obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
        	}
        }
        return obstacleGrid[row-1][column-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
