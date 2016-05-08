package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        if(row==0 && col==0) return false;
        boolean[][] visited = new boolean[row][col];
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(dfs(visited,board,0,i,j,word))
        			return true;
        	}
        }
        return false;
    }
    public static boolean dfs(boolean[][] visited, char[][] board,int index, int row, int col,String word){
    	if(index==word.length())
    		return true;
    	if(row > board.length-1 || col > board[0].length-1 || row<0 || col<0)
    		return false;
    	if(visited[row][col])
    		return false;
    	if(board[row][col]!=word.charAt(index))
    		return false;
    	visited[row][col] = true;
    	boolean res = (dfs(visited,board,index+1,row,col+1,word) || dfs(visited,board,index+1,row+1,col,word)
    			|| dfs(visited,board,index+1,row-1,col,word) || dfs(visited,board,index+1,row,col-1,word));
    	visited[row][col] = false;
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
