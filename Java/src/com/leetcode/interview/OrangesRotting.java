package com.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class OrangesRotting {
	public int orangesRotting(int[][] grid) {
		int day = 0, rowLen = grid.length, colLen = grid[0].length;

		if (countFresh(grid) == 0)
			return 0;

		for (; day < 99; day++) {
			int[][] tempGrid = new int[rowLen][colLen];

			for (int i = 0; i < rowLen; i++)
				for (int j = 0; j < colLen; j++)
					if (grid[i][j] == 1 && getNeighbors(grid, i, j).contains(2))
						tempGrid[i][j] = 2;
					else
						tempGrid[i][j] = grid[i][j];

			if (countFresh(tempGrid) == 0)
				return day + 1;

			grid = tempGrid;

		}

		return -1;
	}

	public int countFresh(int[][] grid) {
		int count = 0;
		for (int[] a : grid)
			for (int b : a)
				count += b & 1;
		return count;
	}

	public List<Integer> getNeighbors(int[][] grid, int x, int y) {
		int rowLen = grid.length, colLen = grid[0].length;
		List<Integer> neighbors = new ArrayList<>();
		// up
		if (y - 1 >= 0)
			neighbors.add(grid[x][y - 1]);
		// down
		if (y + 1 < colLen)
			neighbors.add(grid[x][y + 1]);
		// left
		if (x - 1 >= 0)
			neighbors.add(grid[x - 1][y]);
		// right
		if (x + 1 < rowLen)
			neighbors.add(grid[x + 1][y]);
		return neighbors;
	}

	public boolean isSolveable(int[][] grid) {
		int rowLen = grid.length, colLen = grid[0].length;
		for (int i = 0; i < rowLen; i++)
			for (int j = 0; j < colLen; j++)
				if (grid[i][j] == 1 && getNeighbors(grid, i, j).size() > 0)
					return false;

		return countFresh(grid) > 0;
	}

	public static void main(String[] args) {
		OrangesRotting a = new OrangesRotting();
		int[][] grid = new int[5][4];
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				grid[i][j] = (int) (Math.random() * 3);

		System.out.println(a.orangesRotting(grid));
	}
}
