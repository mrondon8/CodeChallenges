package com.leetcode.interview;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int x = 0, y = 0, grid[][] = new int[n][n];
        grid[0][0] = 1;
        for(int i = 1; i < n*n; ){
        	//try to go right down left up repeat
        	while(y+1 < n && grid[x][y+1]<1){
        		y++;
        		grid[x][y] = ++i;
        	}
        	while(x+1 < n && grid[x+1][y]<1){
        		x++;
    			grid[x][y] = ++i;
        	}
        	while(y-1 >= 0 && grid[x][y-1]<1){
        		y--;
    			grid[x][y] = ++i;
        	}
        	while(x-1 >= 0 && grid[x-1][y]<1){
        		x--;
        		grid[x][y] = ++i;
        	}
        	printGrid(grid);
        	System.out.println("");
        }
        return grid;
    }
    
    public void printGrid(int[][] grid){
		for(int[] r : grid){
			for(int e : r)
				System.out.print(e + " ");
			System.out.println("");
		}
    }
    
    public static void main(String[] args) {
		GenerateMatrix a = new GenerateMatrix();
		int[][] grid = a.generateMatrix(4);
		
		a.printGrid(grid);
				
	}
}
